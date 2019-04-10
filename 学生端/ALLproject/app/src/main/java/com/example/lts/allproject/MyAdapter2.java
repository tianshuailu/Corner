package com.example.lts.allproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter2 extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Map<String,Object>> list;


    public MyAdapter2(Context context , List<Map<String,Object>> list){

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

        MyAdapter2.ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item2, null);
            holder.studentID = (TextView) convertView.findViewById(R.id.studentID);
            holder.Name = (TextView) convertView.findViewById(R.id.Name);
            holder.score = (TextView) convertView.findViewById(R.id.score);
            convertView.setTag(holder);
        } else {
            holder = (MyAdapter2.ViewHolder) convertView.getTag();
        }

        holder.studentID.setText((String) list.get(position).get("studentID"));
        holder.Name.setText((String) list.get(position).get("Name"));
        holder.score.setText((String) list.get(position).get("score"));
        return convertView;
    }

    public final class ViewHolder{

        public TextView studentID;
        public TextView score;
        public TextView Name;
    }
}
