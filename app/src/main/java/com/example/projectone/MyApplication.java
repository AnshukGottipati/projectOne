package com.example.projectone;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static List<AccountPassword> ap = new ArrayList<AccountPassword>();
    private static int nextId = 1;

    public MyApplication() {
        fillAccount();
    }

    private void fillAccount() {
        AccountPassword a0 = new AccountPassword(0,"Enter Website","Enter Email","Enter Password");
        ap.add(a0);
    }

    public static List<AccountPassword> getApList() {
        return ap;
    }

    public static void setApList(List<AccountPassword> apList) {
        MyApplication.ap = apList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
