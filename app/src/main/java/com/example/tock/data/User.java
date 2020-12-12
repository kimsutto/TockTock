package com.example.tock.data;

import java.util.Date;

public class User {
    private int user_id;
    private String name;
    private int account;
    private int fin_account;
    private int card;
    private int fin_card;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getFin_account() {
        return fin_account;
    }

    public void setFin_account(int fin_account) {
        this.fin_account = fin_account;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getFin_card() {
        return fin_card;
    }

    public void setFin_card(int fin_card) {
        this.fin_card = fin_card;
    }
}

