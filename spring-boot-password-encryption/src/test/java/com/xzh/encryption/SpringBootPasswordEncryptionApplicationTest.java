package com.xzh.encryption;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import sun.security.rsa.RSAKeyPairGenerator;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xiezhaohui
 * @date 2022/1/6
 */
class SpringBootPasswordEncryptionApplicationTest {

    @Test
    void login() throws Exception {
        String password = "123456";
        RSAKeyPairGenerator.Legacy legacy = new RSAKeyPairGenerator.Legacy();
        legacy.initialize(1024,new SecureRandom());
        KeyPair keyPair = legacy.generateKeyPair();
        // String publicKeyString = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        System.out.println("私钥：" + privateKey);
        System.out.println("公钥：" + publicKey);
        System.out.println("密码：" + password);
        String encrypt = encrypt(password, publicKey);
        System.out.println("密码公钥加密：" + encrypt);
        System.out.println("对加密后对数据解密：" + decrypt(encrypt,privateKey));
    }

    @Test
    void hutoolLogin(){
        //
        RSA rsa = SecureUtil.rsa();
        System.out.println(rsa.getPublicKeyBase64());
        System.out.println(rsa.getPrivateKeyBase64());
        String encrypt = rsa.encryptBase64("123456", KeyType.PublicKey);
        System.out.println(rsa.decryptStr(encrypt, KeyType.PrivateKey));
    }


    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}