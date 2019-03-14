import java.util.Random;
public class Driver{
  public static void main(String[] args){
    Random rnd = new Random(0);
    int[] a2 = new int[10];
    int[] a3 = new int[10];
    int[] a4 = new int[15];
    int[] a5 = new int[15];
    for (int i = 0; i < a2.length; i++){
      a2[i] = rnd.nextInt(100);
      a3[i] = rnd.nextInt(100);
      a4[i] = rnd.nextInt(100);
      a5[i] = rnd.nextInt(100);
    }
    System.out.println("Testing partition");
    int[] a1 = {2, 4, 8, 1, 0, 3, 8, 7, 2};
    System.out.println(Quick.toString(a1));
    //System.out.println("Testing Quick.moveFront(5, a1)--> Move 3 to the front");
    //Quick.moveFront(5, a1);
    System.out.println("\nTesting (a1, 0, 8): ");
    System.out.println(Quick.toString(a1));
    Quick.partition(a1, 0, 8);
    System.out.println(Quick.toString(a1));
    System.out.println("\nTesting (a2, 0, 8): ");
    System.out.println(Quick.toString(a2));
    Quick.partition(a2, 0, 8);
    System.out.println(Quick.toString(a2));
    System.out.println("\nTesting (a3, 1, 1): ");
    System.out.println(Quick.toString(a3));
    Quick.partition(a3, 1, 1);
    System.out.println(Quick.toString(a3));
    System.out.println("\nTesting (a4, 7, 12): ");
    System.out.println(Quick.toString(a4));
    Quick.partition(a4, 7, 12);
    System.out.println(Quick.toString(a4));
    System.out.println("\nTesting (a5, 0, 14): ");
    System.out.println(Quick.toString(a5));
    Quick.partition(a5, 0, 14);
    System.out.println(Quick.toString(a5));
  }
}
