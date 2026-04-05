package model;

public class Restaurant {

    //フィールドにて必要な情報を定義
    private final String name;
    private final String address;

    private MenuItem[] localMenuItems;


    //コンストラクタでフィールドを初期化
    public Restaurant(String name,String address){
        this.name = name;
        this.address = address;
        this.localMenuItems = new MenuItem[10];
    }

    //geterでしかとれないように設定
    public String getStoreName(){
        return name;
    }

    public String getStoreAddress(){
        return address;
    }

    public MenuItem[] getLocalMenuItems(){
        return localMenuItems;
    }
}