package cn.dss.android.activity.template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.dss.android.R;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
    }
}
