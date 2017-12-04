
/**
 * Created by Morten on 13.10.2017.
 */
public class BubbleSort {
    public  int[] bubbleSort(int[] list){
        boolean swapped;
        for(int i = 0; i < list.length;i++){
            swapped = false;
            for (int j = 0; j < list.length-1-i;j++){
                if(list[j]>list[j+1]){
                    int temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {9,7,4,3};
        new BubbleSort().bubbleSort(arr);

        for(int i : arr){
            System.out.println(i);
        }
    }

}
