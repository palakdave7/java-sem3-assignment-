import java.util.*;

class Student {
    int studentID;
    String name;
    

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    int getStudentID() {
        return studentID;
    }

    String getName() {
        return name;
    }
}

class Grade {
    int studentID;
    int CourseID;
    char Grade;

    public
    
    Grade(int studentID, int courseID, char grade) {
        this.studentID = studentID;
        this.CourseID = courseID;
        this.Grade = grade;
    }

    int getStudentID() {
        return studentID;
    }

    int getCourseID() {
        return CourseID;
    }

    int getGrade() {
        return Grade;
    }
}

class GradingSystem {
    Student[] students;
    Grade[] grades;
    String [] s1;
    int[] courseCredits;
    static int studentCount = 0;
    int gradeCount=0;
    int creditCount=0;
    int len=0;

    public
    
    void displayresult(int id)
    {
        for(int i=0;i<studentCount;i++)
        {
            if(id==students[i].getStudentID())
            {
                System.out.println("Student name : " + students[i].getName());
                System.out.println("Student ID : " + students[i].getStudentID());
                for(int k=0;k<len;k++)
                {
                    System.out.println("grade "+s1[k]);
                }
               // addGrade(grades,credit) ;
                System.out.println("GPA : "+calculateGPA(id));

            }
        }
    }
    GradingSystem(int maxStudents) {
        students = new Student[maxStudents];
        grades = new Grade[2000];
        courseCredits = new int[1000];
        s1=new String[100];
    }

        void addStudent(int id, String name) {
        students[studentCount] = new Student(id, name);
        studentCount++;
    }

    void addGrade(String[] grade,int credit[]) {
        int total = 0;
        for (int i = 0; i < grade.length; i++) {
            len++;
            s1[i]=grade[i];
            total += (gradeTopoints(grade[i])*credit[i]);
            gradeCount=total;
        }
        addCourseCredits( credit);
    }

    void addCourseCredits( int credit[]) {
        int totalcredit=0;
        for(int y=0;y<credit.length;y++)
        {
            totalcredit+=credit[y];
        }
        creditCount=totalcredit;
    }

    double calculateGPA(int studentID) {
       // addGrade(String[] grade,int credit[]);
      //  addCourseCredits( int credit[]);
        return (double)gradeCount/creditCount;
    }

    int gradeTopoints(String grade) {
        switch (grade) {
            case "A":
                return 10;
            case "B":
                return 9;
            case "C":
                return 8;
            case "D":
                return 6;
            case "F":
                return 4;
            default:
                throw new IllegalArgumentException("Invalid grade.");
        }

    }

}

public class GradingSystemMGTM {
    public static void main(String[] args) {
        GradingSystem stu = new GradingSystem(10);

        Scanner in = new Scanner(System.in);
        int f=0;
        while(true)
        {

        System.out.println("Enter your choice : ");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
            System.out.println("Enter student id : ");
                int id = in.nextInt();
                System.out.println("Enter student name : ");
                String name1 = in.next();
                stu.addStudent(id, name1);
                System.out.println("enter number of courses:");
                int totalsub = in.nextInt();
                String[] ts = new String[totalsub];
                
                for (int i = 0; i < totalsub; i++) {
                    System.out.print("Enter grade : ");
                    ts[i] = in.next();
                }
                

                int credit[] = new int[totalsub];
                for (int k = 0; k < totalsub; k++) {
                    System.out.print("Enter credit : ");
                    credit[k] = in.nextInt();
                }
                stu.addGrade(ts,credit);
                break;
                case 2:
                System.out.print("Enter desired id : ");
                int idd=in.nextInt();
               // addGrade(grades,credit) ;
                  stu.displayresult(idd);
                  case 3:
                  f=1;
                  break;
            default:
                break;
        }
        if(f==1) break;
    }
    }
}
