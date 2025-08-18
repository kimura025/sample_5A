/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：EditItemController
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

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import sample.model.dao.ConnectionManager;
import sample.model.dao.ItemDao;
import sample.model.dao.ShopDao;
import sample.model.data.Item;
import sample.model.data.Shop;

/**
 * 商品編集画面遷移サーブレット
 */
@WebServlet("/edit")
public class EditItemController extends HttpServlet {

	/**
	 * 商品情報画面で選択された商店・商品IDをキーにDBから商店と紐づくすべての商品情報を取得し、
	 * 商品編集画面JSPを呼び出す。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String next = "/WEB-INF/view/edit.jsp";
		
		int shopId = Integer.parseInt(req.getParameter("shop_select"));
		int itemId = Integer.parseInt(req.getParameter("item_select"));
		
		try (Connection con = ConnectionManager.getConnection()){
			
			ShopDao shopDao = new ShopDao(con);
			Shop shop = shopDao.select(shopId);

			ItemDao itemDao = new ItemDao(con);
			Item item = itemDao.select(shopId, itemId);

			req.setAttribute("shop", shop);
			req.setAttribute("item", item);
			
		} catch (SQLException e) {
			e.printStackTrace();
			next = ERROR_PAGE;
		}

		RequestDispatcher rd = req.getRequestDispatcher(next);
		rd.forward(req, resp);

	}
	
}