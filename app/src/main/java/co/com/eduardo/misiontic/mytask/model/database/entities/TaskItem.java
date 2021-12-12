package co.com.eduardo.misiontic.mytask.model.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskItem {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private String date;
    private String state;

    public TaskItem() {
    }

    public TaskItem(String description, String date) {
        this.description = description;
        this.date = date;
        this.state = "PENDING";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date )
    {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state )
    {
        this.state = state;
    }
}
