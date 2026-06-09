package studentregistrationsystem;

import java.util.ArrayList;

public class Student extends Person {

    private final String major;

    private final ArrayList<Course> registeredCourses;

    public Student(String name,
                   int id,
                   String email,
                   String major) {

        super(name, id, email);

        this.major = major;

        registeredCourses = new ArrayList<>();
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) {

        if (!registeredCourses.stream().noneMatch((c) -> (c.getCode().equals(course.getCode())))) {
            return false;
        }

        registeredCourses.add(course);

        return true;
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
    }

    
    
    /*       throw new Student("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}*/}