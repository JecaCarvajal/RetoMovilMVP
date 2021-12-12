package co.com.eduardo.misiontic.mytask.model.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import co.com.eduardo.misiontic.mytask.view.dto.TaskState;

@Entity
public class TaskItem {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private String date;
    private TaskState state;

    public TaskItem(String description, String date) {
        this.description = description;
        this.date = date;
        this.state = TaskState.PENDING;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }
}
