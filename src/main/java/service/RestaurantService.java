package service;


//importを追加
import model.*;


public class RestaurantService {

	//新しく店舗を作るために配列を定義
	private Restaurant[] restaurants;
	private int restaurantCount;

	//店舗を作成するためのメソッドを作成
	public Restaurant creaeRestaurant(String name,String address){
		return new Restaurant(name, address);
	}

	//ちゃんと空白がありcreateRestaurantの引数が2つあるかどうかを確認するためのメソッドを作成
	public boolean addRestrant(String name,String address){
		if( restaurants!= null){
			return true;
		}
		else{
			throw new IllegalStateException("店舗を作成できませんでした");
		}
	}
	//店舗を作成するためのメソッドを作成

}