package com.example.videostreamingapp;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.Collections;


public class ViewHolder extends RecyclerView.ViewHolder {


    SimpleExoPlayer exoPlayer;
    PlayerView playerView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setExoplayer(Application application , String name , String Videourl){

        TextView textView = itemView.findViewById(R.id.tv_item_name);
        playerView = itemView.findViewById(R.id.exoplayer_item);

        textView.setText(name);

        try{
//            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(application).build();
//            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
//            exoPlayer = (SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(application);
//            Uri video = Uri.parse(Videourl);
//            DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory("video");
//            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
//            MediaSource mediaSource = new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory,null,null);
//            playerView.setPlayer(exoPlayer);
//            exoPlayer.prepare(mediaSource);
//            exoPlayer.setPlayWhenReady(false);

            SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer.Builder(application).build();
            playerView.setPlayer(simpleExoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(Videourl);
            simpleExoPlayer.addMediaItems(Collections.singletonList(mediaItem));
            simpleExoPlayer.prepare();
            simpleExoPlayer.setPlayWhenReady(false);

        }catch(Exception e){
            Log.e("ViewHolder","exoplayer error" + e.toString());
        }
    }
}