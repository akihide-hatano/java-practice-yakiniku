package service;

import model.MenuItem;
import model.Restaurant;

public class MenuService {

	public MenuItem createMenuItem(String name, int price) {
		return new MenuItem(name, price);
	}

	public boolean addMenuItem(Restaurant restaurant, MenuItem menuItem) {
		MenuItem[] localMenuItems = restaurant.getLocalMenuItems();
		for (int i = 0; i < localMenuItems.length; i++) {
			if (localMenuItems[i] == null) {
				localMenuItems[i] = menuItem;
				return true;
			}
		}
		return false;
	}
}
