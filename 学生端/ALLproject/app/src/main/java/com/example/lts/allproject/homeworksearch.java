package com.example.lts.allproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class homeworksearch extends Activity {
    private ListView listview;
    private Button bt;
    homeworksearch hs = this;
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeworksearch);

        bt = (Button) findViewById(R.id.hwsearch);
        bt.setOnClickListener(new homeworksearch.MyListener());
        listview = (ListView)findViewById(R.id.homeworkshow);
    }
    class MyListener implements View.OnClickListener {


        public void onClick(View v) {
            // TODO Auto-generated method stub

            MyAdapterHomework myAdapter = null;
            try {
                myAdapter = new MyAdapterHomework(hs,putData());
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listview.setAdapter(myAdapter);
        }
    }
    public List<Map<String,Object>> putData() throws JSONException, InterruptedException {

        String type = "homework";
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        JSONObject userJSON = new JSONObject();
        userJSON.put("userid",LoginActivity.StudentID);
        JsonConnect login =new JsonConnect();
        String result2 = login.getData(userJSON,type);
        JSONArray data = new JSONArray(result2);

        for (int i = 0; i < data.length(); i++) {
            JSONObject value = data.getJSONObject(i);
            String Course = value.getString("subject");
            String HW = value.getString("homework");
            String date = value.getString("finish");
            Map<String,Object> map1 = new HashMap<String,Object>();
            map1.put("subject", Course);
            map1.put("homework",HW);
            map1.put("date",date);
            list.add(map1);
        }

        return list;
    }
}
