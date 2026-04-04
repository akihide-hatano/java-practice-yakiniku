package service;

import model.Restaurant;

public class RestaurantService {

	public Restaurant createRestaurant(String name, String address) {
		return new Restaurant(name, address);
	}
}
