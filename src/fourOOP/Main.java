package fourOOP;

public class Main {

    private static int averegeAge(Employee[] e){
        int count = 0;
        for (int i = 0; i < e.length; i++) {
            count += e[i].getAge();
        }
        return count/e.length;
    }

    private static int averegeSalary(Employee[] e){
        int count = 0;
        for (int i = 0; i < e.length; i++) {
            count += e[i].getSalary();
        }
        return count/e.length;
    }

    public static void main(String[] args) {

        Employee e1 = new Employee("Ivanov D.M.","operator","8-111-111-11-11",65000,29);
        Employee e2 = new Employee("Petrov A.I.","operator","8-222-222-22-22",65000,46);
        Employee e3 = new Employee("Sidorov A.A.","groop lider","8-333-333-33-33",80000,50);
        Employee e4 = new Employee("Fedorov A.S.","loader","8-444-444-44-44",45000,25);
        Employee e5 = new Employee("Kozlov V.D.","welder","8-555-555-55-55",75000,45);
        Employee[] staff = {e1,e2,e3,e4,e5};
        System.out.println("#1");
        for (int i = 0; i < staff.length; i++) {
            System.out.println((i+1) + " FIO : " + staff[i].getFIO() + "  position : " + staff[i].getPosition());
        }
        System.out.println("#2");
        for (int i = 0; i < staff.length; i++) {
            if(staff[i].getAge() > 40) System.out.println(staff[i].getFullInfo());
        }
        System.out.println("#3");
        for (int i = 0; i < staff.length; i++) {
            if(staff[i].getAge() > 45){
                staff[i].indexing(5000);
                System.out.println(staff[i].getFullInfo());
            }
        }
        System.out.println("#4");
        System.out.println("Averege age : " + averegeAge(staff) + "\nAverege salary : " + averegeSalary(staff));

    }
}
