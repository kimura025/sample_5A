<%------------------------------------------------------------------------------
  演習番号  ：プロトタイプ演習
  JSP名     ：home.jsp
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
    <title>商品情報</title>
</head>
<body class="body">
<%-- ヘッダーのinclude --%>
<jsp:include page="./include/header.jsp" flush="true" />
<main class="container mx-auto main"">
    <header class="row mb-3 mt-2">
		<h1>商品情報</h1>
    </header>
	<form method="post">
		<div class="card mb-3">
			<div class="card-header">商店選択</div>
			<div class="card-body">
				<div class="gap-2 d-md-flex">
					<select id="shop_selector" class="form-select w-75" name="shop_select"></select>
					<button id="item_add" class="btn btn-primary mt-2" type="submit" formaction="./add">
						商品追加</button>
				</div>
			</div>
		</div>
		<div class="card mb-3" id="item_info">
			<div class="card-header">商品選択</div>
			<div class="card-body" >
				<div class="gap-2 d-md-flex">
					<select id="item_selector" class="form-select w-75" name="item_select"></select>
					<button id="item_edit" class="btn btn-primary mt-2" type="submit" formaction="./edit">
						商品編集</button>
				</div>
				<div id="item_detail_area" >
					<table class="table table-striped-columns mt-2 w-75">
						<tr>
							<th class="table-primary w-25">ID</th>
							<td id="item_id"></td>
						</tr>
						<tr>
							<th class="table-primary w-25">名称</th>
							<td id="item_name"></td>
						</tr>
						<tr>
							<th class="table-primary w-25">説明</th>
							<td id="item_describe"></td>
						</tr>
						<tr>
							<th class="table-primary w-25">価格</th>
							<td id="item_price"></td>
						</tr>
					</table>
				</div>
			</div>
			<div id="item_not_exists_area" class="card-body" >
				<div class="gap-2 d-md-flex">
					<span>商品は存在しません。</span>
				</div>
			</div>
		<div>
	</form>
</main>
<%-- 共通jsファイルの読み込み --%>
<jsp:include page="./include/jsfile.jsp" flush="true" />
<%-- ページ固有jsファイルの読み込み --%>
<script src="./static/js/home.js"></script>
<%-- サーブレットでリクエストに設定した値のjs変数への設定 --%>
<script>
	// サーブレットでリクエストに設定した値のjs変数への設定 
	const params = {
		// shopリストのjsonオブジェクト
		shops : ${shopList},
		// shopセレクトボックスの復元用shopId
		selectedShopId : ${selectedShopId},
		// itemセレクトボックスの復元用itemId
		selectedItemId : ${selectedItemId}
	}
	// shopセレクトボックスの初期化処理の呼び出し
	initShopSelect();
</script>
</body>
</html>
