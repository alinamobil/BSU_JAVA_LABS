package com.exception;

public class AccessoryLogicException extends Exception { //исключения для класса Аксесуары наследуется от класса Exception
    public AccessoryLogicException() {}

    public AccessoryLogicException(String message, Throwable exception) {
        super(message,exception);
    }

    public AccessoryLogicException(Throwable exception) {
        super(exception);
    }

    public AccessoryLogicException(String message) {
        super(message);
    }
}
