import java.util.Random;
public class Quick{
  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
public int partitionR(int[] data, int start, int end){
  //select a random pivot
  Random rnd = new Random();
  int pivot = rnd.nextInt(data.length);
  //move the pivot to the first index
  swap(pivot, start, data);
  pivot = start;
  //loop through the array and partition into less than and greater than sections based on pivot
  for (int i = 1; i <= end; i++){
    //System.out.println("ary["+i+"]: "+ary[i]);
    //System.out.println("ary[i]<ary[pivot]: "+(ary[i]<ary[pivot]));
    //System.out.println("Pivot value: "+ary[pivot]);
    //System.out.println("Pivot: "+pivot);
    if (data[i]<=data[pivot]){
      moveFront(i, start, data);
      //System.out.println(toString(ary));
      pivot++;
    }
  }
  return pivot;
}

  /**
  *@return the index of the final position of the pivot element
  */
  public static int partitionOld(int[] ary, int start, int end){
    //Easy ( Implement both of these)
    //a - When choosing a pivot, use the median value of the lo,hi, and middle elements.
    //b - When a data element is equal to the pivot, make a 50% chance that you swap it to the other side.
    //taking the median number as the pivot
    int pivotV, pivot; //value and index respectively
    if ((ary[start]<=ary[end] && ary[start]>=ary[(start+end)/2])
      ||(ary[start]>=ary[end] && ary[start]<=ary[(start+end)/2])){ //if start is the median value
      pivotV = ary[start];
      pivot = start;
    }
    else if((ary[end]<=ary[start] && ary[end]>=ary[(start+end)/2])
      ||(ary[end]>=ary[start] && ary[end]<=ary[(start+end)/2])){ //if end is the median value
      pivotV = ary[end];
      pivot = end;
      }
    else{ //otherwise the middle is the median value
      pivotV = ary[(start+end)/2];
      pivot = (start+end)/2;
    }
    swap(pivot, start, ary); //move pivot to start
    pivot = start;
    System.out.println("Pivot: "+pivot);
    System.out.println("PivotV: "+pivotV);
    //loop through the array and partition into less than and greater than sections based on pivot
    for (int i = start; i < end+1; i++){
      //System.out.println("ary["+i+"]: "+ary[i]);
      //System.out.println("ary[i]<ary[pivot]: "+(ary[i]<ary[pivot]));
      //System.out.println("Pivot value: "+ary[pivot]);
      //System.out.println("Pivot: "+pivot);
      //if (ary[i]<=ary[pivot]){
      if (ary[i]<=pivotV){
        moveFront(i, start, ary);
        //System.out.println(toString(ary));
        pivot++;
      }
    }
    return pivot-1; //off by 1
  }

  //previous partition had a longer runtime because of moveFront, this one is changed to simply swap
  public static int partition(int[] ary, int start, int end){
    if (start == end){
      return start; //avoid negative index out of bounds
    }
    int pivot, pivotV;
    if ((ary[start]<=ary[end] && ary[start]>=ary[(start+end)/2])
      ||(ary[start]>=ary[end] && ary[start]<=ary[(start+end)/2])){ //if start is the median value
      pivotV = ary[start];
      pivot = start;
    }
    else if((ary[end]<=ary[start] && ary[end]>=ary[(start+end)/2])
      ||(ary[end]>=ary[start] && ary[end]<=ary[(start+end)/2])){ //if end is the median value
      pivotV = ary[end];
      pivot = end;
      }
    else{ //otherwise the middle is the median value
      pivotV = ary[(start+end)/2];
      pivot = (start+end)/2;
    }
   swap(pivot, start, ary); //move pivot to front
   pivot = start;
   System.out.println("Pivot: "+pivot);
   System.out.println("PivotV: "+pivotV);
   start++; //to avoid extra run in the while loop
   while (start != end) {
     if (ary[start] >= pivotV) {
       swap(start, end, ary);
       end--;
     }
     else {
       start++;
     }
   }
   //after while loop completes, update the last few values
   if (ary[pivot] < ary[start]){
     start--;
   }
   ary[pivot] = ary[start];
   ary[start] = pivotV;
   return start;
 }

  //swaps values
  private static void swap(int selectedIndex, int swapToIndex, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= data.length || swapToIndex < 0 || swapToIndex >= data.length){
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
    int temp = ary[swapToIndex];
    ary[swapToIndex]=ary[selectedIndex];
    ary[selectedIndex]=temp;
  }

  private static void moveFront(int selectedIndex, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= data.length) {
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
    int temp = ary[selectedIndex];
    for (int i = selectedIndex; i > 0; i--){
      ary[i]=ary[i-1];
    }
    ary[0]=temp;
  }

  private static void moveFront(int selectedIndex, int start, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= data.length) {
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
    int temp = ary[selectedIndex];
    for (int i = selectedIndex; i > start; i--){
      ary[i]=ary[i-1];
    }
    ary[start]=temp;
  }

  private static void moveBack(int selectedIndex, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= data.length) {
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
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
  /*return the value that is the kth smallest value of the array. k=0 is the smallest
 */
  public static int quickselect(int[] data, int k){
    if (k < 0 || k >= data.length) {
      throw new IllegalArgumentException("k out of bounds!"); //usually won't even happen :/
    }
    return 0; //dummy
  }

  /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data){

  }
}
