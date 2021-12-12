package co.com.eduardo.misiontic.mytask.model;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import co.com.eduardo.misiontic.mytask.model.database.entities.User;
import co.com.eduardo.misiontic.mytask.model.repository.UserRepository;
import co.com.eduardo.misiontic.mytask.mvp.LoginMVP;

public class LoginInteractor implements LoginMVP.Model {

   // private Map<String, String> users;
    private UserRepository userRepository;

    public LoginInteractor(Context context)
    {
        // users = new HashMap<>();
        //users.put("admin@gmail.com", "12345678");
        userRepository = new UserRepository(context);
    }
    @Override
    public void validateCredentials(String email, String password, ValidateCredentialsCallback callback) {
//       try {
//           Thread.sleep(5000);
//       } catch (InterruptedException e)
//       {
//           e.printStackTrace();
//       }
//       if ( users.get(email) == null)
//       {
//           callback.onFailure("User not exist");
//       } else if (!users.get(email).equals(password))
//       {
//           callback.onFailure("Password incorrect");
//       } else {
//           callback.onSuccess();
//       }
        User user = userRepository.getUserByEmail(email);

        if(user == null) {
            callback.onFailure("User not exist");
        } else if (!user.getPassword().equals(password)){
            callback.onFailure("Password incorrect");
        } else {
            callback.onSuccess();
        }
    }
}
