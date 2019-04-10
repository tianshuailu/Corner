package com.example.lts.allproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapterHomework extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Map<String,Object>> list;


    public MyAdapterHomework(Context context , List<Map<String,Object>> list){

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

        MyAdapterHomework.ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item_homework, null);
            holder.subject = (TextView)convertView.findViewById(R.id.subjectinhomework);
            holder.homeworks = (TextView)convertView.findViewById(R.id.homeworkofsubject);
            holder.date = (TextView)convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        }else{
            holder = (MyAdapterHomework.ViewHolder)convertView.getTag();
        }

        holder.subject.setText((String)list.get(position).get("subject"));
        holder.homeworks.setText((String)list.get(position).get("homework"));
        holder.date.setText((String)list.get(position).get("date"));
        return convertView;
    }


    public final class ViewHolder{

        public TextView subject;
        public TextView homeworks;
        public TextView date;
    }
}
