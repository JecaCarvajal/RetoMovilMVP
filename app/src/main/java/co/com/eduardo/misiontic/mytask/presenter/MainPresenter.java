package co.com.eduardo.misiontic.mytask.presenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.com.eduardo.misiontic.mytask.model.MainInteractor;
import co.com.eduardo.misiontic.mytask.model.database.entities.TaskItem;
import co.com.eduardo.misiontic.mytask.mvp.MainMVP;

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private MainMVP.Model model;

    public MainPresenter(MainMVP.View view) {
       this.view = view;
       this.model = new MainInteractor(view.getActivity());
    }
    @Override
    public void addNewTask() {
        String description = view.getTaskDescription();
        String date = SimpleDateFormat.getDateTimeInstance().format(new Date());
        TaskItem task = new TaskItem(description, date);

        model.saveTask(task);
        view.addTaskToList(task);
    }

    @Override
    public void loadTask() {
        List<TaskItem> items = model.getTasks();

        view.showTaskList(items);
    }

    @Override
    public void taskItemClicked(TaskItem task) {
        String message = task.getState() == "PENDING"
                ? "Desea marcar como terminada esta tarea?"
                : "Desea marcar como pendiente esta tarea?";
        view.showConfirmDialog(message, task);
    }

    @Override
    public void updateTask(TaskItem task) {
        task.setState(task.getState() == "PENDING" ? "DONE" : "PENDING");

        model.updateTask(task);
        view.updateTask(task);
    }

    @Override
    public void taskItemLongClicked(TaskItem task) {
        if(task.getState() == "PENDING") {
            view.showDeleteDialog("Desea Eliminar la tarea", task);
        }
    }

    @Override
    public void deleteTask(TaskItem task) {
            model.deleteTask(task);
            view.deleteTask(task);
    }
}
