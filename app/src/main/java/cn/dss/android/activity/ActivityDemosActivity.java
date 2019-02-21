package cn.dss.android.activity;

import java.util.ArrayList;
import java.util.List;

import cn.dss.android.base.MenuListActivity;

public class ActivityDemosActivity extends MenuListActivity {

    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Activity基本用法", FirstActivity.class));

        return menuItems;
    }
}
