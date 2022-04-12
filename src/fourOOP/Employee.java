package fourOOP;

public class Employee {

    private String FIO;
    private String position;
    private String phone;
    private int salary;
    private int age;

    public Employee(String FIO, String position, String phone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getFullInfo(){
        return "FIO " + this.FIO + " position " + this.position + " pone " + this.phone +
                " salary " + this.salary + " age " + this.age;
    }

    public void indexing( int sum){
        this.salary += sum;
    }
}
