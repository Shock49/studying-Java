package fiveOOP.zoo;

import java.util.Random;

public abstract class Animal {
    private String name;
    private int age;
    private String color;
    protected String type;
    protected int canRun;
    protected double canJump;
    protected int canSwim;

    protected Animal(String name,int age,String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public boolean run(int a) {
        return a <= this.canRun;
    }
    public boolean swim(int a) {
        return a <= this.canSwim;
    }
    public boolean jump(double a) {
        return a <= this.canJump;
    }
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
                "max run " + this.canRun + ", max jump " + String.format("%.2f",this.canJump) + " max swim " + this.canSwim;
    }
    public String getType() {
        return type;
    }
}
