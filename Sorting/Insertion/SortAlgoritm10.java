package Insertion;

public class SortAlgoritm10 {

    public static int[] insertionSort(int[] array){
        int n = array.length;
        for(int i = 1; i < n; i++){
            int curr = array[i];
            int j = i - 1;

            boolean swapped = false;
            int swappedIndex = i;

            while(j >= 0 && array[j] > curr){
                array[j + 1] = array[j];
                j--;
                swapped = true;
                swappedIndex = j + 1;
            }
            array[j + 1] = curr;
            

            System.out.println();
            System.out.println("Step " + i + ": ");
            
            if (swapped) {
                System.out.println("Index Yang ditukar " + (j+1) + " dengan " + swappedIndex);
            }
            for (int k = 0; k < n; k++ ) {
                System.out.print(array[k] + " ");
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] angka = {7, 8, 3, 4, 1, 8, 5, 6, 7, 2};

        System.out.println();
        System.out.println("Sebelum Sorting: ");
        for (int i : angka) {
            System.out.print(i + " ");
        }
        System.out.println();

        long startTime = System.currentTimeMillis();

        System.out.println();
        int[] sortedAngka = insertionSort(angka);

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        System.out.println();
        System.out.println("Setelah Sorting: ");
        for (int i : sortedAngka) {
            System.out.print(i + " ");
        }


        System.out.println();
        System.out.println("Waktu Eksekusi: " + duration + " ms");


    }
}
