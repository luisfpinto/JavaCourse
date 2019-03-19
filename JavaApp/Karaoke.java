import com.example.model.Song;
import com.example.model.SongBook;
import com.example.KaraokeMachine;

/**
 * karaoke
 */
public class Karaoke {
  public static void main(String[] args) {
    SongBook songBook = new SongBook();
    KaraokeMachine karaokeMachine = new KaraokeMachine(songBook);
    karaokeMachine.run();
  }
}