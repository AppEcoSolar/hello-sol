package br.com.hellosol.hellosol.exception;

public class JWTVerificationException extends RuntimeException{

    public JWTVerificationException(String message){
        super(message);
    }
}
