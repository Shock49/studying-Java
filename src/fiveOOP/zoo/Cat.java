package fiveOOP.zoo;

public class Cat extends Animal{

    public Cat(String name, int age, String color) {
        super(name, age, color);
        this.canRun = randomBorders(100,300);
        this.canJump = randomBorders(1.5,3.0);
        this.type = "Cat";
    }


    @Override
    public boolean swim(int a) {
        System.out.print("Wow Cat can not to swim !!!");
        return false;
    }
}
