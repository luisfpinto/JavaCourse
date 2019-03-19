import com.example.model.Song;
import com.example.model.SongBook;
import com.example.KaraokeMachine;

/**
 * karaoke
 */
public class Karaoke {
  public static void main(String[] args) {
    SongBook songBook = new SongBook();
    songBook.importSongBook("songbook.txt");
    KaraokeMachine karaokeMachine = new KaraokeMachine(songBook);
    karaokeMachine.run();
    System.out.println("Saving book \n");
    songBook.exportSongBook("songbook.txt");
  }
}