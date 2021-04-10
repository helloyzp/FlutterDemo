package com.example.flutterdemo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

import io.flutter.embedding.android.FlutterActivity;

/**
 * Android项目里创建flutter module，并在Android原生Activity页面中启动flutter页面。
 *
 */
public class MainActivity extends AppCompatActivity {

    private Button jumpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumpBtn = findViewById(R.id.jumpBtn);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFlutterPage();
            }
        });

        // 通过FlutterView引入Flutter编写的页面
/*        View flutterView = Flutter.createView(this, getLifecycle(), "route1");
        FrameLayout.LayoutParams layout = new FrameLayout.LayoutParams(600, 800);
        layout.leftMargin = 100;
        layout.topMargin = 200;
        addContentView(flutterView, layout);

        FlutterView flutterView = new FlutterView(this);*/

    }

    /**
     * 跳转到flutter页面
     *
     * 跳转原理其实也是Activity之间的跳转，也是需要创建一个Activity来承载flutter的视图页面，这个Activity也需要注册到AndroidManifest.xml中；
     * 但是也可以使用flutter sdk里自带的FlutterActivity，这样就不需要手动创建一个新的Activity了，但是FlutterActivity同样也需要注册到AndroidManifest.xml中。
     */
    public void gotoFlutterPage() {
        gotoFlutterPage1();
    }

    /**
     * 跳转方式1：
     * 普通的跳转方式，会有问题：加载flutter页面时会白屏，并且加载比较缓慢
     */
    public void gotoFlutterPage1() {
        Intent intent = FlutterActivity.createDefaultIntent(this);
        startActivity(intent);
    }

    /**
     * 跳转方式2：
     * 引擎跳转方式，
     * FlutterActivity.createDefaultIntent()也就是ithNewEngine()这种方式
     */
    public void gotoFlutterPage2() {
        Intent intent = FlutterActivity.withNewEngine().initialRoute("second").build(this);
        startActivity(intent);
    }

    /**
     * 跳转方式3：
     * 加缓存加引擎跳转方式，
     */
    public void gotoFlutterPage3() {
        Intent intent = FlutterActivity.withCachedEngine("engine_id").build(this);
        startActivity(intent);
    }


}