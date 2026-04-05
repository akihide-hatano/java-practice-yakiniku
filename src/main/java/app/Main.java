package app;

//modelのインポート
import model.Restaurant;
import model.YakinikuyaGroup;

//サービスのメソッドをimport
import service.MenuService;
import service.RestaurantService;

public class Main {
	public static void main(String[] args) {
// サービスを準備
        RestaurantService restaurantService = new RestaurantService();
        MenuService menuService = new MenuService();

        // グループを作成
        YakinikuyaGroup group = new YakinikuyaGroup("はたの焼肉グループ");

        // グループに店舗を追加
        restaurantService.addRestaurant(group, "炭火焼肉 はたの 梅田店", "大阪市北区");
        restaurantService.addRestaurant(group, "炭火焼肉 はたの 難波店", "大阪市中央区");

        // グループ共通メニューを追加
        menuService.addCommonMenuItem(group, "上カルビ", 980);
        menuService.addCommonMenuItem(group, "牛タン", 1200);

        // 特定の店舗に独自メニューを追加
        Restaurant[] restaurants = group.getRestaurants();
        menuService.addLocalMenuItem(restaurants[0], "梅田限定ホルモン", 750);

        // --- 表示 ---
        System.out.println("グループ名: " + group.getGroupName());
        restaurantService.displayRestrants(group);     // 店舗一覧
        menuService.displayCommonMenu(group);           // 共通メニュー
        menuService.displayLocalMenu(restaurants[0]);   // 梅田店の独自メニュー
	}
}

