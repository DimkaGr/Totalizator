package by.gritsuk.dima.util;

import java.util.UUID;

public class StringGenerator {
    public static String generate(){
        String randomString= UUID.randomUUID().toString();
        return randomString;
    }
}
