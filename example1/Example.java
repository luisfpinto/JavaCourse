/**
 * example
 */
public class Example {

  public static void main(String[] args) {
    Person luis = new Person("Fernando", 21, "female", false);
    System.out.printf("The name of the person is %s and he is %s %n", 
    luis.getName(), luis.getAge());
  }
}

class Person {
  // final means it can only be initialized once.
  final private String name;
  int age = 19;
  String gender = "male";
  boolean married = false;

  // Constructors have the same name of the class but they  don't have a return type
  
  public Person (String name, int age, String gender, boolean married) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.married = married;
  }

  // Method to get the Name
  public String getName () {
    return this.name;
  }

  // Metho to get the Age
  public int getAge () {
    return this.age;
  }

}


