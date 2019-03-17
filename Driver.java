import java.util.*;
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
    //System.out.println(Quick.toString(a1));
    //System.out.println("Testing Quick.moveFront(5, a1)--> Move 3 to the front");
    //Quick.moveFront(5, a1);
    /*
    System.out.println("\nTesting (a1, 0, 8): ");
    System.out.println(Quick.toString(a1));
    System.out.println(Quick.partition(a1, 0, 8));
    System.out.println(Quick.toString(a1));

    System.out.println("\nTesting (a2, 0, 8): ");
    System.out.println(Quick.toString(a2));
    System.out.println(Quick.partition(a2, 0, 8));
    System.out.println(Quick.toString(a2));

    System.out.println("\nTesting (a3, 1, 1): ");
    System.out.println(Quick.toString(a3));
    System.out.println(Quick.partition(a3, 1, 1));
    System.out.println(Quick.toString(a3));

    System.out.println("\nTesting (a4, 7, 12): ");
    System.out.println(Quick.toString(a4));
    System.out.println(Quick.partition(a4, 7, 12));
    System.out.println(Quick.toString(a4));

    System.out.println("\nTesting (a5, 0, 14): ");
    System.out.println(Quick.toString(a5));
    System.out.println(Quick.partition(a5, 0, 14));
    System.out.println(Quick.toString(a5));
    */


    System.out.println("\n--------Testing quickselect--------");
    System.out.println("\na1, 4");
    System.out.println(Quick.toString(a1));
    System.out.println(Quick.quickselect(a1, 4));

    System.out.println("\na2, 6");
    System.out.println(Quick.toString(a2));
    System.out.println(Quick.quickselect(a2, 6));

    System.out.println("\na3, 1");
    System.out.println(Quick.toString(a3));
    System.out.println(Quick.quickselect(a3, 1));

    System.out.println("\na4, 0");
    System.out.println(Quick.toString(a4));
    System.out.println(Quick.quickselect(a4, 0));

    System.out.println("\na5, 10");
    System.out.println(Quick.toString(a5));
    System.out.println(Quick.quickselect(a5, 10));

    int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    System.out.println("0: "+Quick.quickselect( ary , 0 ));// would return 0
    System.out.println("2: "+Quick.quickselect( ary , 1 ));//  would return 2
    System.out.println("5: "+Quick.quickselect( ary , 2 ));//  would return 5
    System.out.println("10: "+Quick.quickselect( ary , 3 ));//  would return 10
    System.out.println("15: "+Quick.quickselect( ary , 4 ));//  would return 15
    //System.out.println("23: "+Quick.quickselect( ary , 5 ));//  would return 23
  }
}
