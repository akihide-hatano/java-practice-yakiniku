package service;

//importを追加
import model.MenuItem;
import model.Restaurant;
import model.YakinikuyaGroup;

public class MenuService {

    //共通メニューと店舗メニューを追加するメソッドを作成
    public boolean addCommonMenuItem(YakinikuyaGroup yakinikuya,String name,int price){

        //今まで作成した共通メニューの配列を取得
        MenuItem[] commonMenuItems = yakinikuya.getCommonMenuItems();

        //新たにメニューが追加できるかどうかを確認するために、配列の中身を確認していく
        for (int i = 0; i < commonMenuItems.length; i++) {
            if(commonMenuItems[i] == null){
                commonMenuItems[i] = new MenuItem(name, price);
                return true;
            }
        }
        throw new IllegalStateException("共通メニューをこれ以上追加できません");
    }

    //店舗独自のメニューを追加するメソッドを作成
    public boolean addLocalMenuItem(Restaurant restaurant, String name, int price){

        //まずは、今まで作成した店舗独自のメニューの配列を取得する
        MenuItem[] localMenuItems = restaurant.getLocalMenuItems();

        //nullの有無を確認して、nullの箇所に新しいメニューを追加する
        for (int i = 0; i < localMenuItems.length; i++) {
            if(localMenuItems[i] == null){
                localMenuItems[i] = new MenuItem(name, price);
                return true;
            }
        }
        throw new IllegalStateException("店舗メニューをこれ以上追加できません");
    }

    //共通メニューと店舗独自のメニューを表示するメソッドを作成
    public void displayCommonMenu(YakinikuyaGroup yakinikuya){
        System.out.println("---- 共通メニュー ----");
        //共通メニューを表示するために、共通メニューの配列を取得して、配列の中身を確認していく
        for (MenuItem item : yakinikuya.getCommonMenuItems()) {
            if( item != null){
                //外から触ることができないように、getterを使ってメニューの名前と値段を取得して表示する
                System.out.println(item.getName() + " : " + item.getPrice()+"円");
            }
        }
    }

    //店舗独自のメニューを表示するためのメソッドを作成
    public void displayLocalMenu(Restaurant restaurant){
        System.out.println("---- 独自メニュー ----");
        //店舗独自のメニューを表示するために、店舗独自のメニューの配列を取得して、配列の中身を確認していく
        for (MenuItem item : restaurant.getLocalMenuItems()){
            if( item != null){
                //外から触ることができないように、getterを使ってメニューの名前と値段を取得して表示する
                System.out.println(item.getName() + " :" + item.getPrice()+"円");
            }
        }
    }
}