package com.example.test2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 *
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Six";
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static String savedEvents = "";
    private static String lifecycleEvent;
    private TextView mLifecycleDisplay;

    private void logAndUpdate() {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        savedEvents = savedEvents + lifecycleEvent + "\n";
        mLifecycleDisplay.setText(savedEvents);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);
        lifecycleEvent = ON_CREATE;
        logAndUpdate();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycleEvent = ON_RESTART;
        logAndUpdate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleEvent = ON_START;
        logAndUpdate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleEvent = ON_RESUME;
        logAndUpdate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleEvent = ON_PAUSE;
        logAndUpdate();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleEvent = ON_STOP;
        logAndUpdate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleEvent = ON_DESTROY;
        logAndUpdate();
    }

}
