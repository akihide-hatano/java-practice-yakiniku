package service;

import model.MenuItem;
import model.Restaurant;
import model.YakinikuyaGroup;

public class MenuService {

    //serviceはmodelへの委譲のみ行う（業務ルールはmodel側が持つ）

    //共通メニューと店舗独自のメニューを追加、削除するためのメソッドを作成
    public void addCommonMenuItem(YakinikuyaGroup yakinikuya, String name, int price){
        yakinikuya.addCommonMenuItem(name, price);
    }

    public void addLocalMenuItem(Restaurant restaurant, String name, int price){
        restaurant.addLocalMenuItem(name, price);
    }

    public void removeCommonMenuItem(YakinikuyaGroup yakinikuya, String name){
        yakinikuya.removeCommonMenuItem(name);
    }

    public void removeLocalMenuItem(Restaurant restaurant, String name){
        restaurant.removeLocalMenuItem(name);
    }

    //共通メニューと店舗独自のメニューを表示するためのメソッドを作成
    public void displayCommonMenu(YakinikuyaGroup yakinikuya){
        System.out.println("---- 共通メニュー ----");
        for (MenuItem item : yakinikuya.getCommonMenuItems()) {
            if (item != null){
                System.out.println(item.getName() + " : " + item.getPrice() + "円");
            }
        }
    }

    public void displayLocalMenu(Restaurant restaurant){
        System.out.println("---- 独自メニュー ----");
        for (MenuItem item : restaurant.getLocalMenuItems()){
            if (item != null){
                System.out.println(item.getName() + " : " + item.getPrice() + "円");
            }
        }
    }
}