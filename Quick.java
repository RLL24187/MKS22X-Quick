import java.util.*;
public class Quick{
  public static void main(String[] args) {
    // Mr. K's driver
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
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
   //System.out.println("Pivot: "+pivot);
   //System.out.println("PivotV: "+pivotV);
   start++; //to avoid extra run in the while loop
   Random rnd = new Random();
   int r; //used to create the 50% chance
   while (start != end) {
     r = 3;
     if (pivotV == ary[start]) r = rnd.nextInt(2);
     if (ary[start] > pivotV || r == 1) {
       swap(start, end, ary);
       end--;
     }
     else if (ary[start] < ary[pivot] || r == 0){ //less than or equal with 50% chance
       start++;
     }
   }
   //after while loop completes, update the last few values
   if (ary[pivot] > ary[start]) {
      // if the pivot is bigger than start
      swap(start, pivot, ary) ;
      return start;
    }
    else {
      swap(start - 1, pivot, ary) ;
      return start - 1; //off by 1
    }
 }

  //swaps values
  private static void swap(int selectedIndex, int swapToIndex, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= ary.length || swapToIndex < 0 || swapToIndex >= ary.length){
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
    int temp = ary[swapToIndex];
    ary[swapToIndex]=ary[selectedIndex];
    ary[selectedIndex]=temp;
  }

  private static void moveFront(int selectedIndex, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= ary.length) {
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
    int temp = ary[selectedIndex];
    for (int i = selectedIndex; i > 0; i--){
      ary[i]=ary[i-1];
    }
    ary[0]=temp;
  }

  private static void moveFront(int selectedIndex, int start, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= ary.length) {
      throw new IllegalArgumentException("Index out of bounds!"); //Ideally shouldn't ever happen
    }
    int temp = ary[selectedIndex];
    for (int i = selectedIndex; i > start; i--){
      ary[i]=ary[i-1];
    }
    ary[start]=temp;
  }

  private static void moveBack(int selectedIndex, int[] ary){
    if (selectedIndex < 0 || selectedIndex >= ary.length) {
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
  public static int quickselectOld(int[] data, int k){
    if (k < 0 || k >= data.length) {
      throw new IllegalArgumentException("k out of bounds!"); //usually won't even happen :/
    }
    int p = partition(data, 0, data.length - 1); //final index of pivot element
    //store the left bound and right bounds
    int l = 0;
    int r = data.length - 1;
    //if (k < data.length / 2){
      while (p != k) { //p acts like start in partition's while loop: this only runs k times until element is put into the k "bucket"
        if (k > p){
          l = p + 1;
          p = partition(data, l, r); //run partition on the right half
        }
        else{
          r = p - 1;
          p = partition(data, l, r); //run partition on the left half
        }
        //System.out.println(toString(data));
        //System.out.println("Left bound: "+l);
        //System.out.println("Right bound: "+r);
        //System.out.println("Partition index: "+p);
      }
    return data[p];
  }

  public static int quickselect(int[] data, int k){
    if (k < 0 || k >= data.length){
      throw new IllegalArgumentException("k out of bounds!");
    }
    int[] ps = partitionDutch(data, 0, data.length - 1); //indices of middle section (=)
    //store left and right bounds
    int l = 0;
    int r = data.length - 1;
    while (ps[0] != k && ps[1]!=k){ //while both indices aren't equal to k
      if (k > ps[1]){
        l = ps[1]+1;
        ps = partitionDutch(data, l, r); //partition right half
      }
      else if (k < ps[0]){
        r = ps[0] - 1;
        ps = partitionDutch(data, l, r); //partition the left
      }
      else{ //if k is in between, then the value is in the equal section
        return data[ps[0]];
      }
    }
    return data[ps[0]]; 
  }

  public static int[] partitionDutch(int[] data, int lo, int hi){
    //beginning
    //|v|.......................| |
    //^lo/lt                    ^hi/gt
    //during
    //|<v...|=v....|........|>v...|
    //       ^lt    ^l     ^gt
    //after
    //|<v.......|=v........|>v....|
    //^lo       ^lo      ^gt     ^hi
    int lt = lo;
    int gt = hi;
    int i = lt + 1;
    int pivot = lo;
    //between lo and lt is the section for less than pivot
    //between lt and gt is the section for equaling pivot (data[lt] and data[gt] equal the pivot)
    //between gt and hi is the section for greater than pivot
    while (i <= gt) {
      if (data[i] < data[pivot]) {
        swap(lt, i, data); //swap lt and i
        lt++; // lt moves up one after switching data[lt] and new value != pivot
        i++; // up the current element
        pivot++; // pivot moves up 1 too
      } else if (data[i] == data[pivot]) {
        i++; // adjust index b/c it is equal to pivot value
      } else { // data[i] > data[pivot]
        swap(gt, i, data); //swap gt and i
        gt--; // gt down one after switching data[gt] and new value != pivot
      }
    }
   return new int[] {lt, gt}; //returns array with lt and gt
  }
  /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data){
    if (data.length > 1){ //lists of size 0 and 1 are already sorted
      quicksortDutchH(data, 0, data.length - 1);
    }
  }
  // helper for quicksort
  public static void quicksortH(int[] data, int start, int end) {
    if (start >= end) return;
    int a = partition(data, start, end);
    //System.out.println("Position of pivot is: " + a) ;
    quicksortH(data, start, a - 1); //run quicksort on the left half
    quicksortH(data, a + 1, end); //then run it on the right half
  }

  public static void quicksortDutch(int[] data){
    if (data.length > 1){ //lists of size 0 and 1 are already sorted
      quicksortDutchH(data, 0, data.length - 1);
    }
  }

  public static void quicksortDutchH(int[] data, int start, int end){
    if (start >= end){
     return;
   }
   int[] p = partitionDutch(data, start, end);
   quicksortDutchH(data, start, p[0]-1); //lt
   quicksortDutchH(data, p[1]+1, end); //gt
  }
}
