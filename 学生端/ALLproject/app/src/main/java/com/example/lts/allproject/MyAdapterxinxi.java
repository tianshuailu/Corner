package com.example.lts.allproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapterxinxi extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Map<String,Object>> list;


    public MyAdapterxinxi(Context context , List<Map<String,Object>> list){

        this.mInflater = LayoutInflater.from(context);
        this.list = list;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        MyAdapterxinxi.ViewHolder holder = null;

        if (convertView == null) {

            holder = new MyAdapterxinxi.ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item3, null);
            holder.studentID = (TextView) convertView.findViewById(R.id.studentID);
            holder.Name = (TextView) convertView.findViewById(R.id.Name);
            holder.sex = (TextView) convertView.findViewById(R.id.sex);
            holder.xueyuan = (TextView) convertView.findViewById(R.id.xueyuan);
            holder.zhuanye = (TextView) convertView.findViewById(R.id.zhuanye);
            convertView.setTag(holder);
        } else {
            holder = (MyAdapterxinxi.ViewHolder) convertView.getTag();
        }

        holder.studentID.setText((String) list.get(position).get("studentID"));

        holder.Name.setText((String) list.get(position).get("Name"));
        holder.sex.setText((String) list.get(position).get("sex"));
        holder.xueyuan.setText((String) list.get(position).get("xueyuan"));
        holder.zhuanye.setText((String) list.get(position).get("zhuanye"));
        return convertView;
    }

    public final class ViewHolder{

        public TextView studentID;
        public TextView sex;
        public TextView Name;
        public TextView xueyuan;
        public TextView zhuanye;
    }
}
