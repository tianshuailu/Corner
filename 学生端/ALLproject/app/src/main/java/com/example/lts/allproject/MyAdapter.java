package com.example.lts.allproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Map<String,Object>> list;


    public MyAdapter(Context context , List<Map<String,Object>> list){

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

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder.subject = (TextView)convertView.findViewById(R.id.subject);
            holder.score = (TextView)convertView.findViewById(R.id.score);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.subject.setText((String)list.get(position).get("subject"));
        holder.score.setText((String)list.get(position).get("score"));

        return convertView;
    }


    public final class ViewHolder{

        public TextView subject;
        public TextView score;
    }

}
