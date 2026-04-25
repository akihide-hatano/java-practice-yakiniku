package model;

public class YakinikuyaGroup {

	//フィールドで必要なものを定義
	private final String groupName;
	private final Restaurant[] restaurants;
	private static final int MAX_RESTAURANTS = 10;
	private int restaurantCount;

	//焼肉屋でグループで共通の商品を定義するためのフィールド
	private MenuItem[] commonMenuItems;
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
	public int getrestaurantCount(){
		return restaurantCount;
	}

	//店舗を最大10件までもてるようにするためのメソッドを作成
	public boolean addRestaurant(Restaurant restaurant){
		if( restaurantCount < MAX_RESTAURANTS){
			restaurants[restaurantCount] = restaurant;
			restaurantCount++;
			return true;
		}
		else{
			throw new IllegalStateException("これ以上店舗はもてません");
		}
	}

}
