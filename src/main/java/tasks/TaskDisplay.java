package src.main.java.tasks;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TaskDisplay{

    @FXML
    private ListView<Task> tasksListView;
    private ObservableList<Task> tasks;

    public void initialize(ListView<Task> tasksListView){
        this.tasksListView = tasksListView;
        tasks = FXCollections.observableArrayList();
        tasksListView.setItems(tasks);
        tasksListView.setCellFactory(ListView -> new TaskCell());
    }
}
