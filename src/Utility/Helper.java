package Utility;

import java.util.UUID;

public class Helper {
    public static String generateUniqueCode(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
