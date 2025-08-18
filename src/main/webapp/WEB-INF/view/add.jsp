<%------------------------------------------------------------------------------
  演習番号  ：プロトタイプ演習
  JSP名     ：add.jsp
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
    <title>商品追加</title>
</head>
<body class="body">
<%-- ヘッダーのinclude --%>
<jsp:include page="./include/header.jsp" flush="true" />
<main class="container mx-auto main"">
    <header class="row mb-3 mt-2">
        <h1>商品追加</h1>
    </header>
    <form method="post" action="./add-complete">
    	<input type="hidden" name="shop_id" value="<c:out value="${shop.shopId}" />">
		<div class="card mb-3">
			<div class="card-header"><c:out value="${shop.shopName}" />：商品情報入力</div>
			<div class="card-body">
				<div>
					<div class="mb-3">
		                <label class="form-label" for="item_name">名称：</label>
		                <input type="text" class="form-control" id="item_name" name="item_name"
		                maxlength="20" required>
	            	</div>
					<div class="mb-3">
		                <label class="form-label" for="item_describe">説明：</label>
		                <textarea class="form-control" id="item_describe" name="item_describe"
		                maxlength="200" required></textarea>
	            	</div>
					<div class="mb-3">
		                <label class="form-label" for="item_price">価格：</label>
		                <input type="number" class="form-control" id="item_price" name="item_price"
		                 min="1" max="9999999999" maxlength="10" required>
	            	</div>
				</div>
				<div class="d-md-flex justify-content-md-end">
					<button id="item_edit" type="submit" class="btn btn-primary">商品追加</button>
				</div>
			</div>
		<div>
	</form>
</main>
<%-- 共通jsファイルの読み込み --%>
<jsp:include page="./include/jsfile.jsp" flush="true" />
</body>
</html>
