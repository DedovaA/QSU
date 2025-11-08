package aston.final_project;

import java.util.Collections;
import java.util.List;

public class SortUtils {

    public static <T extends Comparable<T>> void quickSort(List<T> arr) {
        if (arr == null) return;
        quickSort(arr, 0, arr.size() - 1);
    }

    public static <T extends Comparable<T>> void quickSort(List<T> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> arr, int low, int high) {
        T pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }
}
