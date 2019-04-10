package com.example.lts.allproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
//import net.sf.json.JSONObject;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.lts.allproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class search extends Activity  {
    private ListView listview;
    private EditText stuIDview;
    private Button bt;
    search search1 = this;
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        bt = (Button) findViewById(R.id.find1);
        bt.setOnClickListener(new MyListener());
        listview = (ListView)findViewById(R.id.listView_list);
        stuIDview = (EditText)findViewById(R.id.searchID);
        String stuID = stuIDview.getText().toString();
        //MyAdapter myAdapter = new MyAdapter(this,putData());
        //listview.setAdapter(myAdapter);
    }
    class MyListener implements View.OnClickListener {


        public void onClick(View v) {
            // TODO Auto-generated method stub
            String stuID = stuIDview.getText().toString();

            MyAdapter myAdapter = null;
            try {
                myAdapter = new MyAdapter(search1,putData(stuID));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listview.setAdapter(myAdapter);
        }
    }
    public List<Map<String,Object>> putData(String stuID) throws JSONException, InterruptedException {

        String type = "grade";
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        JSONObject userJSON = new JSONObject();
        userJSON.put("userid",LoginActivity.StudentID);
        JsonConnect login =new JsonConnect();
        String result2 = login.getData(userJSON,type);
        JSONArray data = new JSONArray(result2);

        for (int i = 0; i < data.length(); i++) {
            JSONObject value = data.getJSONObject(i);
            Map<String,Object> map1 = new HashMap<String,Object>();
            map1.put("subject", value.getString("subject"));
            map1.put("score",value.getString("grade"));
            list.add(map1);
        }

        return list;




    }
}
