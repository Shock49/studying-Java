package fiveOOP.zoo;

public class Dog extends Animal{
    private int canSwim;

    public Dog(String name, int age, String color) {
        super(name, age, color);
        this.canRun = randomBorders(400,600);
        this.canJump = randomBorders(0.3,1.5);
        this.canSwim = randomBorders(5,20);
    }

    @Override
    public boolean run(int a) {
        return a <= this.canRun;
    }

    @Override
    public boolean swim(int a) {
        return a <= this.canSwim;
    }

    @Override
    public boolean jump(double a) {
        return a <= this.canJump;
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + " max swim " + this.canSwim;
    }
}
