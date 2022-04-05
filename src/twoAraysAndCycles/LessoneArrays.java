package twoAraysAndCycles;

import java.util.Arrays;

public class LessoneArrays {
    private static void swap(int [] arr){
        for (int i=0;i<arr.length;i++){
            if(arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }

    private static void fillArrStep3 (int [] arr){
        int k = 1;
        for (int i=0; i<arr.length;i++){
            arr[i] = k;
            k+=3;
        }
    }

    private static void mathOperation (int [] arr){
        for (int i=0; i<arr.length; i++){
            if (arr[i]<6) arr[i] *= 2;
        }
    }

    private static int arrMax(int[] arr){
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }

    private static int arrMin(int[] arr){
        int min = arr[0];
        for (int i=1; i<arr.length; i++){
            if(arr[i]<min) min = arr[i];
        }
        return min;
    }

    private static void printDoublArr(int [][] arr){
        for (int i=0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void changDiagonal(int[][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if(i==j || j == arr[i].length-1-i)  arr[i][j] = 1;
            }
        }
    }

    private static boolean checkBalance(int[] arr){
        int sumLeft = 0;
        for (int i=0;i<arr.length;i++){
            int sumRight = 0;
            sumLeft +=arr[i];
            for(int j=i+1;j<arr.length;j++){
                sumRight += arr[j];
            }
            if(sumLeft == sumRight) return true;
        }
        return false;
    }

    private static void shiftArry(int[] arr,int n){
        int count = n;
        if(Math.abs(n)>arr.length)count = n % arr.length;
        int[] temporaryArr = Arrays.copyOf(arr,arr.length);
        for(int i=0; i<temporaryArr.length; i++){
            if(count>=arr.length) count = 0;
            if(count < 0 ) {
                arr[arr.length+count] = temporaryArr[i];
                count++;
                continue;
            }
            arr[count] = temporaryArr[i];
            count++;
        }
    }

    private static void shiftArrays2(int[] arr, int n){
        int buffer;
        int count = 0;
        while (count < Math.abs(n)){
            if( n> 0) {
                for (int i = 0; i < arr.length - 1; i++) {
                    buffer = arr[i + 1];
                    arr[i + 1] = arr[0];
                    arr[0] = buffer;
                }
            }else {
                int  k = -1;
                for (int i = 0; i < arr.length-1; i++){
                    if(k+i < 0) k = arr.length-1;
                    buffer = arr[i+k];
                    arr[i+k] = arr[i];
                    arr[i] = buffer;
                    k = -1;
                }
            }
            count++;
        }
    }

    public static void main (String [] args){
        //#1
        System.out.println("1. Specify an integer array consisting of elements 0 and 1. \n" +
                "For example: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. " +
                "Write a method that replaces 0 with 1 in the received array, 1 with 0;");
        int [] arr = new int[5];
        Arrays.fill(arr,(int)(Math.random()*2));
        System.out.println(Arrays.toString(arr));
        swap(arr);
        System.out.println("sawp \n"+Arrays.toString(arr));
        //#2
        System.out.println("\n2. Set an empty integer array of size 8." +
                " Write a method that will fill it with the values 1 4 7 10 13 16 19 22 using a loop;");
        int [] arr2 = new int[8];
        fillArrStep3(arr2);
        System.out.println(Arrays.toString(arr2));
        //#3
        System.out.println("\n3. Set an array [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],\n" +
                " write a method that takes an array as input and multiplies numbers less than 6 by 2;");
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        mathOperation(arr3);
        System.out.println(Arrays.toString(arr3));
        //#4
        System.out.println("\n4. Specify a one-dimensional array. " +
                "Write methods for finding the minimum and maximum element in it;");
        System.out.println(Arrays.toString(arr3));
        System.out.println("max = " + arrMax(arr3) + " min = " + arrMin(arr3));
        //#5
        System.out.println("\n*5.  Create a square two-dimensional integer array " +
                "(the number of rows and columns is the same),\n" +
                " fill its diagonal elements with units using a loop (s);");
        int [][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length;i++){
            Arrays.fill(arr4[i],0);
        }
        printDoublArr(arr4);
        changDiagonal(arr4);
        System.out.println();
        printDoublArr(arr4);
        //#6
        System.out.println("\n**6. Write a method that is passed a non-empty one-dimensional integer array,\n " +
                "the method must return true if there is a place in the array where the sum of the left \n" +
                "and right parts of the array are equal. Examples: checkBalance([1, 1, 1, || 2, 1]) → true, \n" +
                "checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3 , 4]) → true. \n" +
                "The abstract border is shown with || characters, these characters are not included in the array.");
        int[] arr5 = {1, 1, 1, 2, 1};
        int[] arr6 = {2, 1, 1, 2, 1};
        int[] arr7 = {10, 1, 2, 3 , 4};
        System.out.println("arr5 [1, 1, 1, || 2, 1] balance: " + checkBalance(arr5) +
                "\narr6[2, 1, 1, 2, 1] balance: " + checkBalance(arr6) +
                "\narr7 [10, || 1, 2, 3 , 4] balance : " +checkBalance(arr7));
        //#7
        System.out.println("\n***7. Write a method that occurs on a one-dimensional array and is numeric " +
                "(may be prompted or denied entry),\nwith this method to loop through all array elements in position.");
        int[] arr8 = {0,1,2,3,4};
        int n = 2;
        System.out.print("arr8 = "+ Arrays.toString(arr8)+" n = " + n + " --> ");
        shiftArry(arr8,n);
        System.out.println( Arrays.toString(arr8));
        //#8
        System.out.println("\n****8. Do not use an auxiliary array when solving problem 7.");
        int[] arr9 = {0,1,2,3,4};
        n = -1;
        System.out.print("arr9 = "+ Arrays.toString(arr9)+" n = " + n + " --> ");
        shiftArrays2(arr9,n);
        System.out.print(Arrays.toString(arr9));
    }
}
