package com.company.controller;

import com.company.entities.Periodic;
import com.company.model.DataValidator;
import com.company.model.PeriodicModel;
import com.company.view.DataScanner;
import com.company.view.PeriodicView;

public class PeriodicController {

    PeriodicModel model;
    PeriodicView view;

    public PeriodicController() {
        model = new PeriodicModel();
        view = new PeriodicView();
        try {
            model.loadData();
        } catch (Exception ex) {
            view.showMessage("An error has occurred while reading data " + ex.getMessage());
        }
    }

    public void execute() {
        do {
            view.showMessage(PeriodicView.MENU_LINE);
            view.showMessage(PeriodicView.MENU);
            view.showRequestToEnterValue(PeriodicView.ENTER_MENU_ITEM_MSG);
            String selector = DataScanner.readString();
            switch (selector) {
                case PeriodicView.CASE1: {
                    String type = PeriodicView.WRONG_TYPE;
                    boolean isGood = false;

                    do {
                        try {
                            view.showRequestToEnterValue(PeriodicView.ENTER_PERIODIC_TYPE_MSG);
                            type = DataScanner.readString();

                            if (DataValidator.isValidPublishingTypeFormat(type)) {
                                isGood = true;
                            }
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                    } while (!isGood);
                    var data= model.getPeriodicsByType(type);
                    view.showListResult(data);
                    if(data.length == 0) break;
                    this.requestToWriteData(data);
                    break;
                }
                case PeriodicView.CASE2: {
                    var data = model.getPeriodicsPostingEveryWeek();
                    view.showListResult(data);
                    if(data.length == 0) break;
                    this.requestToWriteData(data);
                    break;
                }
                case PeriodicView.CASE3: {
                    String publishingHouse = "No publishing house";
                    double price = 0.0;
                    boolean isGood = false;

                    do {
                        try {
                            view.showRequestToEnterValue(PeriodicView.ENTER_PUBLISHING_HOUSE_MSG);
                            publishingHouse = DataScanner.readString();

                            if (DataValidator.isValidPublishingHouseFormat(publishingHouse)) {
                                isGood = true;
                            }
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                    } while (!isGood);
                    isGood = false;
                    do {
                        try {
                            view.showRequestToEnterValue(PeriodicView.ENTER_PERIODIC_PRICE_MSG);
                            price = DataScanner.readDouble();

                            if (DataValidator.isValidPriceType(price)) {
                                isGood = true;
                            }
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                    } while (!isGood);
                    var data = model.getPeriodicsByPubHouseHavingBiggerPriceThan(price, publishingHouse);
                    view.showListResult(data);
                    if(data.length == 0) break;
                    this.requestToWriteData(data);
                    break;
                }
                case PeriodicView.CASE4: {
                    var data = model.getPeriodicsList();
                    view.showPeriodicsList(data);
                    if(data.length == 0) break;
                    this.requestToWriteData(data);
                    break;
                }
                default: {
                    if (selector.equals(PeriodicView.CASE_EXIT) || selector.equals(PeriodicView.CASE_EXIT.toUpperCase())) {
                        view.showMessage(PeriodicView.CLOSING);
                        try {
                            model.writeData(model.getPeriodicsList(), model.filePath);
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                        return;
                    }
                    view.showMessage(PeriodicView.WRONG_MENU_ITEM);
                    break;
                }
            }
        } while (true);
    }
    private void requestToWriteData(Periodic[] data)
    {
        view.showRequestToEnterValue("Do you want to write data to file? [y]\\[n]");
        var answer = DataScanner.readString();
        if(answer.equals("y") || answer.equals("Y"))
        {
            String path;
            do {
                view.showRequestToEnterValue("Enter file name: ");
                path = DataScanner.readString();
            } while (path.isBlank());
            try {
                model.writeData(data, path + ".dat");
            }
            catch (Exception ex)
            {
                view.showMessage(ex.getMessage());
            }
        }
    }
}

