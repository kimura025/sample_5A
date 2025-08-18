/*------------------------------------------------------------------------------
 * 演習番号：プロトタイプ演習
 * クラス名：ConnectionManager
 * 作成日  ：2025/04/01
 * 作成者  ：FLM Uzawa
 *------------------------------------------------------------------------------
 * 修正履歴 (修正日：担当者：修正内容)
 *------------------------------------------------------------------------------
 */
package sample.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sample.model.constant.SystemConsts;

/**
 * DB接続情報管理クラス
 */
public class ConnectionManager {
	
	/**
	 * DB接続情報取得。
	 * DBに接続し、接続を返却する。
	 * @return DB接続情報
	 * @throws SQLException 接続に失敗した場合
	 */
	public static Connection getConnection() throws SQLException{
		 Connection con = DriverManager.getConnection(
				 SystemConsts.JDBC_URL, SystemConsts.JDBC_USER, SystemConsts.JDBC_PASS);
		 return con;
	}

}
