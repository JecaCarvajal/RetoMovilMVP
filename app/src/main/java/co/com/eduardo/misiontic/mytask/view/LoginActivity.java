package co.com.eduardo.misiontic.mytask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import co.com.eduardo.misiontic.mytask.R;
import co.com.eduardo.misiontic.mytask.mvp.LoginMVP;
import co.com.eduardo.misiontic.mytask.presenter.LoginPresenter;
import co.com.eduardo.misiontic.mytask.view.dto.LoginInfo;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {
    private LinearProgressIndicator piWaiting;
    private ImageView ivLogo;
    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etPassword;

    AppCompatButton btnLogin;

    private LoginMVP.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(LoginActivity.this);
        initUI();


    }
    private void initUI() {

        piWaiting = findViewById(R.id.pi_waiting);

        ivLogo = findViewById(R.id.iv_logo);

        tilEmail = findViewById(R.id.til_email);
        etEmail = findViewById(R.id.et_email);

        tilPassword = findViewById(R.id.til_password);
        etPassword = findViewById(R.id.et_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(evt -> presenter.LoginWithEmail());
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public LoginInfo getLoginInfo() {
        return new LoginInfo(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showEmailError(String error) {
       tilEmail.setError(error);
    }

    @Override
    public void showPasswordError(String error) {
       tilEmail.setError(error);
    }

    @Override
    public void showGeneralError(String error) {
       Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearData() {
        tilEmail.setError("");
        etEmail.setText("");
        tilPassword.setError("");
        etPassword.setText("");
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        clearData();
    }

    @Override
    public void startWaiting() {
        piWaiting.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopWaiting() {
        piWaiting.setVisibility(View.GONE);
    }
}