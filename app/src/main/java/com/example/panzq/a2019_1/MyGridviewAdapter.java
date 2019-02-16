package com.example.panzq.a2019_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyGridviewAdapter extends BaseAdapter{

    private Context mContext;
    private String[] _items;
    private int[] _icons;

    public MyGridviewAdapter(Context mContext, String[] _items, int[] _icons) {
        this.mContext = mContext;
        this._items = _items;
        this._icons = _icons;
    }

    @Override
    public int getCount() {
        return _items.length;
    }

    @Override
    public Object getItem(int i) {
        return _items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View v = factory.inflate(R.layout.grid,null);
        ImageView iv = v.findViewById(R.id.icon);
        TextView tv = v.findViewById(R.id.text);
        iv.setImageResource(_icons[i]);
        tv.setText(_items[i]);
        return v;
    }
}
