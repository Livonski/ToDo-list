package src.java;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.java.saves.SaveManager;
import src.java.tasks.TaskManager;

public class ToDoListApplication extends Application
{
    @Override 
    public void start(Stage primaryStage){
        TaskManager taskManager = new TaskManager();
        SaveManager saveManager = new SaveManager();
        saveManager.addLoadable(taskManager);
        saveManager.addSavable(taskManager);

        TextField taskNameInputField = new TextField("Input task name");
        TextField taskDescriptionInputField = new TextField("Input task description");

        Button addTaskButton = new Button("Add task");
        addTaskButton.setOnAction(e -> taskManager.addTask(taskNameInputField.getText(), taskDescriptionInputField.getText()));

        Button saveTasksButton = new Button("Save tasks");
        saveTasksButton.setOnAction(e -> saveManager.save());

        Button loadTasksButton = new Button("Load tasks");
        loadTasksButton.setOnAction(e -> saveManager.load());


        VBox root = new VBox(10);
        root.getChildren().addAll(taskNameInputField, taskDescriptionInputField, addTaskButton, saveTasksButton, loadTasksButton);

        Scene scene = new Scene(root, 300,300);

        primaryStage.setTitle("JavaFX example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
