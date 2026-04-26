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
        //配列を返すときはcloneして返す
        return localMenuItems.clone();
    }

    //店舗独自のメニューを追加するメソッド（業務ルールはmodelが持つ）
    public void addLocalMenuItem(String name, int price){
        for (int i = 0; i < localMenuItems.length; i++) {
            if (localMenuItems[i] == null) {
                localMenuItems[i] = new MenuItem(name, price);
                return;
            }
        }
        throw new IllegalStateException("店舗メニューをこれ以上追加できません");
    }

    //店舗独自のメニューを削除するメソッド
    public void removeLocalMenuItem(String name){
        for (int i = 0; i < localMenuItems.length; i++) {
            MenuItem item = localMenuItems[i];
            if (item != null && item.getName().equals(name)) {
                localMenuItems[i] = null;
                return;
            }
        }
        throw new IllegalArgumentException("指定した店舗メニューが見つかりません");
    }
}