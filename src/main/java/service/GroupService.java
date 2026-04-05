package service;

import model.YakinikuyaGroup;

public class GroupService {

    //グループ名を表示
    public void displayGroupName(YakinikuyaGroup yakinikuya){
        System.out.println( "グループ名" + yakinikuya.getGroupName());
    }

}

