package fiveOOP.zoo;

public class Dog extends Animal{

    public Dog(String name, int age, String color) {
        super(name, age, color);
        this.canRun = randomBorders(400,600);
        this.canJump = randomBorders(0.3,1.5);
        this.canSwim = randomBorders(5,20);
        this.type = "Dog";
    }

  }
