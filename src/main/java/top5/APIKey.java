package top5;

import java.math.BigInteger;
import java.security.*;

import java.util.Date;


public class APIKey {


    public static void main(String[] args) throws NoSuchAlgorithmException {
        Date date = new Date();
        String dateString = date.toString();
        APIKey apiKey = new APIKey();
        String clientKey = apiKey.getMD5(dateString);
        System.out.println("Your API key is : " + clientKey);
    }


    public static String getMD5(String input) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
