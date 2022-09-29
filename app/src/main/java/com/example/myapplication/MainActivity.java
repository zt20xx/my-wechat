package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment fragment1, fragment2, fragment3, fragment4;
    private FragmentManager manager;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private TextView textView1,textView2,textView3,textView4;
    private ImageView imageView1,imageView2,imageView3,imageView4;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        manager = getSupportFragmentManager();

        initial();
        hidden();
        showfragment(fragment1);
        imageView1.setImageResource(R.drawable.tab_weixin_pressed);
        linearLayout1.setBackgroundColor(Color.parseColor("#34595252"));
        textView1.setTextColor(Color.parseColor("#4CAF50"));
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

    }
    private void initial() {
        linearLayout1=findViewById(R.id.layout1);
        linearLayout2=findViewById(R.id.layout2);
        linearLayout3=findViewById(R.id.layout3);
        linearLayout4=findViewById(R.id.layout4);
        textView1=findViewById(R.id.weixin);
        textView2=findViewById(R.id.tongxun);
        textView3=findViewById(R.id.faxian);
        textView4=findViewById(R.id.my);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);

        FragmentTransaction transaction=manager.beginTransaction()
                .add(R.id.FrameLayout,fragment1)
                .add(R.id.FrameLayout,fragment2)
                .add(R.id.FrameLayout,fragment3)
                .add(R.id.FrameLayout,fragment4)
                ;
        transaction.commit();
    }
    @Override
    public void onClick(View v) {           //view为所有控件的父类,从而能够接受所有的控件点击
        switch (v.getId()){
            case R.id.layout1: select(1);
                break;
            case R.id.layout2: select(2);
                break;
            case R.id.layout3: select(3);
                break;
            case R.id.layout4: select(4);
                break;
        }
    }
    private void select(int i) {//点击后改变对应页面显示,以及将对应的底部导航栏改为变色,图片与字体变绿
        hidden();
        switch (i) {
            case 1:
                imageView1.setImageResource(R.drawable.tab_weixin_pressed);
                textView1.setTextColor(Color.parseColor("#4CAF50"));
                linearLayout1.setBackgroundColor(Color.parseColor("#34595252"));
                showfragment(fragment1);
                break;
            case 2:
                imageView2.setImageResource(R.drawable.tab_tongxun_pressed);
                textView2.setTextColor(Color.parseColor("#4CAF50"));
                linearLayout2.setBackgroundColor(Color.parseColor("#34595252"));
                showfragment(fragment2);
                break;
            case 3:
                imageView3.setImageResource(R.drawable.tab_address_pressed);
                textView3.setTextColor(Color.parseColor("#4CAF50"));
                linearLayout3.setBackgroundColor(Color.parseColor("#34595252"));
                showfragment(fragment3);
                break;
            case 4:
                imageView4.setImageResource(R.drawable.tab_settings_pressed);
                textView4.setTextColor(Color.parseColor("#4CAF50"));
                linearLayout4.setBackgroundColor(Color.parseColor("#34595252"));
                showfragment(fragment4);
                break;
        }
    }
    private void hidden() {//将底部背景全部设为白色,fragment全部隐藏,字体设为黑色,图片为暗色
        imageView1.setImageResource(R.drawable.tab_weixin_normal);
        imageView2.setImageResource(R.drawable.tab_tongxun_normal);
        imageView3.setImageResource(R.drawable.tab_address_normal);
        imageView4.setImageResource(R.drawable.tab_settings_normal);
        textView1.setTextColor(Color.parseColor("#FF000000"));
        textView2.setTextColor(Color.parseColor("#FF000000"));
        textView3.setTextColor(Color.parseColor("#FF000000"));
        textView4.setTextColor(Color.parseColor("#FF000000"));
        linearLayout1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout4.setBackgroundColor(Color.parseColor("#FFFFFF"));
        manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .commit();
    }
    private void showfragment(Fragment fragment) {
        manager.beginTransaction()
                .show(fragment)
                .commit();
    }
}
