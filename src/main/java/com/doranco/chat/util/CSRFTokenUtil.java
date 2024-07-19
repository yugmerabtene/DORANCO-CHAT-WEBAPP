package com.doranco.chat.util;

import java.security.SecureRandom;
import java.util.Base64;

public class CSRFTokenUtil {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static String generateToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public static boolean validateToken(String token, String sessionToken) {
        return token != null && token.equals(sessionToken);
    }
}
