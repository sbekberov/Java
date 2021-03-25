package com.company.exceptions;

public class WrongPriceTypeException extends Exception{
    public WrongPriceTypeException(String errorMessage)
    {
        super(errorMessage);
    }
}
