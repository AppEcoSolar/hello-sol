package br.com.hellosol.hellosol.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException (String message){
        super(message);
    }
}
