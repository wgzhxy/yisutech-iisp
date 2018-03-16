package com.yisutech.iisp.toolkit.security;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;

public class SecurityUtils {

    private static Logger LOG = LoggerFactory.getLogger(SecurityUtils.class);
    private static final String charsetName = "utf-8";

    /**
     * AES加密算法
     *
     * @param enString 要加密的字符串
     * @param key      私钥： AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes
     * @param iv       初始化向量参数，AES 为16bytes. DES 为8bytes.
     * @return
     */
    public static String encrypt(String enString, String key, String iv) {

        try {
            //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            Key keySpec = new SecretKeySpec(key.getBytes(), "AES");

            // 初始化向量
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            // 实例化加密类，参数为加密方式，要写全
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // 初始化，此方法可以采用三种方式，按服务器要求来添加。
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

            // 加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE,7bit等等
            byte[] b = cipher.doFinal(enString.getBytes(Charset.forName(charsetName)));

            return Base64.encodeBase64String(b);   //Base64、HEX等编解码

        } catch (Throwable e) {
            LOG.error("SecurityUtils_encrypt_error", e);
        }
        return "";
    }

    /**
     * AES解密算法
     *
     * @param enString 要加密的字符串
     * @param key      私钥： AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes
     * @param iv       初始化向量参数，AES 为16bytes. DES 为8bytes.
     * @return
     */
    public static String decrypt(String enString, String key, String iv) {
        try {
            //先用Base64解码
            byte[] bytes = Base64.decodeBase64(enString);

            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            //与加密时不同MODE:Cipher.DECRYPT_MODE
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            byte[] ret = cipher.doFinal(bytes);

            return new String(ret, Charset.forName(charsetName));

        } catch (Throwable e) {
            LOG.error("SecurityUtils_decrypt_error", e);
        }
        return "";
    }

}
