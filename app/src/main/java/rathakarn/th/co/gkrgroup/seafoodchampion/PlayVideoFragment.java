package rathakarn.th.co.gkrgroup.seafoodchampion;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayVideoFragment extends Fragment implements YouTubePlayer.OnInitializedListener {

    private String apiKey = "AIzaSyA1F4KED5iEMIDKnfsQ97IRzzn69wswm_s";
    private String youtubeKey = "AFmWqLIqDZA";
    private YouTubePlayerView youTubePlayerView;

    public PlayVideoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Show Video
        showVideo();


    }   // Main Method

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            getYouTubePlayerProvider().initialize(apiKey, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubePlayerView;
    }


    private void showVideo() {
        youTubePlayerView = getView().findViewById(R.id.youTubePlayerView);
        youTubePlayerView.initialize(apiKey, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_video, container, false);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer,
                                        boolean b) {

        if (!b) {
            youTubePlayer.cueVideo(youtubeKey);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), 1).show();
        } else {
            String error = String.format("Error Initial Youtube", youTubeInitializationResult.toString());
            Log.d("30JanV1", "Error ==> " + error);
        }

    }
}
