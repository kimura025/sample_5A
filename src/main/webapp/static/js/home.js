// shopセレクトボックス
let shopSelect = document.querySelector("#shop_selector");

// shopセレクトボックスに選択値が変更されたら
// itemセレクトボックスの初期化関数を呼び出すよう、イベントリスナに登録
shopSelect.addEventListener("change", () => initItemSelect());

// itemセレクトボックス
let itemSelect = document.querySelector("#item_selector");

// itemセレクトボックスに選択値が変更されたら
// itemセレクトボックスの初期化関数を呼び出すよう、イベントリスナに登録
itemSelect.addEventListener("change", () => initItemDetail());

// shopセレクトボックスの初期化
function initShopSelect() {

	// shopリストのjsonオブジェクトの情報をもとに、
	// option要素を動的に生成し、shopセレクトボックスに追加
	params.shops.forEach(shop => {
		let opt = document.createElement("option");
		opt.value = shop.shopId;
		opt.textContent = shop.shopName;
		// 商品追加・編集画面からの遷移した場合の
		// 選択状態を復元するための処理
		if (shop.shopId == params.selectedShopId) {
			opt.selected = true;
		}
		shopSelect.appendChild(opt);
	});

	// 商品セレクトボックスの初期化
	initItemSelect();
}

// itemセレクトボックスの初期化関数
function initItemSelect(){
	// itemセレクトボックス内のoption要素をすべて削除
	while(itemSelect.firstChild){
		itemSelect.removeChild(itemSelect.firstChild);
    };
    // shopセレクトボックスで選択されたshopをjsonオブジェクトから取得
	const shopId = shopSelect.value;
	const selectedShop = params.shops.find(shop => shop.shopId == shopId);	
	let disabled = true;
	
	if (selectedShop.itemList.length > 0) {
		// 商品が存在する場合は、
		// option要素を動的に生成し、itemセレクトボックスに追加
		selectedShop.itemList.forEach(item => {
			let opt = document.createElement("option");
			opt.value = item.itemId;
			opt.textContent = item.itemName;
			// 商品追加・編集画面からの遷移した場合の
			// 選択状態を復元するための処理
			if (item.itemId == params.selectedItemId) {
				opt.selected = true;
			}
			itemSelect.appendChild(opt);			
		});
		disabled = false;
	}

	// 商品セレクトボックス・商品編集ボタンの活性化制御
	itemSelect.disabled = disabled;
	document.querySelector("#item_edit").disabled = disabled;
	
	// 商品詳細の初期化	
	initItemDetail();

}

// 商品詳細の初期化
function initItemDetail() {

	// 商品セレクトボックスで選択された商品の商品情報を取得
	const selectedShop = params.shops.find(shop => shop.shopId == shopSelect.value);	
	const selectedItem = selectedShop.itemList.find(item => item.itemId == itemSelect.value);	
	
	if (selectedItem) {
		// 商品が存在する場合
		// 表示領域に値を設定
		document.querySelector("#item_id").textContent = selectedItem.itemId;
		document.querySelector("#item_name").textContent = selectedItem.itemName;
		document.querySelector("#item_describe").textContent = selectedItem.itemDescribe;
		document.querySelector("#item_price").textContent = selectedItem.itemPrice;
		// 商品詳細情報を表示・商品が存在しない場合のメッセージを非表示
		document.querySelector("#item_detail_area").style.display = "block";
		document.querySelector("#item_not_exists_area").style.display = "none";
	} else {
		// 商品詳細情報を非表示・商品が存在しない場合のメッセージを表示
		document.querySelector("#item_detail_area").style.display = "none";
		document.querySelector("#item_not_exists_area").style.display = "block";
	}

}