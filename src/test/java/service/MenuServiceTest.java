package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.YakinikuyaGroup;

public class MenuServiceTest {

    @Test
    public void testAddCommonMenuItem() {
        // グループの作成
        YakinikuyaGroup group = new YakinikuyaGroup("テストグループ");

        // MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();

        // 共通メニューを追加
        menuService.addCommonMenuItem(group, "テストメニュー", 500);

        // 追加されたメニューを取得して確認
        assertEquals("テストメニュー", group.getCommonMenuItems()[0].getName());
        assertEquals(500, group.getCommonMenuItems()[0].getPrice());
    }

    //共通メニューを削除するテスト
    @Test
    public void testRemoveCommonMenuItem() {
        // グループの作成
        YakinikuyaGroup group = new YakinikuyaGroup("テストグループ");
        // MenuServiceのインスタンスを作成
        MenuService menuService = new MenuService();
        // 共通メニューを追加
        menuService.addCommonMenuItem(group, "テストメニュー", 500);
        // 共通メニューを削除
        menuService.removeCommonMenuItem(group, "テストメニュー");
        // 削除されたメニューを取得して確認
        assertEquals(null, group.getCommonMenuItems()[0]);
    }

    //11件目の共通メニューを追加しようとしたときに例外が発生することを確認するテスト
    @Test
    public void testAddCommonMenuItem_throwsWhenFull(){
        //グループの作成
        YakinikuyaGroup group = new YakinikuyaGroup("テストグループ");
        MenuService service = new MenuService();

        for( int i = 0; i < 10; i++  ){
            service.addCommonMenuItem(group, "メニュー"+ i,500);
        }

        assertThrows(IllegalStateException.class, () -> {
            service.addCommonMenuItem(group, "メニュー11", 500);
        });
    }

    //共通メニューの商品名がnullのときに例外が発生することを確認するテスト
    @Test
    public void testAddCommonMenuItem_throwsWhenNameIsNull(){
        //グループ作成
        YakinikuyaGroup group = new YakinikuyaGroup("テストグループ");
        MenuService service = new MenuService();

        //共通メニューの商品名がnullのときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, () -> {
            service.addCommonMenuItem(group, null, 500);
        });
    }

    //共通メニューの商品名が空白のときに例外が発生することを確認するテスト
    @Test
    public void testAddCommonMenuItem_throwsWhenNameIsEmpty(){
        //グループ作成
        YakinikuyaGroup group = new YakinikuyaGroup("テストグループ");
        MenuService service = new MenuService();

        //共通メニューの商品名が空白のときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, () -> {
            service.addCommonMenuItem(group, "   ", 500);
        });
    }

    //共通メニューの価格が0以下のときに例外が発生することを確認するテスト
    @Test
    public void testAddCommonMenuItem_throwsWhenPriceIsInvalid(){
        //グループ作成
        YakinikuyaGroup group = new YakinikuyaGroup("テストグループ");
        MenuService service = new MenuService();

        //共通メニューの価格が0のときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, () -> {
            service.addCommonMenuItem(group, "テストメニュー", 0);
        });

        //共通メニューの価格がマイナスのときに例外が発生することを確認するテスト
        assertThrows(IllegalArgumentException.class, () -> {
            service.addCommonMenuItem(group, "テストメニュー", -100);
        });
    }
}