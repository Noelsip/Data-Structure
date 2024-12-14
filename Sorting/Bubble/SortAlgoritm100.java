package Bubble;
import java.util.Arrays;

public class SortAlgoritm100 {

    public static int[] bubbleSort(int[] array){
        for (int i=0; i < array.length; i++){
            for (int j=0; j < array.length - i - 1; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSortDescending(int[] array){
        for (int i=0; i < array.length-1; i++){
            for (int j=0; j < array.length - i - 1; j++){
                if (array[j] <  array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] angka = {
            90, 71, 64, 32, 2, 10, 54, 74, 79, 85, 84, 47, 12, 69, 94, 97, 16, 25, 26, 63, 51, 100, 41, 60, 48, 36, 82, 
            33, 89, 52, 78, 56, 50, 3, 57, 67, 11, 43, 99, 30, 9, 88, 92, 22, 7, 23, 80, 86, 17, 24, 39, 15, 73, 27, 14, 
            65, 20, 59, 21, 40, 6, 70, 55, 68, 4, 31, 53, 96, 61, 45, 77, 58, 98, 87, 91, 66, 46, 62, 42, 76, 34, 44, 75, 
            1, 93, 5, 83, 81, 19, 35, 29, 37, 28, 13, 49, 95, 38, 72, 18, 8
        };

        System.out.println();
        System.out.println("Sebelum sorting");
        for(int i = 0; i < angka.length; i++){
            System.out.print(angka[i] + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        int[] angkaSorted = Arrays.copyOf(angka, angka.length);
        int[] angkaDescending = Arrays.copyOf(angka, angka.length);

        bubbleSort(angkaSorted);
        bubbleSortDescending(angkaDescending);
        
        long endTime = System.nanoTime();

        long duration = endTime - startTime ;

        System.out.println();
        System.out.println("Setelah sorting");
        for(int i = 0; i < angkaSorted.length; i++){
            System.out.print(angkaSorted[i] + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Setelah sorting balik: ");
        for (int i = 0; i < angkaDescending.length ; i++){
            System.out.print(angkaDescending[i] + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Waktu Sorting (nano): " + duration / 1_000_000.0);
        
    }
}
