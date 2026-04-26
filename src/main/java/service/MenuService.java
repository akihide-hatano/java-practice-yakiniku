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

    //店舗独自のメニューを表示するためのメソッドを作成
    public MenuItem[] getCommonMenuItems(YakinikuyaGroup yakinikuya){
        return yakinikuya.getCommonMenuItems();
    }

    //店舗独自のメニューを表示するためのメソッドを作成
    public MenuItem[] getLocalMenuItems(Restaurant restaurant){
        return restaurant.getLocalMenuItems();
    }
}