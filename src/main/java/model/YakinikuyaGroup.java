package model;

public class YakinikuyaGroup {

	//フィールドで必要なものを定義
	private final String groupName;
	private final Restaurant[] restaurants;
	private static final int MAX_RESTAURANTS = 10;
	private int restaurantCount;

	//焼肉屋でグループで共通の商品を定義するためのフィールド
	private final MenuItem[] commonMenuItems;
	private static final int MAX_COMMON_MENU_ITEMS = 10;

	//コンストラクタを作成
	public YakinikuyaGroup(String groupName){
		this.groupName = groupName;
		this.restaurants = new Restaurant[MAX_RESTAURANTS];
		this.restaurantCount = 0;

		//共通メニューの初期化
		this.commonMenuItems = new MenuItem[MAX_COMMON_MENU_ITEMS];
	}

	//getterでしかとれないようにグループ名の設定
	public String getGroupName(){
		return groupName;
	}

	//共通メニューを追加するメソッド（業務ルールはmodelが持つ）
	public void addCommonMenuItem(String name, int price){
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("メニュー名は不正です");
		}
		if( price <= 0) {
			throw new IllegalArgumentException("価格は正の整数でなければなりません");
		}
		for (int i = 0; i < commonMenuItems.length; i++) {
			if (commonMenuItems[i] == null) {
				commonMenuItems[i] = new MenuItem(name, price);
				return;
			}
		}
		throw new IllegalStateException("共通メニューをこれ以上追加できません");
	}

	//共通メニューを削除するメソッド
	public void removeCommonMenuItem(String name){
		for (int i = 0; i < commonMenuItems.length; i++) {
			MenuItem item = commonMenuItems[i];
			if (item != null && item.getName().equals(name)) {
				commonMenuItems[i] = null;
				return;
			}
		}
		throw new IllegalArgumentException("指定した共通メニューが見つかりません");
	}

	//共通メニューも取れるように追加
	//配列を直接返すのは安全ではないため、コピーを返すようにする
	public MenuItem[] getCommonMenuItems(){
		return commonMenuItems.clone();
	}

	//外から配列を取れるように追加
	//配列を直接返すのは安全ではないため、コピーを返すようにする
	public Restaurant[] getRestaurants(){
		return restaurants.clone();
	}

	//外から店舗数を把握確認できる
	public int getRestaurantCount(){
		return restaurantCount;
	}

	//店舗を最大10件までもてるようにするためのメソッドを作成
	public void addRestaurant(Restaurant restaurant){
		if( restaurantCount < MAX_RESTAURANTS){
			restaurants[restaurantCount] = restaurant;
			restaurantCount++;
			return;
		}
		else{
			throw new IllegalStateException("これ以上店舗はもてません");
		}
	}

}
