package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }
