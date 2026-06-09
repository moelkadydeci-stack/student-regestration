package studentregistrationsystem;

public class Person {

    private final String name;
    private final int id;
    private final String email;

    public Person(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
