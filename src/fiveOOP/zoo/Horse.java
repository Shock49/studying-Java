package fiveOOP.zoo;

public class Horse extends Animal{

    public Horse(String name, int age, String color) {
        super(name, age, color);
        this.canRun = randomBorders(1000,2000);
        this.canJump = randomBorders(1.0,5.2);
        this.canSwim = randomBorders(50,200);
        this.type = "Horse";
    }

  }
