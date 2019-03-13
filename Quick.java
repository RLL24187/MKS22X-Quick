//import java.util.Random;
public class Quick{
  public static int[] partition(int[] ary){
    //select a random pivot
    //Random rnd = new Random();
    //int pivot = rnd.nextInt(ary.length);

    //Easy ( Implement both of these)
    //a - When choosing a pivot, use the median value of the lo,hi, and middle elements.
    //b - When a data element is equal to the pivot, make a 50% chance that you swap it to the other side.
    //taking the median number as the pivot
    int pivot = (ary[0]+ary[ary.length-1])/2;
    System.out.println("Pivot: "+pivot);
    //move the pivot to the first index
    //swap(pivot, 0, ary);
    //pivot = 0;
    //loop through the array and partition into less than and greater than sections based on pivot
    for (int i = 1; i < ary.length; i++){
      //System.out.println("ary["+i+"]: "+ary[i]);
      //System.out.println("ary[i]<ary[pivot]: "+(ary[i]<ary[pivot]));
      //System.out.println("Pivot value: "+ary[pivot]);
      //System.out.println("Pivot: "+pivot);
      //if (ary[i]<=ary[pivot]){
      if (ary[i]<=pivot){
        moveFront(i, ary);
        //System.out.println(toString(ary));
        //pivot++;
      }
    }
    return ary;
  }

  //swaps values
  private static void swap(int selectedIndex, int swapToIndex, int[] ary){
    int temp = ary[swapToIndex];
    ary[swapToIndex]=ary[selectedIndex];
    ary[selectedIndex]=temp;
  }

  private static void moveFront(int selectedIndex, int[] ary){
    int temp = ary[selectedIndex];
    for (int i = selectedIndex; i > 0; i--){
      ary[i]=ary[i-1];
    }
    ary[0]=temp;
  }

  private static void moveBack(int selectedIndex, int[] ary){
    int temp = ary[selectedIndex];
    for (int i = ary.length - 1; i > selectedIndex; i--){
      ary[i]=ary[i-1];
    }
    ary[selectedIndex]=temp;
  }
  public static String toString(int[] ary){
    String output = "{";
    for (int i = 0; i < ary.length; i++){
      output += ary[i];
      if (i != ary.length - 1){
        output+=", ";
      }
    }
    return output +"}";
  }
  //methods static
}
