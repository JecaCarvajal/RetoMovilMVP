package co.com.eduardo.misiontic.mytask.view.dto;

public class LoginInfo {
    private String email;
    private String password;

    public LoginInfo(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return  email;
    }

    public String getPassword()
    {
        return  password;
    }
}
