package fiveOOP.zoo;

public class Horse extends Animal{
    private int canSwim;

    public Horse(String name, int age, String color) {
        super(name, age, color);
        this.canRun = randomBorders(1000,2000);
        this.canJump = randomBorders(1.0,5.2);
        this.canSwim = randomBorders(50,200);
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
