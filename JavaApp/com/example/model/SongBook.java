package com.example.model;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;

import com.example.model.Song;

import java.util.ArrayList;

public class SongBook {
  private List<Song> songs;
  
  public SongBook() {
    songs = new ArrayList<Song>();
  }

  public void exportSongBook(String fileName) {
    try{
      FileOutputStream fos = new FileOutputStream(fileName);
      PrintWriter writer = new PrintWriter(fos);
      for (Song song: songs) {
        writer.printf("%s|%s|%s \n",
        song.getArtist(),
        song.getTitle(),
        song.getURL());
      }
      writer.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public void importSongBook(String fileName) {
    try{
      FileInputStream fis = new FileInputStream(fileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
      String line;
      while((line = reader.readLine()) != null) {
        String[] args = line.split("\\|");
        addSong(new Song(args[0], args[1], args[2]));
      }
    } catch (IOException ioe){
      ioe.printStackTrace();
    }
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
    Map<String, List<Song>> byArtist = new TreeMap<>(); 
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
    List <Song> songs = byArtist().get(artist);
    songs.sort(new Comparator<Song>() {
      @Override
      public int compare(Song song1, Song song2) {
        if(song1.equals(song2)) {
          return 0;
        }
        return song1.title.compareTo(song2.title);
      }
    });
    return songs;
  }
}