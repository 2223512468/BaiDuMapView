package com.baidumaploacation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baidumaploacation.R;

/**
 * Created by Administrator on 2018/3/15.
 */
public class ListAdapter extends BaseAdapter {

    String[] arrayFilters;
    Context mContext;

    public ListAdapter(Context mContext) {
        this.mContext = mContext;
        arrayFilters = mContext.getResources().getStringArray(R.array.line_item);
    }


    @Override
    public int getCount() {
        return arrayFilters.length;
    }

    @Override
    public Object getItem(int i) {
        return arrayFilters[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            convertView = mInflater.inflate(R.layout.act_line_item, null);
            holder = new ViewHolder();
            holder.itemView = (TextView) convertView.findViewById(R.id.item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.itemView.setText(arrayFilters[i]);
        return convertView;
    }

    class ViewHolder {
        TextView itemView;
    }

}
