package fiveOOP.zoo;

import java.util.Random;

public abstract class Animal {
    private String name;
    private int age;
    private String color;
    protected int canRun;
    protected double canJump;

    protected Animal(String name,int age,String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public abstract boolean run(int a);
    public abstract boolean swim(int a);
    public abstract boolean jump(double a);
    protected int randomBorders(int min ,int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    protected double randomBorders(double min ,double max){
        Random random = new Random();
        return min+random.nextDouble(max - min) ;
    }
    public String getFullInfo(){
        return this.name + " " + this.age + " years old " + this.color + ", " +
                "max run " + this.canRun + ", max jump " + this.canJump;
    }
}
