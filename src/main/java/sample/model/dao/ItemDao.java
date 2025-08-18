/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：ItemDao
 * 作成日  ：2025/04/01
 * 作成者  ：FLM Uzawa
 *------------------------------------------------------------------------------
 * 修正履歴 (修正日：担当者：修正内容)
 *------------------------------------------------------------------------------
 */
package sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sample.model.data.Item;

/**
 * 商品テーブルDAOクラス
 */
public class ItemDao {

	/**
	 * DB接続情報
	 */
	private Connection con = null;

	/**
	 * コンストラクタ
	 * @param con DB接続情報
	 */
	public ItemDao(Connection con) {
		super();
		this.con = con;
	}
	
	/**
	 * 商店ID、商品IDをキーに商品テーブルを検索する。
	 * @param shopId 商店ID 
	 * @param itemId 商品ID
	 * @return 商品情報リスト
	 * @throws SQLException DBエラーが発生した場合
	 */
	public Item select(int shopId, int itemId) throws SQLException {
		
		String sql = "SELECT shop_id, item_id, item_name, item_describe, item_price FROM item"
				+ " WHERE shop_id = ? AND item_id = ?";

		Item item = null;
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setInt(1, shopId);
			stmt.setInt(2, itemId);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				item = new Item();
				item.setShopId(rs.getInt("shop_id"));
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDescribe(rs.getString("item_describe"));
				item.setItemPrice(rs.getInt("item_price"));
			}
		}
		
		return item;
		
	}
	
	/**
	 * 商品テーブルにレコードを追加する。
	 * @param item 商品情報
	 * @return 採番された商品ID
	 * @throws SQLException DBエラーが発生した場合
	 */
	public int insert(Item item) throws SQLException {

		int itemId = selectNewItemId(item.getShopId());
		item.setItemId(itemId);
		
		String sql = "INSERT INTO item(shop_id, item_id, item_name, item_describe, item_price)"
				+ " VALUES(?, ?, ?, ?, ?)";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, item.getShopId());
			stmt.setInt(2, item.getItemId());
			stmt.setString(3, item.getItemName());
			stmt.setString(4, item.getItemDescribe());
			stmt.setInt(5, item.getItemPrice());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
		
		return itemId;
		
	}
	
	/**
	 * 商品テーブルにレコードを追加する際の、商品IDを採番（引数で指定された商店IDのレコードの最大商品ID＋1）する。 
	 * @param shopId 商店ID
	 * @return 採番した商品ID
	 * @throws SQLException DBエラーが発生した場合
	 */
	public int selectNewItemId(int shopId) throws SQLException {
		
		String sql = "SELECT ifnull(max(item_id) + 1, 1) AS item_id FROM item WHERE shop_id = ? FOR UPDATE";
		int itemId = 1;
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setInt(1, shopId);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				itemId = rs.getInt("item_id");
			}
		}

		return itemId;
		
	}
	
	/**
	 * 商品テーブルのレコードを更新する。
	 * @param item 商品情報
	 * @throws SQLException DBエラーが発生した場合
	 */
	public void update(Item item) throws SQLException {
		
		String sql = "UPDATE item set item_name = ?, item_describe = ?, item_price = ?"
				+ " WHERE shop_id = ? AND item_id = ?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, item.getItemName());
			stmt.setString(2, item.getItemDescribe());
			stmt.setInt(3, item.getItemPrice());
			stmt.setInt(4, item.getShopId());
			stmt.setInt(5, item.getItemId());
			
			stmt.executeUpdate();
		
		}
		
	}
	
}
