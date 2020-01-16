package com.irs.encryptdecrypt;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test unitario para la clase EncryptDecryptWithAES. 
 * El test consiste en encriptar y desencriptar un texto empleando una clave de 
 * encriptación Advanced Encryption Standard (AES)
 *
 * @author IRS
 * @version 1.0.0
 */
public class EncryptDecryptWithAESTest extends TestCase {

    // 32 bytes
    private static final String CLAVE = "com.irs.encryptdecrypt.123456789";
    private static final String TEXTO = "PASSWORD";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EncryptDecryptWithAESTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(EncryptDecryptWithAESTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testEncryptDecrypt() {
        try {
            EncryptDecryptWithAES aes = new EncryptDecryptWithAES();

            SecretKey secretKey = aes.getKey(CLAVE);

            byte[] encrypt = aes.encrypt(secretKey, TEXTO.getBytes("UTF-8"));

            System.out.println("Texto encriptado Hx [" + EncryptDecrypt.toHex(encrypt) + "]");
            System.out.println("Texto encriptado b64 [" + DatatypeConverter.printBase64Binary(encrypt) + "]");

            byte[] decrypt = aes.decrypt(secretKey, encrypt);

            System.out.println("Texto desencriptado [" + new String(decrypt, "UTF-8") + "]");

            assertEquals(TEXTO, new String(decrypt, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
