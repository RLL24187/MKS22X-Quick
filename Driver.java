public class Driver{
  public static void main(String[] args){
    System.out.println("Testing partition");
    int[] a1 = {2, 4, 8, 1, 0, 3, 8, 7, 2};
    System.out.println(Quick.toString(a1));
    System.out.println("Testing Quick.moveFront(5, a1)--> Move 3 to the front");
    Quick.moveFront(5, a1);
    System.out.println(Quick.toString(a1));
    Quick.partition(a1);
    System.out.println(Quick.toString(a1));
  }
}
