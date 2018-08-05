package com.yy.y_zxing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author yangyi 2018年08月05日01:46:38
 *
 * wechat: yangyi_451686712
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainFragment()).commit();
    }

}
