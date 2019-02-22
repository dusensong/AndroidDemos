package cn.dss.android.activity.template;

import java.util.ArrayList;
import java.util.List;

import cn.dss.android.base.MenuListActivity;

public class ActivityTemplatesActivity extends MenuListActivity {

    @Override
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("BasicActivity", BasicActivity.class));
        menuItems.add(new MenuItem("BottomNavigationActivity", BottomNavigationActivity.class));
        menuItems.add(new MenuItem("BottomNavigationActivity", EmptyActivity.class));
        menuItems.add(new MenuItem("BottomNavigationActivity", FullscreenActivity.class));
        menuItems.add(new MenuItem("BottomNavigationActivity", LoginActivity.class));
        menuItems.add(new MenuItem("BottomNavigationActivity", BookListActivity.class));
        menuItems.add(new MenuItem("BottomNavigationActivity", BottomNavigationActivity.class));

        return menuItems;
    }
}
