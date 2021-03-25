package com.company.controller;

import com.company.model.PeriodicModel;
import com.company.view.*;

public class PeriodicController {

    //          - поля -

    PeriodicModel model = null;
    PeriodicView view = null;

    //        - конструктор -

    public PeriodicController()
    {
        model = new PeriodicModel();
        view = new PeriodicView();
    }

    //       - методи -

    // метод запуску
    public void execute()
    {
        String menuSelector = PeriodicView.CASE_EXIT_LOW;
        do {
            view.showMessage(PeriodicView.MENU_LINE);
            view.showMessage(PeriodicView.MENU);
            view.showRequestToEnterValue(PeriodicView.ENTER_MENU_ITEM_MSG);
            switch (DataScanner.readString())
            {
                case PeriodicView.CASE1:
                {
                    String type = PeriodicView.WRONG_TYPE;
                    view.showRequestToEnterValue(PeriodicView.ENTER_PERIODIC_TYPE_MSG);
                    type = DataScanner.readString();
                    view.showListResult(model.getPeriodicsByType(type));
                    break;
                }
                case PeriodicView.CASE2:
                {
                    view.showListResult(model.getPeriodicsPostingEveryWeek());
                    break;
                }
                case PeriodicView.CASE3:
                {
                    view.showRequestToEnterValue(PeriodicView.ENTER_PUBLISHING_HOUSE_MSG);
                    PeriodicModel.publishingHouse = DataScanner.readString();
                    view.showRequestToEnterValue(PeriodicView.ENTER_PERIODIC_PRICE_MSG);
                    PeriodicModel.priceStr = DataScanner.readString();

                    if(!model.IsConvertedPrice())
                    {
                        view.showMessage(PeriodicView.WRONG_TYPE);
                        break;
                    }

                    view.showListResult(model.getPeriodicsByPubHouseHavingBiggerPriceThan());
                    break;
                }
                case PeriodicView.CASE4:
                {
                    view.showPeriodicsList(model.getPeriodicsList());
                    break;
                }
                case PeriodicView.CASE_EXIT_LOW: case PeriodicView.CASE_EXIT_HIGH:
            {
                view.showMessage(PeriodicView.CLOSING);
                System.exit(0);
                break;
            }
                default:
                {
                    view.showMessage(PeriodicView.WRONG_MENU_ITEM);
                    break;
                }
            }
        } while(true);
    }

}

