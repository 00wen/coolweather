package com.app.coolweather.welcomeView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.app.coolweather.R;
import com.app.coolweather.activity.ChooseAreaActivity;

import java.util.ArrayList;
import java.util.List;

public class Guide extends Activity implements ViewPager.OnPageChangeListener{

    private ViewPager vp;
    private ViewPagerAdapter vpAdpater;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids={R.id.iv1,R.id.iv2,R.id.iv3};
    private Button btnStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        intiViews();
        initDots();
    }

    private void intiViews() {
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one, null));
        views.add(inflater.inflate(R.layout.two, null));
        views.add(inflater.inflate(R.layout.three,null));

        vpAdpater = new ViewPagerAdapter(views,this);
        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdpater);
        btnStart= (Button) views.get(2).findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Guide.this,ChooseAreaActivity.class));
                finish();
            }
        });

        vp.setOnPageChangeListener(this);
    }

    private void initDots(){
        dots=new ImageView[views.size()];
        for (int i=0;i<views.size();i++){
            dots[i]= (ImageView) findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {//页面被滑动是调用

    }

    @Override
    public void onPageSelected(int position) {//当前新的页面被选中时调用

        for (int i=0;i<ids.length;i++){
            if (position==i){
                dots[i].setImageResource(R.drawable.l);
            }else {
                dots[i].setImageResource(R.drawable.aa);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {//滑动改变是调用

    }


}
