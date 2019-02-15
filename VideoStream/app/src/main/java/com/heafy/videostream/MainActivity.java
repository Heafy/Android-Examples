package com.heafy.videostream;

import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final String VIDEO_URL = "http://132.248.108.10/~becario1/video01.mp4";
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
    }

    /**
     * Initialize and play the video
     */
    private void initializePlayer() {
        Uri videoUri = Uri.parse(VIDEO_URL);
        videoView.setVideoURI(videoUri);
        videoView.start();
    }

    /**
     * Stop the player
     */
    private void releasePlayer() {
        videoView.stopPlayback();
    }

    /**
     * Start the player from the MediaController.
     */
    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    /**
     * Stop the player from the MediaController.
     */
    @Override
    protected  void onStop() {
        super.onStop();
        releasePlayer();
    }

    /**
     * Pause the media from the MediaController.
     */
    @Override
    protected  void onPause() {
        super.onPause();
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            videoView.pause();
        }
    }
}
