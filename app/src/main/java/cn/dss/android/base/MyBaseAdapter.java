package cn.dss.android.base;

import android.widget.BaseAdapter;

import java.util.List;

public abstract class MyBaseAdapter<D> extends BaseAdapter {
    protected List<D> mListData;

    public MyBaseAdapter(List<D> listData) {
        setList(listData);
    }

    public void replaceData(List<D> listData) {
        if (listData == null)
            return;
        setList(listData);
        notifyDataSetChanged();
    }

    public void appendData(List<D> listData) {
        if (listData == null)
            return;
        mListData.addAll(listData);
        notifyDataSetChanged();
    }

    private void setList(List<D> listData) {
        mListData = listData;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public D getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
