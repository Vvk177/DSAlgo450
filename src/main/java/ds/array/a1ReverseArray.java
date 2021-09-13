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

        /**
         * String class does not have reverse method, SB has
         * Arrays.toString(array)- to convert array to String
         * string object .replace("[","") to replace particular character sequence
         */


        //        int[] reverse=reverseMethod1(inputArray);
        reverseMethod2(inputArray);
        /**
         * Convert list to Array
         */


    }

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
        //Integer[] array= Arrays.stream(inputArray).boxed().toArray(Integer[]:: new);
//        Collections.reverse(Arrays.asList(array));
//        System.out.println(Arrays.toString(array));
        List<Integer> inputList= Arrays.stream(inputArray).boxed().collect(Collectors.toList());
        Collections.reverse(inputList);
        System.out.println(Arrays.toString(inputList.stream().mapToInt(Integer :: intValue).toArray()));
    }

    private static int[] reverseMethod1(int[] inputArray) {
        /**
         * step1: firstly convert int[] -> String
         * StringBuilder sb= new StringBuilder(Arrays.toString(array));
         *
         */
        StringBuilder sb = new StringBuilder(Arrays.toString(inputArray).replace("[","").
                replace("]","").replace(",",""));
        sb = sb.reverse();

        int[] reverseArray =Arrays.stream(sb.toString().split(" ")).mapToInt(Integer:: parseInt).toArray();
        return  reverseArray;
    }


}
