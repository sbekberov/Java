package com.company.model;

import com.company.exceptions.WrongPeriodicTypeException;
import com.company.exceptions.WrongPriceTypeException;
import com.company.exceptions.WrongPublishingHouseFormatException;

public class DataValidator {

    public static Boolean isValidPublishingHouseFormat(String publishingHouse) throws WrongPublishingHouseFormatException
    {
        if(publishingHouse.isBlank())
            throw new WrongPublishingHouseFormatException("Назва видавництва не може бути пустою!");
        if(publishingHouse.matches(".*\\d.*"))
            throw new WrongPublishingHouseFormatException("Назва видавництва не може містити цифри!", publishingHouse);
        return true;
    }

    public static Boolean isValidPriceType(double price) throws WrongPriceTypeException {
        if(price < 0)
            throw new WrongPriceTypeException("Ціна товару не може бути від'ємною!");
        return true;
    }

    public static Boolean isValidPublishingTypeFormat(String type) throws WrongPeriodicTypeException
    {
        if(type.isBlank())
            throw new WrongPeriodicTypeException("Тип видавництва не може бути пустим!");
        if(type.matches(".*\\d.*"))
            throw new WrongPeriodicTypeException("Тип видавництва не може містити цифри!", type);
        return true;
    }
}
