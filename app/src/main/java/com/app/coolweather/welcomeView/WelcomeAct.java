package com.app.coolweather.welcomeView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.app.coolweather.R;
import com.app.coolweather.activity.ChooseAreaActivity;

/**
 * Created by wen on 2015/10/2.
 */
public class WelcomeAct extends Activity {
    private boolean isFirstIn=false;//判断Handler发送哪条消息
    private static final int TIME=2000;//停留时间
    private static final int GO_HOME=1000;//跳转到该界面
    private static final int GO_GUIDE=1001;//跳转到该界面


    //沉睡时间
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;

            }
        }
    };
    private void init(){
        //储存消息
        SharedPreferences perPreferences=getSharedPreferences("jike",MODE_PRIVATE);
        isFirstIn=perPreferences.getBoolean("isFirstIn",true);
        if (!isFirstIn){
            mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
        }else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,TIME);

            //现在储存消息
            SharedPreferences.Editor editor=perPreferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }
    }




    public void goHome(){
        Intent i=new Intent(WelcomeAct.this,ChooseAreaActivity.class);
        startActivity(i);
        finish();
    }
    public void goGuide(){
        Intent i=new Intent(WelcomeAct.this,Guide.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        init();
    }
}
