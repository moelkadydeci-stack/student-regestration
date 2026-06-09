package studentregistrationsystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentRegistrationSystem extends Application {

    private Student student;

    @Override
    public void start(Stage primaryStage) {

        Label title =
                new Label("Login System");

        TextField username =
                new TextField();

        username.setPromptText("Username");

        PasswordField password =
                new PasswordField();

        password.setPromptText("Password");

        Button login =
                new Button("Login");

        VBox loginRoot =
                new VBox(15);

        loginRoot.setAlignment(Pos.CENTER);

        loginRoot.getChildren().addAll(
                title,
                username,
                password,
                login
        );

        Scene loginScene =
                new Scene(loginRoot, 500, 400);

        login.setOnAction(e -> {

            if (username.getText().equals("admin")
                    && password.getText().equals("1234")) {

                openDashboard(primaryStage);

            } else {

                Alert alert =
                        new Alert(Alert.AlertType.ERROR);

                alert.setHeaderText(null);

                alert.setContentText("Wrong Username or Password");

                alert.showAndWait();
            }
        });

        primaryStage.setTitle("Student Registration System");

        primaryStage.setScene(loginScene);

        primaryStage.show();
    }

    private void openDashboard(Stage stage) {

        student = new Student(
                "Ahmed Ali",
                1001,
                "ahmed@gmail.com",
                "Computer Science"
        );

        Course c1 =
                new Course("CS101",
                        "Java Programming",
                        3);

        Course c2 =
                new Course("CS102",
                        "Data Structures",
                        3);

        Course c3 =
                new Course("CS103",
                        "Database Systems",
                        3);

        Course c4 =
                new Course("CS104",
                        "Software Engineering",
                        3);

        Course c5 =
                new Course("CS105",
                        "Artificial Intelligence",
                        3);

        ComboBox<Course> courses =
                new ComboBox<>();

        courses.getItems().addAll(
                c1, c2, c3, c4, c5
        );

        ObservableList<Course> registered =
                FXCollections.observableArrayList();

        ListView<Course> listView =
                new ListView<>(registered);

        Label studentInfo =
                new Label(
                        "Student: "
                        + student.getName()
                        + " | ID: "
                        + student.getId()
                        + " | Major: "
                        + student.getMajor()
                );

        Label counter =
                new Label(
                        "Total Registered Courses: 0"
                );

        Button register =
                new Button("Register Course");

        Button remove =
                new Button("Remove Selected");

        register.setOnAction((ActionEvent e) -> {
            Course selected =
                    courses.getValue();
            
            if (selected == null) {
                
                Alert alert =
                        new Alert(Alert.AlertType.WARNING);
                
                alert.setContentText(
                        "Please Select a Course"
                );
                
                alert.showAndWait();
                
                return;
            }
            
            boolean success =
                    student.registerCourse(selected);
            
            if (success) {
                
                registered.add(selected);
                
                counter.setText(
                        "Total Registered Courses: "
                                + registered.size()
                );
                
                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);
                
                alert.setContentText(
                        "Course Registered Successfully"
                );
                
                alert.showAndWait();
                
            } else {
                
                Alert alert =
                        new Alert(Alert.AlertType.ERROR);
                
                alert.setContentText(
                        "Course Already Registered"
                );
                
                alert.showAndWait();
            }
        });

        remove.setOnAction((ActionEvent e) -> {
            Course selected =
                    listView.getSelectionModel()
                            .getSelectedItem();
            
            if (selected != null) {
                
                registered.remove(selected);
                
                student.removeCourse(selected);
                
                counter.setText(
                        "Total Registered Courses: "
                                + registered.size()
                );
            }
        });

        VBox root =
                new VBox(15);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                studentInfo,
                courses,
                register,
                remove,
                counter,
                listView
        );

        Scene dashboard =
                new Scene(root, 700, 500);

        stage.setScene(dashboard);
    }

    public static void main(String[] args) {
        launch(args);
    }
}