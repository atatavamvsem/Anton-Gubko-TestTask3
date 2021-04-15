package org.examples;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomGenerator {
    public static String randomString;
    public static int randomInt;
    public static double valueForCompare;
    private static SecureRandom random = new SecureRandom();
    public static String getRandomString() {
        randomString = new BigInteger(130, random).toString(10);
        return randomString;
    }

    public static int getRandomInt() {
        randomInt = new BigInteger(3, random).intValue();
        createValueForCompare(randomInt);
        return randomInt;
    }

    private static void createValueForCompare(int randomInt) {
        valueForCompare = ((double) randomInt)/2;
        System.out.println(valueForCompare);
    }
}
