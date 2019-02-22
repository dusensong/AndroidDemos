package cn.dss.android.activity;

import java.util.ArrayList;
import java.util.List;

import cn.dss.android.activity.template.ActivityTemplatesActivity;
import cn.dss.android.base.MenuListActivity;

public class ActivityDemosActivity extends MenuListActivity {

    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Activity基本用法", FirstActivity.class));
        menuItems.add(new MenuItem("Activity模板", ActivityTemplatesActivity.class));

        return menuItems;
    }
}
