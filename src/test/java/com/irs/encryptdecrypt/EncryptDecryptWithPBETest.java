package com.irs.encryptdecrypt;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test unitario para la clase EncryptDecryptWithPBE. 
 * El test consiste en encriptar y desencriptar un texto empleando una clave de 
 * encriptación Password-Based Encryption (PBE).
 *
 * @author IRS
 * @version 1.0.0
 */
public class EncryptDecryptWithPBETest extends TestCase {

    // 32 bytes
    private static final String CLAVE = "com.irs.encryptdecrypt.123456789";
    private static final String TEXTO = "PASSWORD";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EncryptDecryptWithPBETest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(EncryptDecryptWithPBETest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testEncryptDecrypt() {
        try {
            EncryptDecryptWithPBE pbe = new EncryptDecryptWithPBE();

            SecretKey secretKey = pbe.getKey(CLAVE);

            byte[] encrypt = pbe.encrypt(secretKey, TEXTO.getBytes("UTF-8"));

            System.out.println("Texto encriptado Hx [" + EncryptDecrypt.toHex(encrypt) + "]");
            System.out.println("Texto encriptado b64 [" + DatatypeConverter.printBase64Binary(encrypt) + "]");

            byte[] decrypt = pbe.decrypt(secretKey, encrypt);

            System.out.println("Texto desencriptado [" + new String(decrypt, "UTF-8") + "]");

            assertEquals(TEXTO, new String(decrypt, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
