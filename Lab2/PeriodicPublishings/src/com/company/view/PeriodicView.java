package com.company.view;


import com.company.model.Periodic;

public class PeriodicView {

    public final static String WRONG_MENU_ITEM = "Wrong menu item!";
    public final static String CLOSING = "Closing...";

    public final static String CASE1 = "1";
    public final static String CASE2 = "2";
    public final static String CASE3 = "3";
    public final static String CASE4 = "4";
    public final static String CASE_EXIT = "e";

    public final static String MENU =
            "[" + PeriodicView.CASE1 + "] - Task 1\n" +
                    "[" + PeriodicView.CASE2 + "] - Task 2\n" +
                    "[" + PeriodicView.CASE3 + "] - Task 3\n" +
                    "[" + PeriodicView.CASE4 + "] - Show all periodics\n" +
                    "[" + PeriodicView.CASE_EXIT + "]xit";

    public final static String FOUND = "\t - Found item(s) -";
    public final static String NOTHING_FOUND = "Nothing was found /:";
    public final static String WRONG_TYPE = "Wrong type!";

    public final static String ENTER_PUBLISHING_HOUSE_MSG = "Enter publishing house to find: ";
    public final static String ENTER_PERIODIC_PRICE_MSG = "Enter price of periodic to find: ";
    public final static String ENTER_PERIODIC_TYPE_MSG = "Enter periodic type to find: ";
    public final static String ENTER_MENU_ITEM_MSG = "Enter menu item: ";
    public final static String MENU_LINE = "+---------------------------+";


    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showListResult(Periodic[] periodics) {
        if (periodics.length == 0) {
            showMessage(NOTHING_FOUND);
            return;
        }
        showMessage(FOUND);
        showPeriodicsList(periodics);
    }

    public void showRequestToEnterValue(String request) {
        System.out.print(request);
    }

    public void showPeriodic(Periodic periodic) {
        System.out.println(periodic.toString());
    }

    public void showPeriodicsList(Periodic[] periodics) {
        String lineStr = "+----------------------------------------------------------------------------------------------------------+\n";
        String titleStr = String.format("%15s%13s%19s%13s%23s%22s%n", "Title", "Type", "Period", "Price", "Publishing House", "Publisher Full Name");
        String periodicsStr = "";

        for (var item : periodics) {
            periodicsStr += String.format("%15s%15s%15s%15s%20s%20s%n", item.getTitle(), item.getType(), item.getPeriod()
                    , item.getPrice(), item.getPublishingHouse(), item.getFullName());
        }

        showMessage(lineStr + titleStr + lineStr + periodicsStr + lineStr);
    }
}
