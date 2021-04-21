
package com.company.model;

import com.company.entities.Periodic;

import java.time.Period;

public class PeriodicsListFiller {
    // метод для генерації та заповнення списку періодиками
    public static Periodic[] generatePeriodicsListWithInfo() {
        Periodic[] periodicsList = new Periodic[0];
        //          - 1 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Days", "Newspaper", Period.of(0, 0, 2),
                130.50, "Ukrainian PH", "Zhukov K.F."));
        //          - 2 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Best car", "Journal", Period.of(0, 0, 7),
                150.99, "Ukrainian PH", "Popov M.R."));
        //          - 3 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Weather", "Newspaper", Period.of(0, 0, 1),
                40.99, "Lviv PH", "Borisov O.S."));
        //          - 4 -
        periodicsList = addPeriodic(periodicsList, new Periodic("All about you", "Newspaper", Period.of(0, 1, 0),
                340.10, "Personal PH", "Konovalev M.C."));
        //          - 5 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Love", "Journal", Period.of(0, 0, 7),
                130.90, "Valentines PH", "Lesiv B.O."));
        //          - 6 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Sport", "Journal", Period.of(0, 0, 7),
                150.99, "Ukrainian PH", "Popov M.R."));
        //          - 7 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Dodge", "Journal", Period.of(0, 0, 15),
                203.99, "Odessa PH", "Ford B.E."));
        //          - 8 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Tiger", "Journal", Period.of(0, 0, 3),
                450.00, "Ukrainian PH", "Borisov L.S."));
        //          - 9 -
        periodicsList = addPeriodic(periodicsList, new Periodic("PC", "Journal", Period.of(0, 0, 7),
                99.99, "Ukrainian PH", "Bobovich B.N.")
        );
        //          - 10 -
        periodicsList = addPeriodic(periodicsList, new Periodic("Windows", "Journal", Period.of(0, 1, 0),
                1010.10, "Berlin PH", "Lewicki A.S.")
        );

        return periodicsList;
    }

    private static Periodic[] addPeriodic(Periodic arr[], Periodic a) {
        int i;

        Periodic newarr[] = new Periodic[arr.length + 1];

        for (i = 0; i < arr.length; i++)
            newarr[i] = arr[i];

        newarr[arr.length] = a;

        return newarr;
    }
}

