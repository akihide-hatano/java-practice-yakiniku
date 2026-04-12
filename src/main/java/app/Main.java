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

        // --- 表示 ---
        System.out.println("グループ名: " + group.getGroupName());
        restaurantService.displayRestrants(group);     // 店舗一覧
        menuService.displayCommonMenu(group);           // 共通メニュー
        menuService.displayLocalMenu(restaurants[0]);   // 梅田店の独自メニュー

        //DB接続のテストコード
        try(Connection conn = DBConnection.getConnection()) {
                System.out.println("DB接続成功");
        } catch (SQLException e) {
                System.out.println("DB接続失敗: " + e.getMessage());
        }

        //ユーザーテーブルから全てのユーザーを取得するテストコード
        UserRepository repo = new UserRepository();
        repo.selectUsers();

        //ユーザーテーブルに新しいユーザーを追加するテストコード
        User newUser = new User(6, "Tago");
        repo.insertUser(newUser);
        repo.selectUsers();

        //ユーザーテーブルから特定の更新を行うテストコード
        User updateUser = new User(1, "NewName");
        repo.updateUser(updateUser);
        repo.selectUsers();

        //ユーザーテーブルから特定のidを削除を行うテストコード
        repo.deleteUser(5);
        repo.selectUsers();
        }
}
