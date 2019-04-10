package com.example.lts.allproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonConnect {


    public static String str;
    public JSONObject jsonObject;
    public String type;
    public String getData(JSONObject jsonObject2, String type2) throws InterruptedException {
        jsonObject = jsonObject2;
        type =type2;
        new Thread()
        {
                @Override
                        public void run(){
                    try {
                    String url1 = "http://192.168.199.182:8080/android/listStudent";
                    String url3 = "http://192.168.43.32:8080/android/";
                    String url2 = "https://www.baidu.com";
                    String url = url3 + type;
                   // System.out.println(url);

                    String content = String.valueOf(jsonObject);
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    //HttpURLConnection connection = (HttpURLConnection) nURL.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestProperty("User-Agent", "Fiddler");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Charset", "UTF-8");
                    OutputStream os = connection.getOutputStream();
                    os.write(content.getBytes());
                    os.close();
                  //  System.out.println("1111");
                    InputStream is = connection.getInputStream();

                    //InputStreamReader isr = new InputStreamReader(is, "utf-8");
                    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                    //BufferedReader du = new BufferedReader(isr);
                    byte[] buffer = new byte[1024 * 1024];
                    int len = -1;
                    if (is != null) {
                        while ((len = is.read(buffer)) != -1) {
                            // 将Buffer中的数据写到outputStream对象中
                            outStream.write(buffer, 0, len);
                        }
                        is.close();
                        String result2 = new String(outStream.toByteArray(),"utf-8");
                        str = result2;
                        System.out.println("1111111");


                    }

                } catch (IOException E) {
            E.printStackTrace();
        }
        }


        }.start();
        Thread.sleep(100);
        System.out.println(str);

        return str;
}

/*
    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {

            str = msg.getData().getString("Strings");//获取值时相应的类型要对应，传入为String类型用getString；Int类型用getInt。

            System.out.println(str);
        }

    };
    boolean continueRun = true;
    Runnable runable = new Runnable() {

        public void run() {
            Looper.prepare();
            while (continueRun) {
                try {
                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    System.out.println("1111");
                    String url1 = "http://192.168.199.182:8080/android/listStudent";
                    String url3 = "http://192.168.43.32:8080/android/";
                    String url2 = "https://www.baidu.com";
                    String url = url3 + type;
                    System.out.println(url);

                    String content = String.valueOf(jsonObject);
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    //HttpURLConnection connection = (HttpURLConnection) nURL.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestProperty("User-Agent", "Fiddler");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Charset", "UTF-8");
                    OutputStream os = connection.getOutputStream();
                    os.write(content.getBytes());
                    os.close();
                    System.out.println("1111");
                    InputStream is = connection.getInputStream();

                    //InputStreamReader isr = new InputStreamReader(is, "utf-8");
                    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                    //BufferedReader du = new BufferedReader(isr);
                    byte[] buffer = new byte[1024 * 1024];
                    int len = -1;
                    if (is != null) {
                        while ((len = is.read(buffer)) != -1) {
                            // 将Buffer中的数据写到outputStream对象中
                            outStream.write(buffer, 0, len);
                        }
                        is.close();
                        String result2 = new String(outStream.toByteArray());
                        System.out.println(result2);
                        bundle.putString("Strings", result2);
                        msg.setData(bundle);

                        handler.sendMessage(msg);

                    }

                } catch (IOException E) {
                    E.printStackTrace();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        }


   ;};
    public void start() {
        // 启动线程
        continueRun = true;
        new Thread(runable).start();
    }
    public void stop() {
        // 关闭线程
        continueRun = false;
    }*/

}




