package by.part6.homework;

public class HomeWork0 {

    static class Student{

        String firstName;
        String lastName;
        double mark;

        public Student() {
        }

        public Student(String firstName, String lastName, double mark) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.mark = mark;
        }

                public void print() {
            if (mark == 10){
                System.out.println("Student{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", mark=" + mark +
                        '}' + "WOW!!!!!!!!!!!!!");
            }else{
                System.out.println("Student{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", mark= " + mark +
                        '}');
            }
        }
    }


    @FunctionalInterface
    interface studentFactory<S extends Student>{
        S create(String firstName, String lastName, double mark);
    }

    public static void main(String[] args) {
        studentFactory<Student> studentFactory = Student::new;
        Student student = studentFactory.create("Peter", "Popkin", 8);
        Student student1 = studentFactory.create("Peter", "Jopkin", 10);
        student.print();
        student1.print();

    }
}
