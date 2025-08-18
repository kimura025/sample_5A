/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：AddItemCompleteController
 * 作成日  ：2025/04/01
 * 作成者  ：FLM Uzawa
 *------------------------------------------------------------------------------
 * 修正履歴 (修正日：担当者：修正内容)
 *------------------------------------------------------------------------------
 */
package sample.controller;

import static sample.model.constant.SystemConsts.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import sample.model.dao.ConnectionManager;
import sample.model.dao.ItemDao;
import sample.model.dao.ShopDao;
import sample.model.data.Item;
import sample.model.data.Shop;

/**
 * 商品追加完了サーブレット
 */
@WebServlet("/add-complete")
public class AddItemCompleteController extends HttpServlet {

	/**
	 * 画面で入力された商品情報を使用して商品テーブルに情報を登録後に、
	 * DBからすべての商店と紐づくすべての商品情報を取得し、JSON文字列に変換しリクエストに設定、
	 * 商品情報画面JSPを呼び出す。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String next = "/WEB-INF/view/home.jsp";

		Item item = new Item();
		item.setShopId(Integer.parseInt(req.getParameter("shop_id")));
		item.setItemName(req.getParameter("item_name"));
		item.setItemDescribe(req.getParameter("item_describe"));
		item.setItemPrice(Integer.parseInt(req.getParameter("item_price")));
		Boolean registTF = false;
		if(req.getParameter("item_regist") != null) {
		    registTF = true;
		}
		item.setItemRegist(registTF);

		try (Connection con = ConnectionManager.getConnection()){

			ItemDao itemDao = new ItemDao(con);
			int itemId = itemDao.insert(item);

			ShopDao dao = new ShopDao(con);
			List<Shop> shopList = dao.selectAll();

			ObjectMapper mapper = new ObjectMapper();
			String shopListJson = mapper.writeValueAsString(shopList);

			req.setAttribute("shopList", shopListJson);

			req.setAttribute("selectedShopId", item.getShopId());
			req.setAttribute("selectedItemId", itemId);

		} catch (SQLException e) {
			e.printStackTrace();
			next = ERROR_PAGE;
		}

		RequestDispatcher rd = req.getRequestDispatcher(next);
		rd.forward(req, resp);

	}

}
