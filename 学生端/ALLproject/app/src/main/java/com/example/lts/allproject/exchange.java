package com.example.lts.allproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exchange extends Activity {
    private ListView listview;
    private Button find1;
    private Button fix;
    private Button save;
    private Button exit;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange);
        find1 = (Button) findViewById(R.id.find);
        find1.setOnClickListener(new exchange.MyListener());
        fix = (Button) findViewById(R.id.fix);
        fix.setOnClickListener(new exchange.MyListener());
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new exchange.MyListener());
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new exchange.MyListener());
        listview = (ListView) findViewById(R.id.tclist);
        MyAdapter2 myAdapter = new MyAdapter2(this, putData());
        listview.setAdapter(myAdapter);
    }

    class MyListener implements View.OnClickListener {


        public void onClick(View v) {
            // TODO Auto-generated method stub
            int id = v.getId();
            switch (id) {
                case R.id.fix:
                    Log.i("指定onClick属性方式", "bt1点击事件");
                    break;
                case R.id.save:
                    Log.i("指定onClick属性方式", "bt2点击事件");
                    break;
                case R.id.find:
                    Log.i("指定onClick属性方式", "bt3点击事件");
                    break;
                case R.id.exit:
                    Log.i("指定onClick属性方式", "bt4点击事件");
                    break;

                default:
                    break;
            }
        }
    }

        public List<Map<String, Object>> putData() {

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("studentID", "1163710205");
            map1.put("Name", "张三");
            map1.put("score", "88");
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("studentID", "1163710206");
            map2.put("Name", "张四");
            map2.put("score", "88");
            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("studentID", "1163710207");
            map3.put("Name", "张无");
            map3.put("score", "80");
            list.add(map1);
            list.add(map2);
            list.add(map3);
            return list;
        }

}
