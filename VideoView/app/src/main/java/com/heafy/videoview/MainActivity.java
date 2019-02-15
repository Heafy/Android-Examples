package com.heafy.videoview;

import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final String VIDEO = "video01";
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
     * Get the path of the media
     * @param media The name of the file
     * @return An Uri with the video
     */
    private Uri getMedia(String media) {
        return Uri.parse("android.resource://"+ getPackageName()+"/raw/"+media);
    }

    /**
     * Initialize and play the video
     */
    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO);
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
