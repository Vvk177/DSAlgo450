package ds.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * For Input:
 * 6
 * 7 10 4 3 20 15
 * 3
 *
 * Your Output:
 * 7
 */
public class a3KthMaxAndMinArrayElements {

    public static void main(String[] args) {

        int[] inputArray= new Input().inputToIntArray();
        System.out.println("enter k ");
        Scanner sc= new Scanner(System.in);
        int k =sc.nextInt();
        Pair pair=method1KthMinAndMax(inputArray,k);



    }

    private static Pair method1KthMinAndMax(int[] inputArray, int k) {
        TreeSet<Integer> inputSet=Arrays.stream(inputArray).boxed().collect(Collectors.toCollection(TreeSet::new));
        List<Integer> sortedList= new ArrayList<>(inputSet);
        return new Pair(sortedList.get(k-1),sortedList.get((inputArray.length-1)-k));
    }

    static class Pair{
        int kthMax, kthMin;
        public Pair(int thMin,int kthMax) {
            this.kthMin=kthMin;
            this.kthMax=kthMax;

        }

        @Override
        public String toString() {
            return "Pair{" +
                    "kthMax=" + kthMax +
                    ", kthMin=" + kthMin +
                    '}';
        }
    }

}
