package co.com.eduardo.misiontic.mytask.model.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.eduardo.misiontic.mytask.model.database.entities.TaskItem;

@Dao
public interface TaskItemDao {
    @Query("SELECT * FROM TaskItem")
    List<TaskItem> getAll();

    @Insert
    void insert(TaskItem... taskItems);

    @Delete
    void delete(TaskItem taskItem);

    @Update
    void update(TaskItem taskItem);
}
