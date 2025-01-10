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
