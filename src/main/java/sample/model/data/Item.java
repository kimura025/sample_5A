/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：Item
 * 作成日  ：2025/04/01
 * 作成者  ：FLM Uzawa
 *------------------------------------------------------------------------------
 * 修正履歴 (修正日：担当者：修正内容)
 *------------------------------------------------------------------------------
 */
package sample.model.data;

/**
 * 商品情報クラス
 */
public class Item {

	/**
	 * 商店ID
	 */
	private int shopId;

	/**
	 * 商品ID
	 */
	private int itemId;
	
	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 商品説明
	 */
	private String itemDescribe;

	/**
	 * 商品価格
	 */
	private int itemPrice;
	
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
	 * 商品IDを取得する。
	 * @return 商品ID
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 商品IDを設定する。
	 * @param itemId 商品ID
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 商品名を取得する。
	 * @return 商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名を設定する。
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 商品説明を取得する。
	 * @return 商品説明
	 */
	public String getItemDescribe() {
		return itemDescribe;
	}

	/**
	 * 商品説明を設定する。
	 * @param itemDescribe 商品説明
	 */
	public void setItemDescribe(String itemDescribe) {
		this.itemDescribe = itemDescribe;
	}

	/**
	 * 商品価格を取得する。
	 * @return 商品価格
	 */
	public int getItemPrice() {
		return itemPrice;
	}

	/**
	 * 商品価格を設定する。
	 * @param itemPrice 商品価格
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
