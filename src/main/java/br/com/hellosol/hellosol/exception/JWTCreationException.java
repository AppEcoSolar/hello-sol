package br.com.hellosol.hellosol.exception;

public class JWTCreationException extends RuntimeException{

    public JWTCreationException(String message){
        super(message);
    }
}
