package com.company.exceptions;

public class WrongPeriodicTypeException extends Exception{
    public WrongPeriodicTypeException(String errorMessage, String wrongData)
    {
        super(errorMessage + "[" + wrongData + "]");
    }
    public WrongPeriodicTypeException(String errorMessage)
    {
        super(errorMessage);
    }
}
