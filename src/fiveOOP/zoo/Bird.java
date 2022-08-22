package fiveOOP.zoo;

public class Bird extends Animal{

    public Bird(String name, int age, String color) {
        super(name, age, color);
        this.canRun = randomBorders(1,8);
        this.canJump = randomBorders(0.1,0.5);
        this.type = "Bird";
    }

    @Override
    public boolean swim(int a) {
        System.out.print("Wow Bird can not to swim !!!");
        return false;
    }
}
