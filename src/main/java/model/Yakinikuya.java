package model;

public class Yakinikuya {

	//フィールドで必要なものを定義
	private final String groupName;
	private final Restaurant[] restaurants;
	private static final int MAX_RESTAURANTS = 10;
	private int restaurantCount;

	//焼肉屋でグループで共通の商品を定義するためのフィールド
	private MenuItem[] commonMenuItems;
	private static final int MAX_COMMON_MENU_ITEMS = 10;

	//コンストラクタを作成
	public Yakinikuya(String groupName){
		this.groupName = groupName;
		this.restaurants = new Restaurant[MAX_RESTAURANTS];
		this.restaurantCount = 0;

		//共通メニューの初期化
		this.commonMenuItems = new MenuItem[MAX_COMMON_MENU_ITEMS];
	}

	//10件までしか登録できないようにする
	public boolean addRestaurant(Restaurant restaurant){
		if(restaurantCount < restaurants.length){
			restaurants[restaurantCount] = restaurant;
			restaurantCount++;
			return true;
		}
		else{
			throw new IllegalStateException("これ以上店舗を追加できません");
		}
	}

	//getterでしかとれないようにグループ名の設定
	public String getGroupName(){
		return groupName;
	}

	//共通メニューも取れるように追加
	public MenuItem[] getCommonMenuItems(){
		return commonMenuItems;
	}
}
