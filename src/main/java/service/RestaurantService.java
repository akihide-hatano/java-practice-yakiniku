package service;

//importを追加
import model.Restaurant;
import model.YakinikuyaGroup;

public class RestaurantService {

	//店舗一件を表示
	public void displayRestrant(Restaurant restaurant){
		System.out.println( "店舗名" + restaurant.getStoreName());
		System.out.println( "店舗住所" + restaurant.getStoreAddress());
	}

	//for文で店舗一覧を表示
	public void displayRestrants(YakinikuyaGroup group){
		System.out.println("---- 店舗一覧 ----");
		Restaurant[] restaurants = group.getRestaurants();

		for (int i = 0; i < restaurants.length; i++) {
			if(restaurants[i] != null){
				System.out.println(restaurants[i].getStoreName());
				System.out.println(restaurants[i].getStoreAddress());
			}

		}
	}

	//店舗を作成するためのメソッドを作成
	public Restaurant createRestaurant(String name,String address){
		return new Restaurant(name, address);
	}

	//ちゃんと空白がありcreateRestaurantの引数が2つあるかどうかを確認するためのメソッドを作成
	public void addRestaurant(YakinikuyaGroup group,String name,String address){
		Restaurant restaurant = new Restaurant(name, address);
		group.addRestaurant(restaurant);
	}


}