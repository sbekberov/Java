package com.company.model;

public class PeriodicModel {

    public static String publishingHouse = "No publishing house";
    private double price = 0.0;
    public static String priceStr = "0.0";

    // масив для збереження колекції періодик
    Periodic[] periodicsList = null;

    public PeriodicModel() {
        periodicsList = PeriodicsListFiller.generatePeriodicsListWithInfo();
    }

    // метод для додавання періодики до списку
    Periodic[] addPeriodic(Periodic []arr, Periodic a) {
        int i;

        Periodic[] newArr = new Periodic[arr.length + 1];

        for (i = 0; i < arr.length; i++)
            newArr[i] = arr[i];

        newArr[arr.length] = a;

        return newArr;
    }

    public Periodic[] getPeriodicsList()
    {
        return periodicsList;
    }

    public Boolean IsConvertedPrice()
    {
        try
        {
            price = Double.parseDouble(PeriodicModel.priceStr);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    //  - методи, що реалізовані відповідно до завдання -

    // 1. Отримати список видань для заданого виду
    public Periodic[] getPeriodicsByType(String type)
    {
        Periodic[] foundPeriodics = new Periodic[0];
        for (var item:periodicsList)
        {
            if(item.getType().equals(type))
            {
                foundPeriodics = addPeriodic(foundPeriodics, item);
            }
        }
        return foundPeriodics;
    }

    // 2. Отримати список видань, які виходять кожен тиждень
    public Periodic[] getPeriodicsPostingEveryWeek()
    {
        Periodic[] foundPeriodics = new Periodic[0];
        for (var item:periodicsList)
        {
            if(item.getPeriod().getDays() == 7)
            {
                foundPeriodics = addPeriodic(foundPeriodics, item);
            }
        }
        return foundPeriodics;
    }

    // 3. Отримати список видань вказаного
    // видавництва і ціна яких менше вказаної
    public Periodic[] getPeriodicsByPubHouseHavingBiggerPriceThan()
    {
        Periodic[] foundPeriodics = new Periodic[0];
        for (var item:periodicsList)
        {
            if(item.getPublishingHouse().equals(PeriodicModel.publishingHouse) && item.getPrice() <= price)
            {
                foundPeriodics = addPeriodic(foundPeriodics, item);
            }
        }
        return foundPeriodics;
    }
    }




