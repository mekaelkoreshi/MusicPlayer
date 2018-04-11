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

    public static ArrayList<Song> songs = new ArrayList<Song>();

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

        //Creates an array list of songs
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

        String songName = songs.get(position).getSongName();
        String artistName = songs.get(position).getArtistName();

        Intent goToNowPlaying = new Intent(this, MainActivity.class);

        Bundle extras = new Bundle();

        extras.putString("Song Name", songName);
        extras.putString("Artist Name", artistName);

        goToNowPlaying.putExtras(extras);

        startActivity(goToNowPlaying);
    }

}
