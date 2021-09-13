package ds.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * input
 * 3 2 1 56 1000 167
 */
public class a2MaxAndMinArrayElements {
    public static void main(String[] args) {
        long[] inputArray=convertUserInputToArrayOfLong();
        Pair pair=method1FindMaxAndMin(inputArray);
//        Pair pair=method2FindMinAndMax(inputArray);
//        Pair pair=method3FindMinAndMax(inputArray,inputArray.length);
        System.out.println(pair.toString());
    }

    /**
     * using recursion
     * @param inputArray
     * @param size
     * @return
     */
    private static Pair method3FindMinAndMax(long[] inputArray, int size) {
        long min=findMin(inputArray,size);
        long max=findMax(inputArray,size);
        return new Pair(min,max);
    }

    private static long findMax(long[] inputArray, int size) {
        if(size==1){
            return inputArray[0];
        }
        return Math.max(inputArray[size-1],findMax(inputArray,size-1));
    }

    private static long findMin(long[] inputArray, int size) {
        if(size==1){
            return inputArray[0];
        }
        return Math.min(inputArray[size-1],findMax(inputArray,size-1));
    }


    /**
     * using collections.sort(arrayList)
     * @param inputArray
     */
    private static Pair method2FindMinAndMax(long[] inputArray) {
        List<Long> inputList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
        Collections.sort(inputList);
        return new Pair(inputList.get(0),inputList.get(inputList.size()-1));
    }

    /**
     * convert int[] to TreeSet<Integer>
     * @param inputArray
     */
    private static Pair method1FindMaxAndMin(long[] inputArray) {
        /**
         * convert int[] to List<Integer>
         */
        TreeSet<Long> inputSet=Arrays.stream(inputArray).boxed().
                collect(Collectors.toCollection(TreeSet:: new));
        return new Pair(inputSet.first(),inputSet.last());

    }

    private static long[] convertUserInputToArrayOfLong() {
        System.out.println("enter the array");
        Scanner sc =new Scanner(System.in);
        String input=sc.nextLine();
        /**
         * convert String to int[]
         */
        long[] inputArray= Arrays.stream(input.split(" ")).mapToLong(Long:: parseLong).toArray();
        return inputArray;
    }

    static class Pair{
        long max,min;
        public Pair(long min, long max){
            this.min=min;
            this.max=max;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "max=" + max +
                    ", min=" + min +
                    '}';
        }
    }
}


