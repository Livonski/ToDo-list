package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import src.main.java.saves.SaveManager;
import src.main.java.tasks.TaskManager;

public class InputReader {
    private TaskManager taskManager;
    private SaveManager saveManager;

    public InputReader(TaskManager taskManager, SaveManager saveManager){
        this.taskManager = taskManager;
        this.saveManager = saveManager;
    }

    @FXML
    private Button addTaskButton;

    @FXML
    private Button clearTasksButton;

    @FXML
    private Button loadTasksButton;

    @FXML
    private Button removeTaskButton;

    @FXML
    private Button saveTasksButton;

    @FXML
    private TextField taskDescriptionInputField;

    @FXML
    private TextField taskIDRemovalField;

    @FXML
    private TextField taskNameInputField;

    @FXML
    void onAddTask(ActionEvent event) {
        taskManager.addTask(taskNameInputField.getText(), taskDescriptionInputField.getText());
    }

    @FXML
    void onClearTasks(ActionEvent event) {
        taskManager.clearTasks();
    }

    @FXML
    void onRemoveTasks(ActionEvent event) {
        taskManager.removeTask(Integer.parseInt(taskIDRemovalField.getText()));
    }

    @FXML
    void onSaveTasks(ActionEvent event) {
        saveManager.save();
    }

    @FXML
    void onLoadTasks(ActionEvent event) {
        saveManager.load();
    }

}
