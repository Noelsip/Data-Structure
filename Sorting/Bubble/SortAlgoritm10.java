package Bubble;
public class SortAlgoritm10 {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    System.out.println();
                    System.out.println("Menukar Index " + j + " dan " + (j+1));

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    System.out.println("Array setelah ditukar: ");
                    for (int k = 0; k < array.length; k++){
                        System.out.print(array[k]+ " ");
                        
                    }
                    System.out.println();
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int []angka = {7, 8, 3, 4, 1, 8, 5, 6, 7, 2};
        System.out.println("Bubble Sort");

        System.out.println("Sebelum di sort");
        for (int i = 0; i < angka.length; i++) {
            System.out.print(angka[i]+" ");
        }
        System.out.println();
        long startTime = System.nanoTime();

        bubbleSort(angka);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println();

        System.out.println("Sesudah di sort");
        for (int i = 0; i < bubbleSort(angka).length; i++){
            System.out.print(bubbleSort(angka)[i]+" ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Waktu Sorting (nano): " + duration/1_000_000.0);
    }
}