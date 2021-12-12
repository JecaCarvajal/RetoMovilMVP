package co.com.eduardo.misiontic.mytask.mvp;

import android.content.Context;

import java.util.List;

import co.com.eduardo.misiontic.mytask.model.database.entities.TaskItem;

public interface MainMVP {
    interface  Model {
        List<TaskItem> getTasks();

        void saveTask(TaskItem task);

        void updateTask(TaskItem item);

        void deleteTask(TaskItem task);
    }
    interface Presenter {
        void addNewTask();
        void loadTask();
        void taskItemClicked(TaskItem item);

        void updateTask(TaskItem task);

        void taskItemLongClicked(TaskItem task);

        void deleteTask(TaskItem task);
    }
    interface  View{
        void showTaskList(List<TaskItem> items);

        String getTaskDescription();

        void addTaskToList(TaskItem task);

        void updateTask(TaskItem item);

        void showConfirmDialog(String message, TaskItem item);

        void showDeleteDialog(String message, TaskItem task);

        void deleteTask(TaskItem task);

        Context getActivity();
    }
}
