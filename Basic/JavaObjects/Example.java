/**
 * example
 */
public class Example {

  public static void main(String[] args) {
    Person luis = new Person("Fernando", 21, "male", false);
    System.out.printf("The name of the person is %s and he is %s %n", 
    luis.getName(), luis.getAge());
    System.out.printf("The gender is %s %n", luis.gender);
    luis.changeGender();
    System.out.printf("The new gender is %s %n", luis.gender);
  }
}


