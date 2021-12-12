package co.com.eduardo.misiontic.mytask.model.repository;

import android.content.Context;

import co.com.eduardo.misiontic.mytask.model.database.TaskDatabase;
import co.com.eduardo.misiontic.mytask.model.database.dao.UserDao;
import co.com.eduardo.misiontic.mytask.model.database.entities.User;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Context context) {
        userDao = TaskDatabase.getDatabase(context).getUserDao();
    }

    private void loadInitalDatabase() {
        userDao.insert(
                new User("Jaime Eduardo Carvajal", "jeduardocarvajal@gmail.com", "12345678")
         );
    }

    public User getUserByEmail(String email) {
        loadInitalDatabase();
        return userDao.getUserByEmail(email);
    }
}
