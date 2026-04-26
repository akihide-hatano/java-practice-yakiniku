package app;

//modelのインポート
import model.Restaurant;
import model.YakinikuyaGroup;
import model.User;

//サービスのメソッドをimport
import service.MenuService;
import service.RestaurantService;

//DB接続のクラスをimport
import repository.DBConnection;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;

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
        menuService.addLocalMenuItem(restaurants[1], "難波限定ホルモン", 800);

        // --- 表示 ---
        System.out.println("グループ名: " + group.getGroupName());
        restaurantService.displayRestrants(group);     // 店舗一覧

        // 共通メニューを表示
        System.out.println("\n--- 共通メニュー ---");
        for(model.MenuItem item : menuService.getCommonMenuItems(group)){
                if(item != null){
                System.out.println(item.getName() + ": " + item.getPrice() + "円");
        }
        }

        // 店舗独自メニューを表示
        System.out.println("\n--- 店舗独自メニュー (梅田店) ---");
        for(model.MenuItem item : menuService.getLocalMenuItems(restaurants[0])){
                if(item != null){
                System.out.println(item.getName() + ": " + item.getPrice() + "円");
        }
        }

        //店舗独自メニューを全て表示
        System.out.println("\n--- 店舗独自メニュー (全店舗) ---");
        for(Restaurant restaurant : restaurants){
                if(restaurant != null){
                System.out.println("店舗: " + restaurant.getStoreName());
                for(model.MenuItem item : menuService.getLocalMenuItems(restaurant)){
                        if(item != null){
                        System.out.println("  " + item.getName() + ": " + item.getPrice() + "円");
                }
                }
        }
        }

        //DB接続のテストコード
        UserRepository userRepository = new UserRepository();
        try(Connection conn = DBConnection.getConnection()) {
                System.out.println("DB接続成功");
        } catch (SQLException e) {
                System.out.println("DB接続失敗: " + e.getMessage());
        }

        //ユーザーテーブルから全てのユーザーを取得するテストコード
        try {
                userRepository.selectUsers();
        } catch (RuntimeException e) {
                System.out.println("ユーザーの取得に失敗: " + e.getMessage());
        }

        //ユーザーテーブルに新しいユーザーを追加するテストコード
        try {
                User user = new User(4, "Sato");
                userRepository.insertUser(user);
                userRepository.selectUsers();
        } catch (RuntimeException e) {
                System.out.println("ユーザーの追加に失敗: " + e.getMessage());
        }

        //ユーザーテーブルから特定の更新を行うテストコード
        try {
                System.out.println("\n--- UPDATE: id=1 を更新 ---");
                User updateUser = new User(1, "NewName");
                userRepository.updateUser(updateUser);
                userRepository.selectUsers();
        } catch (RuntimeException e) {
                System.out.println("ユーザーの更新に失敗: " + e.getMessage());
        }

        //ユーザーテーブルから特定のidを削除を行うテストコード
        try {
                System.out.println("\n--- DELETE: id=6 を削除 ---");
                int deleteId = 6;
                userRepository.deleteUser(deleteId);
                userRepository.selectUsers();
        } catch (RuntimeException e) {
                System.out.println("ユーザーの削除に失敗: " + e.getMessage());
        }

        }
}
