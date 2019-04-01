import java.util.Arrays;

public class Number {
  // By default values are set to null
  int[] values = new int[4];
  // We can initialize arrays in the initialization using {}.
  // Type has been inferred in the initialization
  int[] numbers = { 1, 2, 3, 4 };
  String[] names = {"Luis", "Jon", "Marc"};

  public int[] getArray() {
    return this.numbers;
  }

  public void iterate () {
    // To iretate over an array we use the enhanced for loop
    for (String name: names) {
      System.out.print(name +"\n");
    }
  }

  // In Java to make a change in an Array, you need to manage the copy of it.
  // This is solved by lists in Java
  public void changeArray() {
    String[] names2 = Arrays.copyOf(names, names.length +1);
    System.out.printf("Last element before %s \n", names[names.length-1]);
    names2[names2.length-1] = "Lucas";
    System.out.printf("Last element after %s \n", names2[names2.length-1]);
  } 

  public void add(int... num) {
    int sum = 0;
    for (int number: num) {
      sum +=number;
    }
    System.out.print(sum +"\n");
  }
}