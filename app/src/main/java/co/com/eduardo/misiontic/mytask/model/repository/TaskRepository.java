package co.com.eduardo.misiontic.mytask.model.repository;

import android.content.Context;

import java.util.List;

import co.com.eduardo.misiontic.mytask.model.database.TaskDatabase;
import co.com.eduardo.misiontic.mytask.model.database.dao.TaskItemDao;
import co.com.eduardo.misiontic.mytask.model.database.entities.TaskItem;

public class TaskRepository {
    private TaskItemDao taskItemDao;

    public TaskRepository(Context context){
        taskItemDao = TaskDatabase.getDatabase(context).getTaskItemDao();
    }

    private void loadInitalDatabase() {
       taskItemDao.insert(
               new TaskItem("To Do","2021-12-08")
       );
    }

    public List<TaskItem> getAllTask()
    {
        return taskItemDao.getAll();
    }

    public void AddTaskItem(TaskItem task)
    {
        taskItemDao.insert(task);
    }

    public void UpdatedTasItem(TaskItem task)
    {
        taskItemDao.update(task);
    }

    public void DeleteTaskItem(TaskItem task)
    {
        taskItemDao.delete(task);
    }
}
