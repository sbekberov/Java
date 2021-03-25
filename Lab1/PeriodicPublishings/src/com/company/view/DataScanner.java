package com.company.view;
import java.util.Scanner;

public class DataScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString()
    {
        return scanner.nextLine();
    }
}
