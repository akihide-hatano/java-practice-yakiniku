package model;

public class Yakinikuya {

	//フィールドで必要なものを定義
	private final String groupName;
	private final Restaurant[] restaurants;
	private int restaurantCount;

	//コンストラクタを作成
	public Yakinikuya(String groupName){
		this.groupName = groupName;
		this.restaurants = new Restaurant[10];
		this.restaurantCount = 0;
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

	//getterでしかとれないように設定
	public String getGroupName(){
		return groupName;
	}
}
