/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：SystemConsts
 * 作成日  ：2025/04/01
 * 作成者  ：FLM Uzawa
 *------------------------------------------------------------------------------
 * 修正履歴 (修正日：担当者：修正内容)
 *------------------------------------------------------------------------------
 */
package sample.model.constant;

/**
 * 定数クラス
 */
public interface SystemConsts {

	/**
	 * JDBC URL
	 */
	String JDBC_URL = 
			"jdbc:mysql://localhost:3306/sampledb"
			+ "?useSSL=false&allowPublicKeyRetrieval=true";
	
	/**
	 * DBユーザ
	 */
	String JDBC_USER = "app_user";
	
	/**
	 * DBユーザパスワード
	 */
	String JDBC_PASS = "password";
	
	/**
	 * システムエラー画面JSP
	 */
	String ERROR_PAGE = "/WEB-INF/view/error.jsp";

	
	
	
}
