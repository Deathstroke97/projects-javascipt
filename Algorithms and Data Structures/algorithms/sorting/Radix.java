package com.example.packages.algorithms.sorting;

import java.util.Arrays;

public class Radix {


    static void countSort(int arr[], int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        /*for (i = 0; i < n; i++) {
            output[count[(arr[i]/exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }*/
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }


    static int getMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void radixSort(int[] arr, int n) {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }


    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
