package com.example.android.musicplayer;

/**
 * Created by mekaelkoreshi on 4.04.2018.
 */

public class Song {

    // Stores song name
    private String mSongName;

    // Stores song artist
    private String mArtistName;

    public Song (String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    // Get song name for a song
    public String getSongName() {
        return mSongName;
    }

    // Get artist name for a song
    public String getArtistName() {
        return mArtistName;
    }

}

