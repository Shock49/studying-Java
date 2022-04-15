package fiveOOP;

import fiveOOP.zoo.*;

public class AnimalCompetition {
    public static void main(String[] args) {
        Dog d1 = new Dog("Bobik",2,"black");
        Dog d2 = new Dog("Tuzik",5,"white");
        Horse h1 = new Horse("Irvin",1,"brown");
        Horse h2 = new Horse("Bella",4,"white");
        Cat c1 = new Cat("Persik",3,"red-headed");
        Cat c2 = new Cat("Hvosya",3,"brown");
        Bird b1 = new Bird("Kesha",1,"yelow");
        Bird b2 = new Bird("Ara",3,"white");
        Animal[] a = {d1,d2,h1,h2,c1,c2,b1,b2};
        int distanceRunDog = 500;
        int distanceSwimDog = 10;
        double distanceJumpDog = 0.5;
        int distanceRunHorse = 1500;
        int distanceSwimHorse = 100;
        double distanceJumpHorse = 3.0;
        int distanceRunCat = 200;
        int distanceSwimCat = 1;
        double distanceJumpCat = 2.0;
        int distanceRunBird = 5;
        int distanceSwimBird = 1;
        double distanceJumpBird = 0.2;
        int countRS = 0;
        double countJ = 0;
        String s = "";
        System.out.println("Animals ready start run !!!\n3....2....1...GO!!!!!");
        System.out.println("Distance fo run :\n dog " + distanceRunDog +"m      cat "+ distanceRunCat +
                "m\nhorse " + distanceRunHorse + "m     bird " + distanceRunBird);
        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(d1) || a[i].equals(d2)) {countRS = distanceRunDog; s = "Dog ";}
            if(a[i].equals(h1) || a[i].equals(h2)) {countRS = distanceRunHorse; s = "Horse ";}
            if(a[i].equals(c1) || a[i].equals(c2)) {countRS = distanceRunCat; s = "Cat ";}
            if(a[i].equals(b1) || a[i].equals(b2)) {countRS = distanceRunBird; s = "Bird ";}
            System.out.println(s + a[i].getFullInfo()+ ". Can ran distance : " + a[i].run(countRS));
        }
        System.out.println("------------------------------------\nRound 2");
        System.out.println("Distance fo jump :\n dog " + distanceJumpDog +"m      cat "+ distanceJumpCat +
                "m\nhorse " + distanceJumpHorse + "m     bird " + distanceJumpBird);
        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(d1) || a[i].equals(d2)) {countJ = distanceJumpDog; s = "Dog ";}
            if(a[i].equals(h1) || a[i].equals(h2)) {countJ = distanceJumpHorse; s = "Horse ";}
            if(a[i].equals(c1) || a[i].equals(c2)) {countJ = distanceJumpCat; s = "Cat ";}
            if(a[i].equals(b1) || a[i].equals(b2)) {countJ = distanceJumpBird; s = "Bird ";}
            System.out.println(s + a[i].getFullInfo()+ ". Can ran distance : " + a[i].jump(countJ));
        }
        System.out.println("------------------------------------\nRound 3");
        System.out.println("Distance fo jump :\n dog " + distanceSwimDog +"m      cat "+ distanceSwimCat +
                "m\nhorse " + distanceSwimHorse + "m     bird " + distanceSwimBird);
        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(d1) || a[i].equals(d2)) {countRS = distanceSwimDog; s = "Dog ";}
            if(a[i].equals(h1) || a[i].equals(h2)) {countRS = distanceSwimHorse; s = "Horse ";}
            if(a[i].equals(c1) || a[i].equals(c2)) {countRS = distanceSwimCat; s = "Cat ";}
            if(a[i].equals(b1) || a[i].equals(b2)) {countRS = distanceSwimBird; s = "Bird ";}
            System.out.println(s + a[i].getFullInfo()+ ". Can ran distance : " + a[i].swim(countRS));
        }
    }
}
