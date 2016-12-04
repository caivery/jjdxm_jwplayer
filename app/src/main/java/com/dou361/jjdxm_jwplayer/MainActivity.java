package com.dou361.jjdxm_jwplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_player)
    public void onClick() {
        Intent intent = new Intent(this, JwPlayerActivity.class);
        startActivity(intent);
    }
}
