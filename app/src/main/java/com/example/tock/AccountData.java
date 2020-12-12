package com.example.tock;

public class AccountData {
    private String accountTitle;
    private String accountDesc;
    private String accountBack;

    public AccountData(String accountTitle, String accountDesc, String accountBack){
        this.accountTitle = accountTitle;
        this.accountDesc = accountDesc;
        this.accountBack = accountBack;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public String getAccountBack() {
        return accountBack;
    }

    public void setAccountBack(String accountBack) {
        this.accountBack = accountBack;
    }
}
