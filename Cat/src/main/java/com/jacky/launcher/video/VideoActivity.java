package com.jacky.launcher.video;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jacky.launcher.R;
import com.jacky.launcher.detail.MediaModel;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    public static final String VIDEO = "Video";
    private MediaModel mMediaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mMediaModel = getIntent().getParcelableExtra(VideoActivity.VIDEO);

        JCVideoPlayer.TOOL_BAR_EXIST = false;
        JCVideoPlayer.ACTION_BAR_EXIST = false;
        JCVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.video_player);

        jcVideoPlayerStandard.setUp(mMediaModel.getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, mMediaModel.getTitle());
        jcVideoPlayerStandard.startVideo();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
