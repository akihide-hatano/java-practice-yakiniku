package model;

public class MenuItem {
	//フィールドで必要なものを定義
	private final String name;
	private final int price;

	//コンストラクタで実際にインスタンスを産む際を定義
	public MenuItem( String name, int price){
		this.name = name;
		this.price = price;
	}

	//ゲッターでしかとれないように設定
	public String getName(){
		return name;
	}

	public int getPrice(){
		return price;
	}
}