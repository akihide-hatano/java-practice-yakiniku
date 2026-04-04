package service;

//importを追加
import model.MenuItem ;
import model.Restaurant;
import model.Yakinikuya;

public class MenuService {

    public boolean addCommonMenuItem(Yakinikuya yakinikuya,String name,int price){
        //
        MenuItem[] commoMenuItems = yakinikuya.getCommonMenuItems();

        //
        for (int i = 0; i < commoMenuItems.length; i++) {
            if(commoMenuItems[i] == null){
                commoMenuItems[i] = new MenuItem(name, price);
                return true;
            }
        }
        throw new IllegalStateException("共通メニューをこれ以上追加できません");
    }

    public boolean addLocalMenuItem(Restaurant restaurant, String name, int price){
        //
        MenuItem[] localMenuItems = restaurant.getLocalMenuItems();

        //
        for (int i = 0; i < localMenuItems.length; i++) {
            if(localMenuItems[i] == null){
                localMenuItems[i] = new MenuItem(name, price);
                return true;
            }
        }
        throw new IllegalStateException("店舗メニューをこれ以上追加できません");
    }

    public void displayCommonMenu(Yakinikuya yakinikuya){
        System.out.println("---- 共通メニュー ----");
        for (MenuItem item : yakinikuya.getCommonMenuItems()) {
            if( item != null){
                System.out.println(item.getName() + " : " + item.getPrice()+"円");
            }
        }
    }

    public void displayLocalMenu(Restaurant restaurant){
        System.out.println("---- 共通メニュー ----");
        for (MenuItem item : restaurant.getLocalMenuItems()){
            if( item != null){
                System.out.println(item.getName() + " :" + item.getPrice()+"円");
            }
        }
    }
}