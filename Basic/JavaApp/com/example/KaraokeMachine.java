package com.example;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayDeque;

import com.example.model.SongBook;
import com.example.model.Song;
/**
 * KaraokeMachine
 */
public class KaraokeMachine {
  private SongBook songbook;
  private BufferedReader reader;
  private Map<String, String> menu;
  private Queue<Song> songQueue;
  public KaraokeMachine(SongBook songbook) {
    this.songbook = songbook;
    // This reader will be in charge of reading the user input
    reader = new BufferedReader(new InputStreamReader(System.in));
    songQueue = new ArrayDeque<>();
    menu = new HashMap<String, String>();
    menu.put("add", "Add a new song to the song book");
    menu.put("choose", "Select a song by artist and add it to the queue");
    menu.put("play", "Play the next song in the queue");
    menu.put("quit", "Exit application");
  }

  // We need to tell the compiler that the exception is going to be catched in 
  // an upper level, see the run() method.
  private String promptAction() throws IOException {
    System.out.printf("Here you have your options \n");
    for(Map.Entry<String, String> option: menu.entrySet()) {
      System.out.printf("%s - %s \n", option.getKey(), option.getValue());
    }
    System.out.print("What do you want to do?  ");
    String choice = reader.readLine();
    return choice;
  }
  
  public void run() {
    String choice = ""; 
    do {
      try {
      System.out.printf("There are %d songs available. There are %d in the queue \n", songbook.getSongCount(),
      this.songQueue.size());
      choice = promptAction();
      switch(choice.toUpperCase()) {
        case "ADD":
          Song song = addNewSong();
          this.songbook.addSong(song);
          System.out.print("New song added\n");
          break;
        case "CHOOSE":
         String selectedArtist = promptArtist();
         List<Song> songs = this.songbook.getSongsForArtist(selectedArtist);
         Song selectedSong = promptSong(songs);
         System.out.printf("Your selected son was %s", selectedSong);
         // Now we add the selected song to the queue
         this.songQueue.add(selectedSong);
         break;
        case "PLAY":
          playNext();
          break;
        case "QUIT":
          System.out.print("Exiting\n");
          break;
        default:
        System.out.printf("Select a valid option \n");
      }
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
    } while(choice.compareToIgnoreCase("quit") != 0);
  }

  public Song addNewSong() throws IOException {
    System.out.print("Enter the artist's name: ");
    String artistName = reader.readLine();
    System.out.print("Enter the title: ");
    String songTitle = reader.readLine();
    System.out.print("Enter the video URL: ");
    String videoURL = reader.readLine();
    return new Song(artistName, songTitle, videoURL);
  }

  private String promptArtist() throws IOException {
    System.out.printf("Available artists, please select one: \n");
    List<String> artists = new ArrayList<>(songbook.getArtists());
    int choice = optionsMenu(artists);
    return artists.get(choice);
  }

  private Song promptSong(List<Song> songs) throws IOException {
    List<String> songTitles = new ArrayList<>();
    for (Song song : songs) {
      songTitles.add(song.getTitle());
    }
    int choice = optionsMenu(songTitles);
    return songs.get(choice);
  }

  private int optionsMenu(List<String> options) throws IOException {
    int counter = 1;
    for(String option: options) {
      System.out.printf("%d.) %s \n", counter, option);
      counter ++;
    }
    String choice = reader.readLine();
    return Integer.parseInt(choice) -1;
  }

  public void playNext() {
    Song song = this.songQueue.poll();
    if(song == null) {
      System.out.printf("There are no more songs in the queue, please add a new song\n");
    } else {
      System.out.printf("\n\n Open %s to hear %s by %s \n\n", song.getURL(), 
      song.getTitle(), 
      song.getArtist());
    }
  }
} 