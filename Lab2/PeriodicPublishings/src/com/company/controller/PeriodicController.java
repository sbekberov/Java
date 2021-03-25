package com.company.controller;

import com.company.exceptions.WrongPeriodicTypeException;
import com.company.exceptions.WrongPriceTypeException;
import com.company.exceptions.WrongPublishingHouseFormatException;
import com.company.model.DataValidator;
import com.company.model.PeriodicModel;
import com.company.view.*;

public class PeriodicController {

    PeriodicModel model = null;
    PeriodicView view = null;

    public PeriodicController() {
        model = new PeriodicModel();
        view = new PeriodicView();
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
                    Boolean isGood = false;

                    do {
                        try {
                            view.showRequestToEnterValue(PeriodicView.ENTER_PERIODIC_TYPE_MSG);
                            type = DataScanner.readString();

                            if (DataValidator.isValidPublishingTypeFormat(type)) {
                                isGood = true;
                            }
                        } catch (WrongPeriodicTypeException ex) {
                            view.showMessage(ex.getMessage());
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                    } while (!isGood);
                    view.showListResult(model.getPeriodicsByType(type));
                    break;
                }
                case PeriodicView.CASE2: {
                    view.showListResult(model.getPeriodicsPostingEveryWeek());
                    break;
                }
                case PeriodicView.CASE3: {
                    String publishingHouse = "No publishing house";
                    double price = 0.0;
                    Boolean isGood = false;

                    do {
                        try {
                            view.showRequestToEnterValue(PeriodicView.ENTER_PUBLISHING_HOUSE_MSG);
                            publishingHouse = DataScanner.readString();

                            if (DataValidator.isValidPublishingHouseFormat(publishingHouse)) {
                                isGood = true;
                            }
                        } catch (WrongPublishingHouseFormatException ex) {
                            view.showMessage(ex.getMessage());
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                    } while (!isGood);
                    isGood = false;
                    do {
                        try {
                            view.showRequestToEnterValue(PeriodicView.ENTER_PERIODIC_PRICE_MSG);
                            price = DataScanner.readDouble();

                            if (DataValidator.isValidPriceType(price) == true) {
                                isGood = true;
                            }
                        } catch (WrongPriceTypeException ex) {
                            view.showMessage(ex.getMessage());
                        } catch (Exception ex) {
                            view.showMessage(ex.getMessage());
                        }
                    } while (!isGood);

                    view.showListResult(model.getPeriodicsByPubHouseHavingBiggerPriceThan(price, publishingHouse));
                    break;
                }
                case PeriodicView.CASE4: {
                    view.showPeriodicsList(model.getPeriodicsList());
                    break;
                }
                default: {
                    if (selector.equals(PeriodicView.CASE_EXIT) || selector.equals(PeriodicView.CASE_EXIT.toUpperCase())) {
                        view.showMessage(PeriodicView.CLOSING);
                        return;
                    }
                    view.showMessage(PeriodicView.WRONG_MENU_ITEM);
                    break;
                }
            }
        } while (true);
    }

}

