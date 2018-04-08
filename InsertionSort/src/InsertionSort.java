/**
 * Created by Morten on 14.10.2017.
 */
public class InsertionSort {
    public int[] insertionSort(int[] list){
        int i = 1;
        while(i < list.length){
            int j = i;
                while( j > 0 && list[j-1] > list[j] ){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                    j--;

                }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] test = {5,2,9,4,2,1};
        insertionSort.insertionSort(test);
        for(int i : test){
            System.out.println(i);
        }

    }
}
