package com.example.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import com.example.model.Song;

import java.util.ArrayList;

public class SongBook {
  private List<Song> songs;
  
  public SongBook() {
    songs = new ArrayList<Song>();
  }
  
  public void addSong(Song song) {
    songs.add(song);
  }

  public int getSongCount() {
    return songs.size();
  }

  @Override
  public String toString() {
    return String.format("SongBook: %s \n", songs);
  }
  
  // FIXME: This should be cached!

  // Here, we will create a Map where we will include every artist we've in our SongBook
  private Map<String, List<Song>> byArtist () {
    // We can use <> at the end so it will take the same parameters which are on
    // the left.
    Map<String, List<Song>> byArtist = new HashMap<>(); 
    for (Song song: this.songs) {
      List<Song> artistSongs = byArtist.get(song.getArtist());
      // If that artist list wasn't previously created, we create a new one
      if(artistSongs == null) {
        artistSongs = new ArrayList<>();
        byArtist.put(song.getArtist(), artistSongs);
      }
      artistSongs.add(song);
    }
    return byArtist;
  }

  public Set<String> getArtists() {
    return byArtist().keySet();
  }

  public List<Song> getSongsForArtist(String artist) {
    return byArtist().get(artist);
  }
}