package com.perenok.study.datastructure;

public class StudyMergeSort {

    public static int[] src;
    public static int[] tmp;

    public static void main(String[] args) {
        src = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 6};
        tmp = new int[src.length];
        printArray(src);
        mergeSort(0, src.length - 1);
        printArray(src);
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && src[p] < src[q])) {
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx++] = src[q++];
                }
            }

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && src[p] <= src[q])) {
                    tmp[idx] = src[p];
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx] = src[q];
                    tmp[idx++] = src[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }


    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
