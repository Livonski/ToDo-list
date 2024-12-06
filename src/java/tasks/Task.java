package src.java.tasks;
public class Task {
    private Integer ID;
    private String name;
    private String description;

    public Task(Integer ID, String name, String description)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public Integer getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
       return description;
    }
}
