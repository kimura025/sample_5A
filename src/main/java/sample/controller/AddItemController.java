/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：AddItemController
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
import sample.model.dao.ShopDao;
import sample.model.data.Shop;

/**
 * 商品追加画面遷移サーブレット
 */
@WebServlet("/add")
public class AddItemController extends HttpServlet {

	/**
	 * 商品情報画面で選択された商店IDをキーにDBから商店情報を取得し、商品追加画面JSPを呼び出す。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String next = "/WEB-INF/view/add.jsp";
		
		int shopId = Integer.parseInt(req.getParameter("shop_select"));
		
		try (Connection con = ConnectionManager.getConnection()){
			
			ShopDao dao = new ShopDao(con);
			Shop shop = dao.select(shopId);

			req.setAttribute("shop", shop);
			
		} catch (SQLException e) {
			e.printStackTrace();
			next = ERROR_PAGE;
		}

		RequestDispatcher rd = req.getRequestDispatcher(next);
		rd.forward(req, resp);

	}
	
}
