public class Main {
    public static void main(String[] args) {
        Semester [] semesters = new Semester[3];

        semesters[0] = new Semester();
        semesters[0].Name = "Spring";
        semesters[0].Code = "SP";

        semesters[1] = new Semester();
        semesters[1].Name = "Summer";
        semesters[1].Code = "SU";

        semesters[2] = new Semester();
        semesters[2].Name = "Fall";
        semesters[2].Code = "FA";

        Course [] courses = new Course[1];

        courses[0] = new Course();
        courses[0].Code = "PROG191";
        courses[0].Name = "Java Programming";

        Class [] classes = new Class[1];

        classes[0] = new Class(22);
        classes[0].Code = "GCS1001A";

        classes[0].Students[0] = new Student("Mr. A");
        classes[0].Students[0] = new Student("Mr. B");
        classes[0].Students[0] = new Student("Mr. C");

        ClassCourse classCourse = new ClassCourse();
        classCourse.Class = classes[0];
        classCourse.Course = courses[0];
        classCourse.Semester = semesters[1];
    }
}

class Course {
    String Code;
    String Name;
    int Credit;
    //...
}

class Student {
    private String Name;
    private String ID;
    private int Birthyear;
    private String Address;
    private String Phone;
    private String Email;
    //...

    // Constructor.
    public Student() {
        this.Name = "Test";
    }

    public Student(String name) {
        this.Name = name;
    }

    public Student(String name, String id) {
        this.Name = name;
    }

    public Student(int birthYear) {
        this.Birthyear = birthYear;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public int getAge() {
        return 2022 - this.Birthyear;
    }

    public String getID() {
        return this.ID;
    }
}

class Class {
    String Code;
    Student [] Students;

    public Class(int numOfStudent) {
        Students = new Student[numOfStudent];
    }
}

class Semester {
    String Name;
    String Code;
}

class ClassCourse {
    Course Course;
    Class Class;
    Semester Semester;
}