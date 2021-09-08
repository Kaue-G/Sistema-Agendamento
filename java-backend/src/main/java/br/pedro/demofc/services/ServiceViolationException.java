package br.pedro.demofc.services;

public class ServiceViolationException extends RuntimeException{
    public ServiceViolationException(String msg){
        super(msg);
    }
}
