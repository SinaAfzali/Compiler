import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private int studentCount;
    public boolean isOpen;

    public School(String name) {
        this.name = name;
        this.studentCount = 0;
        this.isOpen = true;
    }

    public void addStudent(String studentName) {
        if (isOpen) {
            studentCount = studentCount + 1;
            System.out.println("Added student: " + studentName);
        } else {
            System.out.println("School is closed");
        }
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void toggleOpen() {
        isOpen = !isOpen;
    }

    public static void main(String[] args) {
        School mySchool = new School("Greenwood");
        mySchool.addStudent("Alice");
        mySchool.addStudent("Bob");

        for (int i = 0; i < 3; i = i + 1) {
            mySchool.addStudent("Student" + i);
        }

        System.out.println("Total students: " + mySchool.getStudentCount());

        if (mySchool.isOpen) {
            mySchool.toggleOpen();
        } else {
            mySchool.toggleOpen();
        }
    }
}

interface Playable {
    void play();
}

class Game implements Playable {
    private String title;

    public Game(String title) {
        this.title = title;
    }

    public void play() {
        System.out.println("Playing " + title);
    }
}
