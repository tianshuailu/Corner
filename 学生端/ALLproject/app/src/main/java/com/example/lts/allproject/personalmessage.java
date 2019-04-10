package com.example.lts.allproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class personalmessage extends Activity {
    private ListView listview;
    private Button bur;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;


    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalmessage);

        TextView NAME = (TextView) findViewById(R.id.user_name);
        bur = (Button)findViewById(R.id.exit);
        String type = "stuinfo";
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        JSONObject userJSON2 = new JSONObject();
        try {
                            userJSON2.put("userid",LoginActivity.StudentID);

                            JsonConnect login =new JsonConnect();
                        String result3 = login.getData(userJSON2,type);
                        System.out.print(result3);


                        JSONObject data = new JSONObject(result3);

                       // for (int i = 0; i < data.length(); i++) {
                           // JSONObject value = data.getJSONObject(i);

                            Map<String,Object> map1 = new HashMap<String,Object>();
                            map1.put("studentID", data.getString("sid"));
                            map1.put("Name", data.getString("name"));
                            map1.put("sex", data.getString("gender"));
                            map1.put("xueyuan", data.getString("dept"));
                            map1.put("zhuanye", data.getString("major"));
                            list.add(map1);
                        }catch (JSONException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

        NAME.setText((String) list.get(0).get("Name"));
        System.out.print((String) list.get(0).get("Name"));
        listview = (ListView) findViewById(R.id.messageshow);
        MyAdapterxinxi myAdapter = new MyAdapterxinxi(this, list);
        listview.setAdapter(myAdapter);
        bur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(personalmessage.this, LoginActivity.class);
                mPref = getSharedPreferences("user_data", MODE_PRIVATE);
                mEditor = mPref.edit();
                mEditor.clear();
                mEditor.commit();
                startActivity(it);
            }
        });
            }
    }


