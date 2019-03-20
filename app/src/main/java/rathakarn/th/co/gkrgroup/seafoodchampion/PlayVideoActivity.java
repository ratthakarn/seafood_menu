package rathakarn.th.co.gkrgroup.seafoodchampion;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private String apiKey = "AIzaSyA1F4KED5iEMIDKnfsQ97IRzzn69wswm_s";
    private String youtubeVideoKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        //get Value from intent
        youtubeVideoKey = getIntent().getStringExtra("youtubeKey");

//        Youtube Controller
        youTubePlayerView = findViewById(R.id.youTubePlayerView);
        youTubePlayerView.initialize(apiKey, PlayVideoActivity.this);

    }   // Main Method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            getYouTubePlayerProvider();
        }


    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubePlayerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
            youTubePlayer.cueVideo(youtubeVideoKey);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(PlayVideoActivity.this, 1).show();
        } else {
            String error = String.format("Error Cannot Initial Your Video", youTubeInitializationResult.toString());
        }

    }
}   // Main Class
