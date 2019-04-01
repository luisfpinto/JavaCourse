/**
 * InheritanceExample
 */
package com.people;

 public class Person {
  private String name;
  private String surname;
  private int age;

  public Person (String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  // We use the keyword override to declare our own method
  // which is coming from the parent class.
  @Override public String toString() {
    return "This is a person named: " + this.name + "\n";
  }
  public String getName () {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public int getAge() {
    return this.age;
  }
}

// Example of implementing an interface
class NameofTheClass implements nameOfTheInterface {

}

