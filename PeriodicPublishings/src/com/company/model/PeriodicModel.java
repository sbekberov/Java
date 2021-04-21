package com.company.model;

import com.company.entities.Periodic;
import com.company.serialization.DataSerializer;

import java.io.IOException;

public class PeriodicModel {
    Periodic[] periodicsList = null;
    public final String filePath = "data.dat";
    DataSerializer serializer = null;
    public PeriodicModel() {
        serializer = new DataSerializer();
    }

    private Periodic[] addPeriodic(Periodic []arr, Periodic a) {
        int i;

        Periodic[] newArr = new Periodic[arr.length + 1];

        for (i = 0; i < arr.length; i++)
            newArr[i] = arr[i];

        newArr[arr.length] = a;

        return newArr;
    }

    public void loadData () throws IOException, ClassNotFoundException {
        periodicsList = serializer.readData(filePath);
    }

    public void writeData(Periodic[] data, String path) throws IOException {
        serializer.writeData(data, path);
    }
    public Periodic[] getPeriodicsList()
    {
        return periodicsList;
    }

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

    public Periodic[] getPeriodicsByPubHouseHavingBiggerPriceThan(Double price, String publishingHouse)
    {
        Periodic[] foundPeriodics = new Periodic[0];
        for (var item:periodicsList)
        {
            if(item.getPublishingHouse().equals(publishingHouse) && item.getPrice() <= price)
            {
                foundPeriodics = addPeriodic(foundPeriodics, item);
            }
        }
        return foundPeriodics;
    }
    }




