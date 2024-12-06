package src.java;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.java.tasks.TaskManager;

public class ToDoListApplication extends Application
{
    @Override 
    public void start(Stage primaryStage)
    {
        TaskManager taskManager= new TaskManager();

        TextField taskNameInputField = new TextField("Input task name");
        TextField taskDescriptionInputField = new TextField("Input task description");

        Button button = new Button("Add task");
        button.setOnAction(e -> taskManager.addTask(taskNameInputField.getText(), taskDescriptionInputField.getText()));

        VBox root = new VBox(10);
        root.getChildren().addAll(taskNameInputField, taskDescriptionInputField, button);

        Scene scene = new Scene(root, 300,300);

        primaryStage.setTitle("JavaFX example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
