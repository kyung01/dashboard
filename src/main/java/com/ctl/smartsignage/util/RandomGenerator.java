package com.ctl.smartsignage.util;


import java.util.Random;

/**
 * @author Arun Kumar Tiwari
 */
public class RandomGenerator {

    public static String randGenerator(int range) {
        String randString = "";
        StringBuffer sb = new StringBuffer();
        String block = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFIJKLMNOPQRSTUVWXYZ";
        sb.append(block).append(block.toUpperCase()).append("0123456789");
        block = sb.toString();
        sb = new StringBuffer();
        Random random = new Random();
        try {
            for (int i = 0; i < range; i++) {
                sb.append(Character.toString(block.charAt(random.nextInt(block.length() - 1))));
            }
            randString = sb.toString();
        } catch (ArrayIndexOutOfBoundsException e) {
        } catch (NumberFormatException e) {
        } catch (Exception e) {
        }
        return randString;
    }
}