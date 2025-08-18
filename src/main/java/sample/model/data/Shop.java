/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：Shop
 * 作成日  ：2025/04/01
 * 作成者  ：FLM Uzawa
 *------------------------------------------------------------------------------
 * 修正履歴 (修正日：担当者：修正内容)
 *------------------------------------------------------------------------------
 */
package sample.model.data;

import java.util.List;

/**
 * 商店情報クラス
 */
public class Shop {

	/**
	 * 商店ID
	 */
	private int shopId;
	
	/**
	 * 商店名
	 */
	private String shopName;
	
	/**
	 * 商品リスト
	 * 商店に紐づく商品のリスト
	 */
	private List<Item> itemList;

	/**
	 * 商店IDを取得する。
	 * @return 商店ID
	 */
	public int getShopId() {
		return shopId;
	}

	/**
	 * 商店IDを設定する。
	 * @param shopId 商店ID
	 */
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	/**
	 * 商店名を取得する。
	 * @return 商店名
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * 商店名を設定する。
	 * @param shopName 商店名
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * 商品リストを取得する。
	 * @return 商品リスト
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * 商品リストを設定する。
	 * @param itemList 商品リスト
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
