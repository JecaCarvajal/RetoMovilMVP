package co.com.eduardo.misiontic.mytask.presenter;

import java.util.Locale;

import co.com.eduardo.misiontic.mytask.model.LoginInteractor;
import co.com.eduardo.misiontic.mytask.mvp.LoginMVP;
import co.com.eduardo.misiontic.mytask.view.dto.LoginInfo;

public class LoginPresenter implements LoginMVP.Presenter {

    private LoginMVP.View view;
    private LoginMVP.Model model;

     public LoginPresenter(LoginMVP.View view){
         this.view = view;
         this.model = new LoginInteractor(view.getActivity());
     }

    @Override
    public void LoginWithEmail() {

        boolean error = false;

        view.showEmailError("");
        view.showPasswordError("");

        LoginInfo loginInfo = view.getLoginInfo();
        if(loginInfo.getEmail().trim().isEmpty()){
            view.showEmailError("Email is required");
            error = true;
        } else if (!isEmailValid(loginInfo.getEmail().trim())) {
            view.showEmailError("Email not valid");
            error = true;
        }

        if (loginInfo.getPassword().trim().isEmpty()) {
            view.showPasswordError("Password is required");
        } else if (!isPasswordValid(loginInfo.getPassword().trim()))
        {
            view.showPasswordError("Password does not satisfy security criteria");
            error = true;
        }

        if (!error) {
            view.startWaiting();

            new Thread(() -> {
                model.validateCredentials(loginInfo.getEmail().trim(),
                        loginInfo.getPassword().trim(),
                        new LoginMVP.Model.ValidateCredentialsCallback() {
                            @Override
                            public void onSuccess() {
                                view.getActivity().runOnUiThread(() -> {
                                    view.stopWaiting();
                                    view.openMainActivity();
                                });
                            }

                            @Override
                            public void onFailure(String error) {
                                view.getActivity().runOnUiThread(() -> {
                                    view.stopWaiting();
                                    view.showGeneralError(error);
                                });
                            }
                        });
            }).start();
        }

    }

    private boolean isEmailValid(String email) {
         return email.contains("@") && email.endsWith(".com");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}
