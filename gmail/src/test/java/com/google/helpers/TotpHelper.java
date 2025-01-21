package com.google.helpers;

import java.util.concurrent.TimeUnit;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.CodeGenerationException;

public class TotpHelper {
    public static String generateTOTP(String secret) {
        var timeStep = TimeUnit.SECONDS.toMillis(30);
        var currentTimeMillis = System.currentTimeMillis();
        var counter = currentTimeMillis / timeStep;

        var codeGenerator = new DefaultCodeGenerator(HashingAlgorithm.SHA1, 6);
        try {
            var otp = codeGenerator.generate(secret, counter);
            return otp;
        } catch (CodeGenerationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
