import java.util.*;

/**
 * Example of an interface as Type and a class instantiated
 */
public class ListExample {
  List<String> names = new ArrayList<String>();
  public static void main(String[] args) {
    ListExample example = new ListExample();
    example.addName("Luis");
    example.addName("Jon");
    example.addName("Lucas");
    example.removeName("Lucas");
    System.out.printf("%s",example.getList());
  }

  public void addName(String name) {
    names.add(name);
  }

  public void removeName(String name) {
    names.remove(name);
  }

  public List<String> getList() {
    return names;
  }
}

