package cn.dss.android.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dss.android.R;

/**
 * 菜单列表Activity
 */
public abstract class MenuListActivity extends BaseActivity {
    @BindView(R.id.list_view) ListView mListView;

    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        ButterKnife.bind(this);

        List<MenuItem> menuItems = getMenuItems();
        if (menuItems == null) {
            throw new RuntimeException("getMenuItems() 返回 null");
        }

        mAdapter = new MyAdapter(menuItems);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuItem menuItem = mAdapter.getItem(position);
                Intent intent = new Intent(getContext(), menuItem.targetComponentCls);
                startActivity(intent);
            }
        });
    }

    /**
     * 获取菜单列表
     *
     * @return
     */
    public abstract List<MenuItem> getMenuItems();

    public static class MyAdapter extends MyBaseAdapter<MenuItem> {

        public MyAdapter(List<MenuItem> listData) {
            super(listData);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Context context = parent.getContext();
            final ViewHolder vh;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).
                        inflate(R.layout.item_menu_list, null);
                vh = new ViewHolder(convertView);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            final MenuItem dataItem = getItem(position);
            if (dataItem == null) {
                return convertView;
            }

            vh.mTitleTv.setText(dataItem.title);
            if (StringUtils.isEmpty(dataItem.desc)) {
                vh.mDescTv.setVisibility(View.GONE);
            } else {
                vh.mDescTv.setVisibility(View.VISIBLE);
                vh.mDescTv.setText(dataItem.desc);
            }
            return convertView;
        }

        static class ViewHolder {
            @BindView(R.id.title_tv) TextView mTitleTv;
            @BindView(R.id.desc_tv) TextView mDescTv;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    public static class MenuItem {
        public String title;
        public String desc;
        /**
         * 目标组件类对象
         */
        public Class<?> targetComponentCls;

        public MenuItem() {
        }

        public MenuItem(String title, Class<?> targetComponentCls) {
            this.title = title;
            this.targetComponentCls = targetComponentCls;
        }

        public MenuItem(String title, String desc, Class<?> targetComponentCls) {
            this.title = title;
            this.desc = desc;
            this.targetComponentCls = targetComponentCls;
        }
    }
}
