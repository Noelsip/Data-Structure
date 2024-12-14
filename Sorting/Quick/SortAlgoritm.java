package Quick;

import java.util.Arrays;

public class SortAlgoritm {
    static int count = 0;
    public static void main(String[] args) {
        int []number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println();
        System.out.println("== Sebelum Sorting ==");
        System.out.println(Arrays.toString(number));

        int ukuran = number.length;
        
        long awal = System.currentTimeMillis();

        quickSortAlgorithm(number, 0, ukuran-1);
        
        long akhir = System.currentTimeMillis();
        
        double waktu = akhir - awal ;
        
        System.out.println("\n");
        System.out.println("== Setelah Sorting ==");
        System.out.println(Arrays.toString(number));

        System.out.println("WAKTU SORTING: " + waktu + " ms");

        System.out.println("Count: " + count);

    }

    public static int quickSort(int []array, int low, int high){
    // QuickSort dengan pivot tengah
    // -----------------------------
        // int mid = (low + high)/2;
        // int pivot = array[mid];

        // int temp = array[mid];
        // array[mid] = array[high];
        // array[high] = temp;
    // -----------------------------

    // Quicksort dengan pivot awal
        // int pivot = array[low];
        // int i = low;
        // int j = high;


    // QuickSort dengan Pivot akhir
    // ---------------------------
        int pivot = array[high];
    // ---------------------------

    // Looping Pivot Awal
    // while (i < j){
    //     while (array[j] > pivot) {
    //         j--;
    //     }

    //     while (i < j && array[i] <= pivot) {
    //         i++;
    //     }

    //     if (j < i) {
    //         int temp = array[i];
    //         array[i] = array[j];
    //         array[j] = temp;

    //         System.out.println("Proses Patitioning: " + Arrays.toString(array));
    //     }
    // }

    // array[low] = array[j];
    // array[j] = pivot;

    // System.out.println("Proses Pivot Swap: " + Arrays.toString(array));

    // return j;

    // Looping Pivot Akhir
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                count++;
                System.out.println("Partitioning Process: " + Arrays.toString(array));
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        System.out.println("Pivot Swap Process: " + Arrays.toString(array));

        return (i + 1);
    }

    public static void quickSortAlgorithm(int []array, int low, int high){
        if (low < high) {
            int pi = quickSort(array, low, high);

            System.out.println("Rekursif Bagian Kiri: " + Arrays.toString(Arrays.copyOfRange(array, low, pi)));
            System.out.println("Rekursif Bagian Kanan: " + Arrays.toString(Arrays.copyOfRange(array, pi + 1, high + 1)));

            quickSortAlgorithm(array, low, pi - 1);
            quickSortAlgorithm(array, pi + 1, high);
            
        }
    }
}
