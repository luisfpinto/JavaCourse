package com.example.model;

public class Song {
  private String artist;
  private String title;
  private String videoURL;

  public Song(String artist, String title, String videoURL) {
    this.artist = artist;
    this.title = title;
    this.videoURL = videoURL;
  }

  public String getTitle() {
    return this.title;
  }

  public String getArtist() {
    return this.artist;
  }

  public String getURL() {
    return this.videoURL;
  }

  // We override this method to show something more verbose than the default
  // text
  @Override
  public String toString() {
    return String.format("Song: %s by %s \n", this.title, this.artist);
  }
}