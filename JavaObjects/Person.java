class Person {
  // final means it can only be initialized once.
  final private String name;
  // We use the following syntax to declare constants
  public static final int MAX_AGE = 100;
  int age = 19;
  public String gender;
  boolean married = false;

  // Constructors have the same name of the class but they  don't have a return type
  
  public Person (String name, int age, String gender, boolean married) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.married = married;
  }
  // When we declare a method we specified the privacy + the returned value
  public String getName () {
    return this.name;
  }

  public int getAge () {
    return this.age;
  }

  // When declaring a method which doesn't return anything we use void
  public void changeGender () {
    this.gender = this.gender.equals("male") ? "female" : "male";
  }
}