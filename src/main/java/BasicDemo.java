public class BasicDemo {


    public static void main(String ... args) {

    }


    public BasicDemo() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

// java code has 2 phases
// 1. phase -> source code converted to byte code -> java compiler
// 2. phase -> byte code -> machine code with the help of jvm
/*
   jdk ,jre , jvm


 */
// OOPS Concept -> access modifiers (Encapsulation)
class Student {
    private int roll; // default value of int -> 0, double -> 0.0,
    private String name;

    public Student(Integer roll, String name) {
        this.name = name;
        this.roll = roll;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class StudentDriver{

    public static void main(String[] args) {
        Student st1 = new Student(45, "Ram");
        Student st2 = new Student();
//        st2.setName("Shyam");
//        st2.setRoll(33);

        System.out.println(st1);
        System.out.println(st2);

    }
}
/*

 */














