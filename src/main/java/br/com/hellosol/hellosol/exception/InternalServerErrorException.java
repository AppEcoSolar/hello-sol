package br.com.hellosol.hellosol.exception;

public class InternalServerErrorException extends RuntimeException{

    public InternalServerErrorException(String message){
        super(message);
    }
}
