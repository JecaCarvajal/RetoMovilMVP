package co.com.eduardo.misiontic.mytask.mvp;

import android.app.Activity;

import co.com.eduardo.misiontic.mytask.view.dto.LoginInfo;

public interface LoginMVP {
    interface Model {
        void validateCredentials(String email, String password, ValidateCredentialsCallback  callbacl);

        interface ValidateCredentialsCallback {
            void onSuccess();

            void onFailure(String error);
        }

    }

    interface Presenter {
        void LoginWithEmail();
    }
    interface View {
        Activity getActivity();

        LoginInfo getLoginInfo();

        void showEmailError(String error);
        void showPasswordError(String error);
        void showGeneralError(String error);

        void clearData();

        void openMainActivity();

        void startWaiting();

        void stopWaiting();

    }

}
