package br.com.bank.io;

import java.util.Scanner;

/**
 * Created by rafael on 30/08/17.
 */
public class ApplicationReader {

    private static Scanner reader = new Scanner(System.in);

    public static String readString() {
        return reader.nextLine();
    }

    public static Integer readInteger() {
        return new Integer(reader.nextInt());
    }
}
