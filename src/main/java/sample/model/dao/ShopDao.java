/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：ShopDao
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
import java.util.ArrayList;
import java.util.List;

import sample.model.data.Item;
import sample.model.data.Shop;

/**
 * 商店テーブルDAOクラス
 */
public class ShopDao {

	/**
	 * DB接続情報
	 */
	private Connection con = null;

	/**
	 * コンストラクタ
	 * @param con DB接続情報
	 */
	public ShopDao(Connection con) {
		this.con = con;
	}
	
	/**
	 * 商店テーブルと商品テーブルから、すべての商店情報と商店に紐づくすべての商品情報を取得する。
	 * @return 商店に紐づく商品情報を保持した商店リスト
	 * @throws SQLException DBエラーが発生した場合
	 */
	public List<Shop> selectAll() throws SQLException {
		
		String sql = "SELECT"
				+ " shop.shop_id AS shop_id,"
				+ " shop_name,"
				+ " item_id,"
				+ " item_name,"
				+ " item_describe,"
				+ " item_price"
				+ " FROM shop"
				+ " LEFT OUTER JOIN item ON shop.shop_id = item.shop_id"
				+ " ORDER BY shop.shop_id, item_id";
		
		List<Shop> shopList = new ArrayList<>();
		List<Item> itemList = null;
		
		int lastShopId = 0;
		Shop shop = null;
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int shopId = rs.getInt("shop_id");
				
				if (lastShopId == 0 || shopId != lastShopId) {
					shop = new Shop();
					shop.setShopId(shopId);
					shop.setShopName(rs.getString("shop_name"));
					itemList = new ArrayList<>();
					shop.setItemList(itemList);
					shopList.add(shop);
				}
				
				int itemId = rs.getInt("item_id");
				if (itemId != 0) {
					Item item = new Item();
					item.setShopId(shopId);
					item.setItemId(itemId);
					item.setItemName(rs.getString("item_name"));					
					item.setItemDescribe(rs.getString("item_describe"));
					item.setItemPrice(rs.getInt("item_price"));
					itemList.add(item);
				}
				
				lastShopId = shopId;

			}
			
		}
		
		return shopList;
		
	}
	
	/**
	 * 商店IDをキーに商店テーブルを検索する。
	 * @param shopId 商店ID
	 * @return 商店情報
	 * @throws SQLException DBエラーが発生した場合
	 */
	public Shop select(int shopId) throws SQLException {
		
		String sql = "SELECT shop_id, shop_name FROM shop WHERE shop_id = ?";

		Shop shop = null;
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setInt(1, shopId);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				shop = new Shop();
				shop.setShopId(rs.getInt("shop_id"));
				shop.setShopName(rs.getString("shop_name"));
			}
		}
		
		return shop;
		
	}
	
}
