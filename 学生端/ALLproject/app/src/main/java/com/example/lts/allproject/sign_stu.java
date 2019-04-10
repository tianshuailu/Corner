package com.example.lts.allproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;

public class sign_stu extends Activity {
    Button signstusub;
    TextView signstutext;
    EditText signstuedit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_student);
        signstusub = (Button) findViewById(R.id.sign_stu_sub_btn);

        signstuedit = (EditText)findViewById(R.id.sign_stu_edittext);

        signstusub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //submit logic???
                String SIGNPIN = signstuedit.getText().toString();
                try {
                    JSONObject js = new JSONObject();
                    String type = "sign";
                    js.put("userid",LoginActivity.StudentID);
                        js.put("pin",SIGNPIN);
                    JsonConnect login =new JsonConnect();
                    String result2 = login.getData(js,type);
                    JSONObject js2 = new JSONObject(result2);
                    if(js2.getString("status").equals("0")){
                        Toast.makeText(sign_stu.this, "submit success", Toast.LENGTH_SHORT).show();}
                    //data???
                    else{
                        Toast.makeText(sign_stu.this, "submit failure", Toast.LENGTH_SHORT).show();}
                    //data???b

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
