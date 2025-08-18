<%------------------------------------------------------------------------------
  演習番号  ：プロトタイプ演習
  JSP名     ：error.jsp
  作成日    ：2025/04/01
  作成者    ：FLM Uzawa
  ------------------------------------------------------------------------------
  修正履歴 (修正日：担当者：修正内容)
  ------------------------------------------------------------------------------%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<%-- <head>タグ内定義情報のinclude --%>
	<jsp:include page="./include/headcontent.jsp" flush="true" />
    <title>システムエラー</title>
</head>
<body class="body">
<%-- ヘッダーのinclude --%>
<jsp:include page="./include/header.jsp" flush="true" />
<main class="container mx-auto main"">
    <h3>システムエラーが発生しました。</h3>
    <span>システム管理者にお問い合わせください。</span>	
</main>
<%-- 共通jsファイルの読み込み --%>
<jsp:include page="./include/jsfile.jsp" flush="true" />
</body>
</html>