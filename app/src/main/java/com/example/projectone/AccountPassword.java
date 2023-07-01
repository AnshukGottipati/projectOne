package com.example.projectone;

public class AccountPassword {


    private int id;
    private String websiteName;
    private String email;
    private String password;

    public AccountPassword(int id, String websiteName, String email, String password) {
        this.id = id;
        this.websiteName = websiteName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountPassword{" +
                "id=" + id +
                ", websiteName='" + websiteName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
