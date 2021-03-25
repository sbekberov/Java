package com.company.exceptions;

public class WrongPublishingHouseFormatException extends Exception{
    public WrongPublishingHouseFormatException(String errorMessage, String wrongData)
    {
        super(errorMessage + "[" + wrongData + "]");
    }
    public WrongPublishingHouseFormatException(String errorMessage)
    {
        super(errorMessage);
    }
}
