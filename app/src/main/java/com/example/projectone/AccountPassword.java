package com.example.projectone;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AccountPassword implements Parcelable {


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

    protected AccountPassword(Parcel in) {
        id = in.readInt();
        websiteName = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<AccountPassword> CREATOR = new Creator<AccountPassword>() {
        @Override
        public AccountPassword createFromParcel(Parcel in) {
            return new AccountPassword(in);
        }

        @Override
        public AccountPassword[] newArray(int size) {
            return new AccountPassword[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(websiteName);
        parcel.writeString(email);
        parcel.writeString(password);
    }
}
