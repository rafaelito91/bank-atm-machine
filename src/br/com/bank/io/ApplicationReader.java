package br.com.bank.io;

import java.util.Scanner;

/**
 * Created by rafael on 30/08/17.
 */
public class ApplicationReader {

    public static String readString() {
        return getReader().nextLine();
    }

    public static Integer readInteger() {
        return new Integer(getReader().nextInt());
    }

    private static Scanner getReader() {
        return new Scanner(System.in);
    }
}
