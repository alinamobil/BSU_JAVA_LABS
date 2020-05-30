package com.exception;

public class FlowerLogicException extends Exception {//исключения для класса Цветы наследуется от класса Exception
    public FlowerLogicException() { }

    public FlowerLogicException(String message, Throwable exception) {
        super(message, exception);
    }

    public FlowerLogicException(String message) {
        super(message);
    }

    public FlowerLogicException(Throwable exception) {
        super(exception);
    }

}
