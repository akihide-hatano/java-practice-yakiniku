package app;

import model.MenuItem;
import model.Restaurant;
import service.MenuService;
import service.RestaurantService;

public class Main {
	public static void main(String[] args) {
		RestaurantService restaurantService = new RestaurantService();
		MenuService menuService = new MenuService();

		Restaurant restaurant = restaurantService.createRestaurant("炭火焼肉 はたの", "大阪市");
		MenuItem kalbi = menuService.createMenuItem("上カルビ", 980);
		menuService.addMenuItem(restaurant, kalbi);

		System.out.println("店舗名: " + restaurant.getName());
	}
}
