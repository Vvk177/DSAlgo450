package ds.array;


import java.util.Arrays;

/**
 * without using any sorting algorithm
 */
public class a4SortArrayOf012 {
    /**
     * first solution using TreeSet
     * but that too uses internally sorting
     */

    public static void main(String[] args) {
        int[] inputArray = new Input().inputToIntArray();
        sortArray1(inputArray,inputArray.length);
    }





    /**
     * 2 2 1 1 0
     *
     * @param a
     * @return
     */
    private static void sortArray1(int[] a, int arr_size) {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }

    }
}
