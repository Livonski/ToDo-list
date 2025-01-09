package src.main.java;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.main.java.saves.SaveManager;
import src.main.java.tasks.TaskManager;
import javafx.scene.Parent;

public class ToDoListApplication extends Application
{
    @Override 
    public void start(Stage primaryStage) throws Exception{
        TaskManager taskManager = new TaskManager();
        SaveManager saveManager = new SaveManager();
        InputReader inputReader = new InputReader(taskManager, saveManager);
        saveManager.addLoadable(taskManager);
        saveManager.addSavable(taskManager);

        /*TextField taskNameInputField = new TextField("Input task name");
        TextField taskDescriptionInputField = new TextField("Input task description");

        Button addTaskButton = new Button("Add task");
        addTaskButton.setOnAction(e -> taskManager.addTask(taskNameInputField.getText(), taskDescriptionInputField.getText()));

        Button saveTasksButton = new Button("Save tasks");
        saveTasksButton.setOnAction(e -> saveManager.save());

        Button loadTasksButton = new Button("Load tasks");
        loadTasksButton.setOnAction(e -> saveManager.load());

        TextField taskIDRemovalField = new TextField("Input task ID");
        Button removeTaskButton = new Button("Remove task");
        removeTaskButton.setOnAction(e -> taskManager.removeTask(Integer.parseInt(taskIDRemovalField.getText())));

        Button clearTasksButton = new Button("Clear tasks");
        clearTasksButton.setOnAction(e -> taskManager.clearTasks());


        VBox root = new VBox(10);
        root.getChildren().addAll(taskNameInputField, taskDescriptionInputField, addTaskButton, saveTasksButton, loadTasksButton, taskIDRemovalField, removeTaskButton, clearTasksButton);*/

        //System.out.println(getClass().getResource("H:/Jaba/Projects/00_TODO_List/src/main/resources/fxml/AppLayout_0.1.fxml"));
        //System.out.println(getClass().getResource("../resources/fxml/AppLayout_0.1.fxml"));


        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/AppLayout_0.1.fxml"));
        loader.setController(inputReader);
        Parent root = loader.load();
        Scene scene = new Scene(root, 300,300);

        primaryStage.setTitle("JavaFX example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
