
/**
 * Created by Morten on 15.11.2017.
 */
public class MergeSort {

    void mergeSort(int[] list, int l, int r) {

        if (l < r) {
            int q = (l + r) / 2;
            mergeSort(list, l, q);
            mergeSort(list, q + 1, r);
            merge(list, l, q, r);
        }
    }

    void merge(int[] list, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = list[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = list[m + j + 1];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            } else {
                list[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            list[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            list[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] test = {5,2,9,4,2,1,12};
        mergeSort.mergeSort(test,0,test.length-1);
        for(int i : test){
            System.out.println(i);
        }

    }
}
