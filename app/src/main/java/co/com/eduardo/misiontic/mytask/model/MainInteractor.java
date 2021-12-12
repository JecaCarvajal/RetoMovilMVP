package co.com.eduardo.misiontic.mytask.model;

import java.util.ArrayList;
import java.util.List;

import co.com.eduardo.misiontic.mytask.mvp.MainMVP;
import co.com.eduardo.misiontic.mytask.view.dto.TaskItem;

public class MainInteractor implements MainMVP.Model {

    private List<TaskItem> tempItems;

    public MainInteractor() {
        tempItems = new ArrayList<>();
        tempItems.add(new TaskItem("Hacer el trabajo", "2021-12-10"));
    }

    @Override
    public List<TaskItem> getTasks() {
        return new ArrayList<>(tempItems);
    }

    @Override
    public void saveTask(TaskItem task) {
        tempItems.add(task);
    }

    @Override
    public void updateTask(TaskItem item) {

    }

    @Override
    public void deleteTask(TaskItem task) {

    }
}
