//userにてmoddelクラスを作成し、repositoryクラスで使用する
package model;
public class User{
    private int id;
    private String name;

    //コンストラクタ
    public User(int id,String name){
        this.id = id;
        this.name = name;
    }

    //getter
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    //setter
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

}

