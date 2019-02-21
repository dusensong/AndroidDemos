package cn.dss.android;

import java.util.ArrayList;
import java.util.List;

import cn.dss.android.activity.ActivityDemosActivity;
import cn.dss.android.base.MenuListActivity;

public class MainActivity extends MenuListActivity {

    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Activity", ActivityDemosActivity.class));

        return menuItems;
    }
}
