package org.elac.utils;

import java.util.Random;

/**
 * <p>
 *
 * @description: </p>
 * @author: David
 * @create: 2024-04-13 21:10
 */
public class RandomUtil {

    public static Integer genRandom(int bit) {
        //parameter verification
        if (bit <= 0) {
            return 0;
        }
        String source = "1234567890";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        // first bit could be 123456789
        randomString.append(source.charAt(random.nextInt(9)));
        if (bit > 1) {
            for (int i = 0; i < bit - 1; i++) {
                // other bit could be 1234567890
                randomString.append(source.charAt(random.nextInt(10)));
            }
        }
        return Integer.parseInt(String.valueOf(randomString));
    }

}