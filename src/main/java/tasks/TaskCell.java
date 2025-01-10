package src.main.java.tasks;

import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class TaskCell extends ListCell<Task> {

    private HBox hbox = new HBox();
    private Label name = new Label();
    private Label description = new Label();
    private Button deleteButton = new Button("X");
    private Button editButton = new Button("E");

    public TaskCell(){
        super();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(name, description, editButton, deleteButton);
    }

    @Override
    protected void updateItem(Task task, boolean empty){
        super.updateItem(task, empty);

        if(empty || task == null){
            setText(null);
            setGraphic(null);
        } else {
            name.setText(task.getName());
            description.setText(task.getDescription());

            //TODO: do something for buttons
            deleteButton.setOnAction(null);
            editButton.setOnAction(null);

            setGraphic(hbox);
        }
    }
}
