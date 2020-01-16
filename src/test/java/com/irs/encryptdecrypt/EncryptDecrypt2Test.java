package com.irs.encryptdecrypt;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test unitario para la clase EncryptDecryp2t. El test consiste en encriptar y
 * desencriptar un texto (una password) empleando una contraseña como
 * clave de encriptación.
 *
 * @author IRS
 * @version 1.0.0
 */
public class EncryptDecrypt2Test extends TestCase {
    
    // PASSWORD es la clave empleada para cifrar y descifrar el TEXTO
    private static final String PASSWORD = "com.irs.encryptdecrypt.123456789";
    private static final String TEXTO = "PASSWORD";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EncryptDecrypt2Test(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(EncryptDecrypt2Test.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testEncryptDecrypt() {
        try {
            EncryptDecrypt2 encryptDecrypt2 = new EncryptDecrypt2();

            SecretKey secretKey = encryptDecrypt2.getKey(PASSWORD);

            byte[] encrypt = encryptDecrypt2.encrypt(secretKey, TEXTO.getBytes());

            System.out.println("Texto encriptado Hx [" + EncryptDecrypt2.toHex(encrypt) + "]");
            System.out.println("Texto encriptado b64 [" + DatatypeConverter.printBase64Binary(encrypt) + "]");

            byte[] decrypt = encryptDecrypt2.decrypt(secretKey, encrypt);

            System.out.println("Texto desencriptado [" + new String(decrypt) + "]");

            assertEquals(TEXTO, new String(decrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
