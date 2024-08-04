import java.util.Scanner;

class Student {
    private int age;
    private int id;
    private String name;
    private String dept;

    public int getStudentId() {
        return id;
    }

    public int getStudentAge() {
        return age;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentDept() {
        return dept;
    }

    Student(int age, int id, String name, String dept) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.dept = dept;
    }
}

class StudentRecordSystem {
    private Student[] students;
    private int scount;

    public StudentRecordSystem(int capacity) {
        students = new Student[capacity];
        scount = 0;
    }

    public void addStudent(int id, int age, String name, String dept) {
        if (scount < students.length) {
            students[scount] = new Student(age, id, name, dept);
            scount++;
        } else {
            System.out.println("No more students can be added. Array is full.");
        }
    }

    public Student getStudentById(int sid) {
        for (int j = 0; j < scount; j++) {
            if (students[j].getStudentId() == sid) {
                return students[j];
            }
        }
        return null;
    }

    public void displayAll() {
        for (int j = 0; j < scount; j++) {
            System.out.println("Student id = " + students[j].getStudentId());
            System.out.println("Student age = " + students[j].getStudentAge());
            System.out.println("Student name = " + students[j].getStudentName());
            System.out.println("Student department = " + students[j].getStudentDept());
        }
    }
}

public class studentmgmt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordSystem srs = new StudentRecordSystem(10); // Specify capacity
        int id, age;
        String name, dept;
        
        while(true)
        {

        

        System.out.println("Enter 1 to add the details of the student");
        System.out.println("Enter 2 to display the details using id");
        System.out.println("Enter 3 to display all details of the students");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline
            int f=0;
        switch (choice) {
            case 1:
                System.out.println("Enter student id:");
                id = sc.nextInt();
                System.out.println("Enter student age:");
                age = sc.nextInt();
                sc.nextLine(); // Consume the newline
                System.out.println("Enter student name:");
                name = sc.nextLine();
                System.out.println("Enter student department:");
                dept = sc.nextLine();
                srs.addStudent(id, age, name, dept);
                break;

            case 2:
                System.out.println("Enter the id:");
                int tempId = sc.nextInt();
                Student student = srs.getStudentById(tempId);
                if (student != null) {
                    System.out.println("Student id = " + student.getStudentId());
                    System.out.println("Student age = " + student.getStudentAge());
                    System.out.println("Student name = " + student.getStudentName());
                    System.out.println("Student department = " + student.getStudentDept());
                } else {
                    System.out.println("Student not found.");
                }
                break;

            case 3:
                srs.displayAll();
                break;

                case 4:
                f=1;
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
            if(f==1) break;
    //    sc.close();
    }
    }
}