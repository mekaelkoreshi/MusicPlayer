package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_library:
                    mTextMessage.setText(R.string.title_library);
                    return true;
                case R.id.navigation_buy_music:
                    mTextMessage.setText(R.string.title_buy_music);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //Creates an array list of words
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Paranoid", "Black Sabbath"));
        songs.add(new Song("Duality","Slipknot"));
        songs.add(new Song("Dreamer","Ozzy Osbourne"));
        songs.add(new Song("Serenity","Godsmack"));
        songs.add(new Song("Welcome to the Jungle", "Guns N' Roses"));
        songs.add(new Song("Would","Alice in Chains?"));
        songs.add(new Song("Rooster","Alice in Chains"));
        songs.add(new Song("Fade to Black","Metallica"));
        songs.add(new Song("Mother","Danzig"));
        songs.add(new Song("River of Deceit","Mad Season"));

        SongAdapter songAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.message);

        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemForNowPlaying(position);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void selectItemForNowPlaying(int position) {
        TextView nowPlayingSongName = findViewById(R.id.now_playing_song_name_text_view);
        nowPlayingSongName.setText("Song Name");
        TextView nowPlayingArtistName = findViewById(R.id.now_playing_artist_name_text_view);
        nowPlayingArtistName.setText("Name of Artist");
        Intent goToNowPlaying = new Intent(this, MainActivity.class);
        startActivity(goToNowPlaying);
    }

}
