package org.examples;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomGenerator {
    public static String randomString;
    private static SecureRandom random = new SecureRandom();
    public static String getRandomString() {
        randomString = new BigInteger(130, random).toString(10);
        return randomString;
    }
}
