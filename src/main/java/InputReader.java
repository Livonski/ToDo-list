package src.main.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import src.main.java.saves.SaveManager;
import src.main.java.tasks.TaskCell;
import src.main.java.tasks.TaskManager;
import src.main.java.tasks.Task;

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
    private ListView<Task> tasksListView;

    //private ObservableList<Task> tasks;


    
    public void initialize(){
        //tasks = FXCollections.observableArrayList();
        tasksListView.setItems(taskManager.getTasks());
        tasksListView.setCellFactory(ListView -> new TaskCell());
    }

    @FXML
    void onAddTask(ActionEvent event) {
        String name = taskNameInputField.getText();
        String description = taskDescriptionInputField.getText();

        if(name != null && !name.isEmpty()){
            if(tasksListView.getItems() == null)
                initialize();
            taskManager.addTask(name, description);
            taskDescriptionInputField.clear();
            taskNameInputField.clear();
        }
    }

    @FXML
    void onClearTasks(ActionEvent event) {
        taskManager.clearTasks();
        //tasksListView.setItems(taskManager.getTasks());
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
        tasksListView.setItems(taskManager.getTasks());
    }
}
