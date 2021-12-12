package co.com.eduardo.misiontic.mytask.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import co.com.eduardo.misiontic.mytask.model.database.entities.TaskItem;
import co.com.eduardo.misiontic.mytask.model.repository.TaskRepository;
import co.com.eduardo.misiontic.mytask.mvp.MainMVP;

public class MainInteractor implements MainMVP.Model {

    private TaskRepository taskRepository;

    public MainInteractor(Context context) {
         taskRepository = new TaskRepository(context);
    }


    @Override
    public List<TaskItem> getTasks() {
        return taskRepository.getAllTask();
    }

    @Override
    public void saveTask(TaskItem task) {
         taskRepository.AddTaskItem(task);
    }

    @Override
    public void updateTask(TaskItem item) {
        taskRepository.UpdatedTasItem(item);
    }

    @Override
    public void deleteTask(TaskItem task) {
        taskRepository.DeleteTaskItem(task);
    }
}
