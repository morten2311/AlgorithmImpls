public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 7, 22, 17};
        System.out.println(arr.length);
        HeapSort heapSort = new HeapSort();

        heapSort.heapSort(arr);
        System.out.println("Tree");
        for (int i : arr) {
            System.out.println(i);
        }

    }

    public void buildMaxHeap(int[] list, int size) {
        for (int i = (size) / 2 - 1; i >= 0; i--) {
            System.out.println(i);
            maxHeapify(list, i, size);
        }
    }

    public void maxHeapify(int[] list, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        if (l < size && list[l] > list[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < size && list[r] > list[largest]) {
            largest = r;
        }
        if (largest != i) {
            int k = list[i];
            list[i] = list[largest];
            list[largest] = k;
            maxHeapify(list, largest, size);
        }
    }

    public void heapSort(int[] list) {
        buildMaxHeap(list, list.length);
        for (int i = list.length - 1; i > 0; i--) {
            int k = list[0];
            list[0] = list[i];
            list[i] = k;
            maxHeapify(list, 0, i);
        }

    }
}
