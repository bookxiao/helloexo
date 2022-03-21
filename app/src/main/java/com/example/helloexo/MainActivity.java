package com.example.helloexo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    Button buttonPlay;
    StyledPlayerView playerView;
    ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editUrl);
        buttonPlay = findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(v -> {
            // get url and init a ExoPlayer to play.

            String url = editUrl.getText().toString();
            Log.i("Main", "Url got, value is " + url);
            if(url.equals("")) {
                Log.e("Main", "url is empty!");
            } else {
                ArrayList<MediaItem> medias = new ArrayList<>();
                // Build the media item.
                MediaItem mediaItem = MediaItem.fromUri(url);
                medias.add(mediaItem);

                Intent intent = new Intent(this, PlayerActivity.class);
                IntentUtil.addToIntent(medias, intent);
                startActivity(intent);
            }
        });
    }
}