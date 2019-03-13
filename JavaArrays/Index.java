/**
 * index
 */

public class Index {
  public static void main(String[] args) {
    Number num = new Number();
    int[] numArray = num.getArray();
    num.iterate();
    num.changeArray();

    num.add(1);
    num.add(1,2,3,4);
  }
}


