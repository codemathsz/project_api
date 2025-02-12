package br.com.codemathsz.stage.exceptions;

public class LoginHandlerException extends RuntimeException {
    public LoginHandlerException() {
        super("E-mail ou senha incorreto.");
    }
}
