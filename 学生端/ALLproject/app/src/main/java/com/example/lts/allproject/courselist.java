package com.example.lts.allproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class courselist extends AppCompatActivity {

    //星期几
    private RelativeLayout day;
    private ArrayList<View> V = new ArrayList<>();
    //SQLite Helper类
    private Button FIND;
    private ArrayAdapter<String> adapter;
    private Spinner spinnerCardweek;
    private String week;
    private ImageView imageView;
    int currentCoursesNumber = 0;
    int maxCoursesNumber = 0;
    courselist cl = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);
        FIND = (Button) findViewById(R.id.button2);
        FIND.setOnClickListener(new courselist.MyListener());
        imageView = (ImageView)findViewById(R.id.bg) ;
        spinnerCardweek = (Spinner)findViewById(R.id.spinner2);
        spinnerCardweek.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                week = courselist.this.getResources().getStringArray(R.array.spingarr)[arg2];
                System.out.println(week);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
        //工具条
        //oolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //从数据库读取数据

    }
    class MyListener implements View.OnClickListener {


        public void onClick(View v) {
            // TODO Auto-generated method stub
            System.out.println(week);
            try {
                try {
                    for (View I:V)
                    {
                        I.setVisibility(View.GONE);
                        day.removeView(v);
                    }
                    loadData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    //从数据库加载数据
    private void loadData() throws JSONException, InterruptedException {
        ArrayList<Course> coursesList = new ArrayList<>(); //课程列表
        /*//SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from courses", null);
        if (cursor.moveToFirst()) {
            do {
                coursesList.add(new Course(
                        cursor.getString(cursor.getColumnIndex("course_name")),
                        cursor.getString(cursor.getColumnIndex("teacher")),
                        cursor.getString(cursor.getColumnIndex("class_room")),
                        cursor.getInt(cursor.getColumnIndex("day")),
                        cursor.getInt(cursor.getColumnIndex("class_start")),
                        cursor.getInt(cursor.getColumnIndex("class_end"))));
            } while(cursor.moveToNext());
        }
        cursor.close();
*/       JSONObject userJSON = new JSONObject();

        userJSON.put("week",week);
        userJSON.put("userid",LoginActivity.StudentID);

        String type = "schedule";
        //JSONObject object = new JSONObject();
        //object.put("user",userJSON);
        JsonConnect weeksearch =new JsonConnect();
        String result2 = weeksearch.getData(userJSON,type);
        JSONArray data = new JSONArray(result2);

        for (int i = 0; i < data.length(); i++) {
            JSONObject value = data.getJSONObject(i);
            coursesList.add(new Course(
                    value.getString("cname"),
                    value.getString("teacher"),
                    value.getString("room"),
                    Integer.valueOf(value.getString("day")).intValue(),
                    Integer.valueOf(value.getString("start")).intValue(),
                    Integer.valueOf(value.getString("finish")).intValue()


                    ));


        }

        //使用从数据库读取出来的课程信息来加载课程表视图
        for (Course course : coursesList) {
            createLeftView(course);
            createCourseView(course);
        }
    }
    private void cleanData() throws JSONException, InterruptedException {
        ArrayList<Course> coursesList = new ArrayList<>(); //课程列表
        //使用从数据库读取出来的课程信息来加载课程表视图
        for (Course course : coursesList) {
            createLeftView(course);
            createCourseView(course);
        }
    }

    //保存数据到数据库
    /*private void saveData(Course course) {
        SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
        sqLiteDatabase.execSQL
                ("insert into courses(course_name, teacher, class_room, day, class_start, class_end) " + "values(?, ?, ?, ?, ?, ?)",
                new String[] {course.getCourseName(),
                        course.getTeacher(),
                        course.getClassRoom(),
                        course.getDay()+"",
                        course.getStart()+"",
                        course.getEnd()+""}
                );
    }
*/
    //创建课程节数视图
    private void createLeftView(Course course) {
        int len = 10;//course.getEnd();
        if (len > maxCoursesNumber) {
            for (int i = 0; i < len-maxCoursesNumber; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.left_view, null);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(110,180);
                view.setLayoutParams(params);

                TextView text = view.findViewById(R.id.class_number_text);
                text.setText(String.valueOf(++currentCoursesNumber));

                LinearLayout leftViewLayout = findViewById(R.id.left_view_layout);
                leftViewLayout.addView(view);
            }
        }
        maxCoursesNumber = len;
    }

    //创建课程视图
    private void createCourseView(final Course course) {
        int height = 180;
        int getDay = course.getDay();
        if ((getDay < 1 || getDay > 7) || course.getStart() > course.getEnd())
            Toast.makeText(this, "星期几没写对,或课程结束时间比开始时间还早~~", Toast.LENGTH_LONG).show();
        else {
            switch (getDay) {
                case 1: day = findViewById(R.id.monday); break;
                case 2: day = findViewById(R.id.tuesday); break;
                case 3: day = findViewById(R.id.wednesday); break;
                case 4: day = findViewById(R.id.thursday); break;
                case 5: day = findViewById(R.id.friday); break;
                case 6: day = findViewById(R.id.saturday); break;
                case 7: day = findViewById(R.id.weekday); break;
            }
            final View v = LayoutInflater.from(this).inflate(R.layout.course_card, null); //加载单个课程布局
            v.setY(height * (course.getStart()-1)); //设置开始高度,即第几节课开始
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT,(course.getEnd()-course.getStart()+1)*height - 8); //设置布局高度,即跨多少节课
            v.setLayoutParams(params);
            TextView text = v.findViewById(R.id.text_view);
            text.setText(course.getCourseName() + "\n" + course.getTeacher() + "\n" + course.getClassRoom()); //显示课程名
            day.addView(v);
            V.add(v);
            //长按删除课程
            /*v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    v.setVisibility(View.GONE);//先隐藏
                    day.removeView(v);//再移除课程视图
                    SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
                    sqLiteDatabase.execSQL("delete from courses where course_name = ?", new String[] {course.getCourseName()});
                    return true;
                }
            });*/
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == 0 && data != null) {
            Course course = (Course) data.getSerializableExtra("course");
            //创建课程表左边视图(节数)
            createLeftView(course);
            //创建课程表视图
            createCourseView(course);
            //存储数据到数据库
            //saveData(course);
        }
    }

   /* @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    }*/


   public  void refresh() {
       onCreate(null);
   }
}
