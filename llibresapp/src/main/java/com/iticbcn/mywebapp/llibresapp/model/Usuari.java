package com.iticbcn.mywebapp.llibresapp.model;

public class Usuari {

    // private int idUsuari;
    // private String nomUsuari;

    private String usuari;
    private String password;

    public String getUsuari() {
        return usuari;
    }
    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Usuari(String usuari, String password) {
        this.usuari = usuari;
        this.password = password;
    }
    
    public Usuari() {}
}