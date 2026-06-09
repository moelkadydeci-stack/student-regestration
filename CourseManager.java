package studentregistrationsystem;

import java.util.HashMap;

public class CourseManager {

    private final HashMap<String, Course> courses;

    public CourseManager() {

        courses = new HashMap<>();

        courses.put("CS101",
                new Course("CS101", "Programming"));

        courses.put("CS102",
                new Course("CS102", "Data Structures"));

        courses.put("CS103",
                new Course("CS103", "Database"));

        courses.put("CS104",
                new Course("CS104", "Web Development"));
    }

    public HashMap<String, Course> getCourses() {
        return courses;
    }
}