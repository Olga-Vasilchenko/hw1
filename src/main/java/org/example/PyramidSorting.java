package org.example;

public class PyramidSorting {
    public static void main(String[] args) {
        int[] array = {25, 38, 41, 5, 1, 3, 89, 55, 11, 6, 10, 81, 75};

        pyramidSort(array);
        for (int i = 0; i < array.length; i++)
        System.out.print(array[i] + " ");
    }

    public static void pyramidSort(int[] array){
        int n = array.length;
        for(int i = n/2 - 1; i >= 0; i--)
            heap(array, i, n);
        for(int i = n - 1; i >=0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heap(array, 0, i);
        }
    }

    private static void heap(int[] array, int i, int n) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;
        if (i != largest) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heap(array, largest, n);
        }
    }
}