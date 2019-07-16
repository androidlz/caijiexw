package com.seventeenok.caijie.util;

import java.util.Random;

/**
 * Created by ShiQing on 2018/3/7 0007 10:08
 * Desc:
 */

public class RandomText {
    /**
     * 获取随机字符
     *
     * @param length
     *            字符长度，为-1时，随机长度
     * @return 随机字符
     */
    public static String initRandomText(int length) {
        StringBuffer randomText = new StringBuffer();
        String allChat = "123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        if (length == -1) {
            length = random.nextInt(9) + 1;
        }
        for (int i = 0; i < length; i++) {
            randomText.append(allChat.charAt(random.nextInt(allChat.length())));
        }
        return randomText.toString();
    }
}
