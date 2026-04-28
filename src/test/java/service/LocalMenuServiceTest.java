package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.YakinikuyaGroup;
import model.Restaurant;

public class LocalMenuServiceTest {

    //店舗独自のメニューを追加するテスト
    @Test
    public void testAddLocalMenuItem() {
        // 店舗の作成
        Restaurant restaurant = new Restaurant("梅田店", "大阪市北区");

        // MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();

        // 店舗独自メニューを追加
        menuService.addLocalMenuItem(restaurant, "テストメニュー", 500);

        // 追加されたメニューを取得して確認
        assertEquals("テストメニュー", restaurant.getLocalMenuItems()[0].getName());
        assertEquals(500, restaurant.getLocalMenuItems()[0].getPrice());
    }

    //店舗独自メニューを削除するテスト
    @Test
    public void testRemoveLocalMenuItem(){
        //店舗の作成
        Restaurant restaurant = new Restaurant("梅田店", "大阪市北区");

        //MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();

        //店舗メニューを追加
        menuService.addLocalMenuItem(restaurant, "テストメニュー", 500);

        //店舗メニューを削除
        menuService.removeLocalMenuItem(restaurant, "テストメニュー");

        //削除されたメニューを取得して確認
        assertEquals(null, restaurant.getLocalMenuItems()[0]);

        //一気に書くとテストが不明確になるため下記のテストは別で項目を作成する
        //店舗メニューの商品名がnullである
        // assertThrows(IllegalArgumentException.class, () -> {
        //     menuService.addLocalMenuItem(restaurant, null, 500);
        // });

        // //店舗独自のメニューの価格が0である
        // assertThrows(IllegalArgumentException.class, () -> {
        //     menuService.addLocalMenuItem(restaurant, "テストメニュー", 0);
        // });
    }

    //店舗独自メニュー名にnullを追加しようとしたときに例外が発生することを確認するテスト
    @Test
    public void testAddLocalMenuItem_throwsWhenNameIsNull(){
        //店舗の作成
        Restaurant restaurant = new Restaurant("梅田店", "大阪市北区");
        //MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();
        //店舗独自メニュー名にnullを追加しようとしたときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, () -> {
            menuService.addLocalMenuItem(restaurant, null, 500);
        });
    }

    //店舗独自メニューの価格が0であるときに例外が発生することを確認するテスト
    @Test
    public void testAddLocalMenuItem_throwsWhenPriceIsInvalid(){
        //店舗の作成
        Restaurant restaurant = new Restaurant("梅田店", "大阪市北区");
        //MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();
        //店舗独自メニューの価格が0であるときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, ()->{
            menuService.addLocalMenuItem(restaurant, "テストメニュー", 0);
        });
    }

    //店舗独自メニューの価格がマイナスであるときに例外が発生することを確認するテスト
    @Test
    public void testAddLocalMenuItem_throwsWhenPriceIsNegative(){
        //店舗の作成
        Restaurant restaurant = new Restaurant("梅田店", "大阪市北区");
        //MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();
        //店舗独自メニューの価格がマイナスであるときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, ()->{
            menuService.addLocalMenuItem(restaurant, "テストメニュー", -100);
        });
    }

}