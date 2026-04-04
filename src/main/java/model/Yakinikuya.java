package model;

public class Yakinikuya {

	private final Restaurant[] restaurants;
	private int restaurantCount;

	public Yakinikuya() {
		this.restaurants = new Restaurant[10];
		this.restaurantCount = 0;
	}

	public boolean addRestaurant(Restaurant restaurant) {
		if (restaurantCount >= restaurants.length) {
			return false;
		}
		restaurants[restaurantCount] = restaurant;
		restaurantCount++;
		return true;
	}

	public Restaurant[] getRestaurants() {
		return restaurants;
	}
}
