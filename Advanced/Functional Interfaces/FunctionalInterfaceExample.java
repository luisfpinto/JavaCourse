/**
 * interface
 */
import java.util.function.Function;

public class FunctionalInterfaceExample {
  String name = "Luis";
  int age = 23;
  String country = "Spain";
  public static void main(String[] args) {

    // Anonimous Interface
    // Function<Integer, String> checkUser = new Function() {
    //   @Override
    //   public String apply(Object age) {
    //     if((int) age < 23) {
    //       return "You are under 23";
    //     } else {
    //       return "You are over 23";
    //     }
    //   }
    // };

    // Anonimous interface using Lambda
    Function<Integer, String> checkUser = number -> {
      if((int) number < 23) return "You are under 23";
      else return "Your are over 23";
    };
    
    String result = checkUser.apply(21);
    System.out.println(result);
  }
}