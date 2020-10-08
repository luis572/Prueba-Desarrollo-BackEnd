package com.prueba.springboot.app.util;

import com.prueba.springboot.app.models.Cliente;

public class Token {

    private String accessToken;

    private Cliente cliente;

    public Token(String accessToken) {
        this.accessToken = accessToken;
    }

    public Token(String accessToken, Cliente cliente) {
        this.accessToken = accessToken;
        this.cliente = cliente;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String access_token) {
        this.accessToken = access_token;
    }

    public Cliente getUser() {
        return cliente;
    }

    public void setUser(Cliente cliente) {
        this.cliente = cliente;
    }
}
