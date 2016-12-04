package com.dou361.jjdxm_jwplayer;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.configuration.PlayerConfig;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JwPlayerActivity extends Activity {

    @Bind(R.id.jw_player)
    JWPlayerView jwPlayer;
    @Bind(R.id.tv_msg)
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jwplayer);
        ButterKnife.bind(this);


        PlayerConfig playerConfig = new PlayerConfig.Builder()
//                .file("http://mysite.com/videos/myVideo.mp4")
                .file("http://www.cn123.org/web/jwplayer-7.8.1/simple.mp4")
//                .file("http://23340.live-vod.cdn.aodianyun.com/m3u8/0x0/merge/d07be4bf0e9e4a18d81d412e3aaf79fa.m3u8")
                .skinUrl("http://mysite.com/skins/ellipse.css")
                .skinName("ellipse")
                .skinActive("#820101")
                .skinInactive("#ffffff")
                .skinBackground("#cf0000")
                .build();
        PlayerConfig playerConfig1 = new PlayerConfig.Builder()
//                .file("http://www.site.com/video/clip.mp4")
                .file("http://www.cn123.org/web/jwplayer-7.8.1/simple.mp4")
//                .file("http://23340.live-vod.cdn.aodianyun.com/m3u8/0x0/merge/d07be4bf0e9e4a18d81d412e3aaf79fa.m3u8")
                .autostart(true)
                .build();

        jwPlayer.setup(playerConfig);
    }


    @Override
    protected void onResume() {
        // Let JW Player know that the app has returned from the background
        super.onResume();
        jwPlayer.onResume();
    }

    @Override
    protected void onPause() {
        // Let JW Player know that the app is going to the background
        jwPlayer.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // Let JW Player know that the app is being destroyed
        jwPlayer.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // Set fullscreen when the device is rotated to landscape
        jwPlayer.setFullscreen(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE, true);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Exit fullscreen when the user pressed the Back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (jwPlayer.getFullscreen()) {
                jwPlayer.setFullscreen(false,true);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}
