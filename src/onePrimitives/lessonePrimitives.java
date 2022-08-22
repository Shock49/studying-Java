package onePrimitives;

import java.util.Scanner;

public class lessonePrimitives {

    public static float math (int a,int b,int c,int d){
        return a*(b+(c/d))*1.0f;
    }

    public static boolean range (int a,int b){
        return (a+b)>=10 & (a+b)<=20;
    }

    public static boolean positiveNumber (int number){
        return number>=0;
    }

    public static void  greetings (String name){
        System.out.println("Hello, "+name+"!");
    }

    public static boolean leapYear(int year){
        if(year%400==0){return true;}
        else if(year%100!=0){return year%4==0;}
        else return false;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

       // int a = 47;
        System.out.println("Write a method that evaluates the expression a * (b + (c / d))" +
                " and returning a floating point result, where a, b, c, d are " +
                "integer inputs of this method;"+"\n"
                +"Enter 4 numbers \"a\" \"b\" \"c\" \"d\" separated by a space and press Enter:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(" a * (b + (c / d)) = "+math(a,b,c,d));
        System.out.println("\n"+"Write a method that takes two integers as input, and " +
                "checking that their "+"\n"+" sum lies between 10 and 20 (inclusive), " +
                        "if yes - return true, otherwise - false;\n");
        System.out.println("Enter а  :");
        a = sc.nextInt();
        System.out.println("Enter b  :");
        b = sc.nextInt();
        System.out.println("a + b = "+(a+b)+" expression - "+range(a,b));
        System.out.println("\n"+"Written method that can be used as an integer parameter" +"\n"+
                " must check if the number passed is positive or negative."+"\n"+" Note: " +
                "zero is used as a number. The result of the work is displayed in the console");
        System.out.println("Enter number + or -");
        a = sc.nextInt();
        System.out.println("Entered number is positive ? - "+ positiveNumber(a));
        System.out.println("\n"+"Write a method that takes as a parameter a string denoting " +
                "name,"+"\n"+" method should return the hello message Hello passed_name!; " +
                " Print a greeting to the console.\n"+"\n"+"Write a method that takes a string denoting " +
                "name,"+"\n"+" method should return the hello message Hello passed_name!; " +
                " Print greeting to console.\n");
        String s =sc.next();
        greetings(s);
        System.out.println("\n"+"* Write a method that determines if a year is a leap year." +"\n"+
                " Every 4th year is a leap year, except every 100th, while every 400th is a leap year. " +
                "To check the operation, output the results of the method to the console");
        System.out.println("Enter year : ");
        a = sc.nextInt();
        System.out.println("Leap year - "+leapYear(a));
    }
}
