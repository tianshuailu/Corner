package com.example.lts.allproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView mIDView;
    private EditText mPasswordView;
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private CheckBox check_remember,check_automatic;
    public static  List<Map<String,Object>> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        gridView = (GridView) findViewById(R.id.gridview);
        mIDView = (AutoCompleteTextView) findViewById(R.id.ID);
        check_remember =(CheckBox) findViewById(R.id.check_pass);
        check_automatic = (CheckBox) findViewById(R.id.check_login);
        mPasswordView = (EditText) findViewById(R.id.password);
        //初始化数据
        initData();

        String[] from={"img","text"};

        int[] to={R.id.img,R.id.text};

        adapter=new SimpleAdapter(this, dataList, R.layout.gridview_item, from, to);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0://点击图片0跳转成绩查询
                    {
                        startActivity(new Intent(MainActivity.this,search.class));
                    }
                    break;
                    case 1://点击图片1跳转课表查询
                    {
                        startActivity(new Intent(MainActivity.this,courselist.class));

                    }
                    break;
                    case 2://点击图片3跳转课堂签到
                    {
                        startActivity(new Intent(MainActivity.this,sign_stu.class));

                    }
                    break;
                    case 3://点击图片4跳转作业查询
                    {
                        startActivity(new Intent(MainActivity.this,homeworksearch.class));

                    }
                    break;
                    case 4://点击图片5跳转个人信息
                    {
                       /* String type = "stuinfo";
                        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
                        JSONObject userJSON2 = new JSONObject();
                        try {
                            userJSON2.put("userid",LoginActivity.StudentID);

                            JsonConnect login =new JsonConnect();
                        String result3 = login.getData(userJSON2,type);
                        System.out.print(result3);


                        JSONArray data = new JSONArray(result3);

                        for (int i = 0; i < data.length(); i++) {
                            JSONObject value = data.getJSONObject(i);

                            Map<String,Object> map1 = new HashMap<String,Object>();
                            map1.put("studentID", value.getString("sid"));
                            map1.put("Name", value.getString("name"));
                            map1.put("sex", value.getString("gender"));
                            map1.put("xueyuan", value.getString("dept"));
                            map1.put("zhuanye", value.getString("major"));
                            list.add(map1);
                        } }catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                        startActivity(new Intent(MainActivity.this,personalmessage.class));

                    }
                    break;
                }

            }
        });
       if (LoginActivity.status) {

           System.out.println("");

            mPref = getSharedPreferences("user_data", MODE_PRIVATE);
            boolean isremember = mPref.getBoolean("isremember", false);
            boolean isautomatic = mPref.getBoolean("isautomatic", false);
            mEditor = mPref.edit();
            System.out.println(isautomatic);
            if (isautomatic) {
                //取出账号密码
                Toast.makeText(MainActivity.this, "自动登陆", Toast.LENGTH_SHORT).show();
                String IDs = mPref.getString("ID", null);
                LoginActivity.StudentID = Integer.valueOf(IDs).intValue();
                String passs = mPref.getString("password", null);
                //设置复选框的状态是勾选的状态
                //连接服务器
                //失败跳转
                try {
                    if(!autoconnect(IDs,passs))
                    {
                        Intent it = new Intent(MainActivity.this, LoginActivity.class);
                        Toast.makeText(MainActivity.this,"信息更改请重新登录",Toast.LENGTH_SHORT).show();
                        startActivity(it);

                    }

                } catch (JSONException e) {

                    Intent it = new Intent(MainActivity.this, LoginActivity.class);
                    Toast.makeText(MainActivity.this,"信息更改请重新登录",Toast.LENGTH_SHORT).show();
                    startActivity(it);
                } catch (InterruptedException e) {

                    Intent it = new Intent(MainActivity.this, LoginActivity.class);
                    Toast.makeText(MainActivity.this,"信息更改请重新登录",Toast.LENGTH_SHORT).show();
                    startActivity(it);
                }
            } else {
                //跳
                 Intent it = new Intent(MainActivity.this, LoginActivity.class);
                Toast.makeText(MainActivity.this,"信息更改请重新登录",Toast.LENGTH_SHORT).show();
                startActivity(it);
            }
        }
    }
    boolean autoconnect(String id,String ps) throws JSONException, InterruptedException {
        JSONObject userJSON = new JSONObject();

        userJSON.put("userid",id);
        userJSON.put("password",ps);
        String type = "login";
        //JSONObject object = new JSONObject();
        //object.put("user",userJSON);
        JsonConnect login =new JsonConnect();
        String result2 = login.getData(userJSON,type);

        System.out.println(result2);

        JSONObject jsonObject2 = new JSONObject(result2);
        //SONArray jsonArray = null;
        //ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        // JSONArray jsonArray = new JSONArray(result2);
        //System.out.println(jsonArray.length());
        //for (int i = 0; i < jsonArray.length(); i++) {
        //JSONObject jsonObject2 = jsonArray.getJSONObject(i);
        // 初始化map数组对
        // System.out.println("正在解析。。。。");
        if(jsonObject2.getString("status").equals("1"))
        {
            return true;
        }
        else
        {
             return false;
        }

    }

    void initData() {
        //图标
        int icno[] = { R.drawable.search, R.drawable.course,
                R.drawable.sign, R.drawable.homework,
                R.drawable.person};
        //图标下的文字
        String name[]={"成绩查询","课表查询","课堂签到","作业查询","个人信息",};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text",name[i]);
            dataList.add(map);
        }
    }
}
