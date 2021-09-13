package ds.array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * reverse the array
 */
public class a1ReverseArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the array");
        String input=sc.nextLine();

        int[] inputArray =Arrays.stream(input.split(" ")).mapToInt(Integer:: parseInt).toArray();

        //        int[] reverse=reverseMethod1(inputArray);
        //        reverseMethod2(inputArray);
        reverseMethod3(inputArray);
    }

    /**
     * loop through half the array
     * and swap elements at same position from front and back
     * @param inputArray
     *
     * returns the same array as reversed
     */
    private static void reverseMethod3(int[] inputArray) {
        int size = inputArray.length;
        int temp;
        for(int i=0; i< (size/2);i++){
            temp= inputArray[i];
            inputArray[i]=inputArray[size-i-1];
            inputArray[size-i-1]=temp;
        }
        System.out.println(Arrays.toString(inputArray));
    }

    /**
     * Convert int[] inputArray -> List<Integer>
     * so that we can use Collections.reverse(List<?> list) method return type void
     * and then convert back list to int[]
     * inputList.stream().mapToInt(Integer :: intValue).toArray();
     * @param inputArray
     */
    private static void reverseMethod2(int[] inputArray) {
        /**
         * int[] data = {1,2,3,4,5,6,7,8,9,10};
         *
         * // To boxed array
         * Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
         * Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );
         *
         * // To boxed list
         * List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
         * List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );
         */
//        Integer[] array= Arrays.stream(inputArray).boxed().toArray(Integer[]:: new);
//        Collections.reverse(Arrays.asList(array));
//        System.out.println(Arrays.toString(array));
        List<Integer> inputList= Arrays.stream(inputArray).boxed().collect(Collectors.toList());
        Collections.reverse(inputList);
        System.out.println(Arrays.toString(inputList.stream().mapToInt(Integer :: intValue).toArray()));
    }

    /**
     * Convert int[] -> StringBuilder
     * StringBuilder sb= new StringBuilder(Arrays.toString(inputArray).replace("[","")
     *                  .replace("]","").replace(",",""));
     * then reverse the StringBuilder
     * sb= sb.reverse();
     * and convert SB -> int[]
     * Arrays.stream(sb.toString().split(" ")).mapToInt(Integer:: parseInt).toArray();
     * @param inputArray
     * @return
     */
    private static int[] reverseMethod1(int[] inputArray) {
        /**
         * step1: firstly convert int[] -> String
         * StringBuilder sb= new StringBuilder(Arrays.toString(array));
         *
         */
        StringBuilder sb = new StringBuilder(Arrays.toString(inputArray).replace("[","").
                replace("]","").replace(",",""));
        sb = sb.reverse();

        /**
         * String class .split(" ") returns String[]
         */
        int[] reverseArray =Arrays.stream(sb.toString().split(" ")).mapToInt(Integer:: parseInt).toArray();
        return  reverseArray;
    }
}
