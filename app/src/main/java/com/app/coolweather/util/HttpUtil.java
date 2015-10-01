package com.app.coolweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wen on 2015/10/1.
 */
public class HttpUtil {
   public static void sendHttpRequest(final String address,final HttpcallbackListener listener){
       new Thread(new Runnable() {
           @Override
           public void run() {
               HttpURLConnection connection=null;
               try {

                   URL url=new URL(address);
                   connection= (HttpURLConnection) url.openConnection();
                   connection.setRequestMethod("GET");
                   connection.setConnectTimeout(8000);
                   connection.setReadTimeout(8000);
                   InputStream in=connection.getInputStream();
                   InputStreamReader isr=new InputStreamReader(in);
                   BufferedReader reader=new BufferedReader(isr);
                   StringBuilder response=new StringBuilder();
                   String line;
                   while ((line=reader.readLine())!=null){
                       response.append(line);
                   }if (listener!=null){
                       listener.onFinish(response.toString());
                   }


               } catch (Exception e) {
                  if (listener!=null){
                      listener.onError(e);
                  }
               }finally {
                   if (connection!=null){
                       connection.disconnect();
                   }
               }
           }
       }).start();
   }
}