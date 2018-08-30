package com.ctl.smartsignage.util;

// CIPHER / GENERATORS
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

// KEY SPECIFICATIONS
import java.security.spec.KeySpec;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEParameterSpec;

// EXCEPTIONS
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;

/**
 * @author Arun Kumar Tiwari
 */
public class EncryptDecrypt {

    Cipher ecipher;
    Cipher dcipher;

    /**
     * Will intialize pass phrase of the encription process.
     * @param passPhrase
     * @see Will intialize pass phrase of the encription process.
     */
    public void EncryptDecrypt(String passPhrase) {

        // 8-bytes Salt
        byte[] salt = {
            (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03
        };

        // Iteration count
        int iterationCount = 19;

        try {

            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            // Prepare the parameters to the cipthers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

        } catch (InvalidAlgorithmParameterException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (InvalidKeySpecException e) {
            System.out.println("EXCEPTION: InvalidKeySpecException");
        } catch (NoSuchPaddingException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (NoSuchAlgorithmException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (InvalidKeyException e) {
            throw new UtilityError("unable to Encript /Decript");
        }
    }

    /**
     * Takes a single String as an argument and returns an Encrypted version
     * of that String.
     * @param str String to be encrypted
     * @return <code>String</code> Encrypted version of the provided String
     */
    //@SuppressWarnings("restriction")
	public String encrypt(String str) {
    	String strResult=null;
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);

            // Encode bytes to base64 to get a string
            //return new sun.misc.BASE64Encoder().encode(enc);
            strResult = new sun.misc.BASE64Encoder().encode(enc);

        } catch (BadPaddingException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (IllegalBlockSizeException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (UnsupportedEncodingException e) {
            throw new UtilityError("unable to Encript /Decript");
        } /*catch (IOException e) {
        }*/
        return strResult;
    }

    /**
     * Takes a encrypted String as an argument, decrypts and returns the
     * decrypted String.
     * @param str Encrypted String to be decrypted
     * @return <code>String</code> Decrypted version of the provided String
     */
    //@SuppressWarnings("restriction")
	public String decrypt(String str) {

        try {

            // Decode base64 to get bytes
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);

            // Decode using utf-8
            return new String(utf8, "UTF8");

        } catch (BadPaddingException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (IllegalBlockSizeException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (UnsupportedEncodingException e) {
            throw new UtilityError("unable to Encript /Decript");
        } catch (IOException e) {
        }
        return null;
    }
    }
