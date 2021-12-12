package co.com.eduardo.misiontic.mytask.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import co.com.eduardo.misiontic.mytask.model.database.dao.TaskItemDao;
import co.com.eduardo.misiontic.mytask.model.database.dao.UserDao;
import co.com.eduardo.misiontic.mytask.model.database.entities.TaskItem;
import co.com.eduardo.misiontic.mytask.model.database.entities.User;

@Database(entities = {User.class, TaskItem.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();
    public abstract TaskItemDao getTaskItemDao();

    private static volatile  TaskDatabase INSTANCE;

    public static TaskDatabase getDatabase(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), TaskDatabase.class, "database-name")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;

    }

}
