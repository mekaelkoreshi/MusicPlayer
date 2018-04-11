package com.example.android.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent getGoToNowPlaying = getIntent();
        Bundle extrasBundle = getGoToNowPlaying.getExtras();
        boolean hasSongName = getGoToNowPlaying.hasExtra("Song Name");
        boolean hasArtistName = getGoToNowPlaying.hasExtra("Artist Name");
        if (extrasBundle != null) { //Null Checking
            String songData= extrasBundle.getString("Song Name");
            String artistData= extrasBundle.getString("Artist Name");
            TextView songNameTextView = findViewById(R.id.now_playing_song_name_text_view);
            songNameTextView.setText(songData);
            TextView artistNameTextView = findViewById(R.id.now_playing_artist_name_text_view);
            artistNameTextView.setText(artistData);
        }
    }

    public void goToLibrary (View view) {
        Intent libraryIntent = new Intent(this, LibraryActivity.class);
        startActivity(libraryIntent);
    }
}
