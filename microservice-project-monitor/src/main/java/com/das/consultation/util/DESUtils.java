//package com.das.consultation.util;
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
//import javax.crypto.spec.IvParameterSpec;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//
///**
// * @Author: LJS
// * @Date: 2022/1/21 13:41
// */
//public class DESUtils {
//    /** 算法名称 */
//    private static final String KEY_ALGORITHM = "DES";
//
//    /** 算法名称/加密模式/填充方式 */
//    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
//
//    /** 8位KEY 默认 */
//    private static final String DEFAULT_KEY = "12345678";
//    /** 8位IV 默认 */
//    private static final String DEFAULT_IV = "1qaz2wsx";
//
//    /**
//     * 生成密钥(base64字符串)
//     */
//    public static String initKey() throws NoSuchAlgorithmException, NoSuchProviderException {
//        // 实例化密钥生成器
//        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
//        String name = kg.getProvider().getName();
//        System.out.println(name);
//        // 生成密钥
//        SecretKey secretKey = kg.generateKey();
//        // 获取二进制密钥编码形式
//        return Base64.encodeBase64String(secretKey.getEncoded());
//    }
//
//    /**
//     * 转换密钥
//     */
//    private static Key toKey(String key) throws Exception {
//        // 实例化Des密钥
//        DESKeySpec dks = new DESKeySpec(Base64.decodeBase64(key));
//        // 实例化密钥工厂
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
//        // 生成密钥
//        return keyFactory.generateSecret(dks);
//    }
//
//    /**
//     * 加密数据
//     *
//     * @param data 待加密数据
//     * @param key  密钥(8位字符的base64)
//     * @param iv   加密向量(8位字符的base64)
//     * @return 加密后的数据
//     */
//    public static String encrypt(String data, String key, String iv) throws Exception {
//        // 还原密钥
//        Key k = toKey(key);
//        // 实例化Cipher对象，它用于完成实际的加密操作
//        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//        IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decodeBase64(iv));
//        // 初始化Cipher对象，设置为加密模式
//        cipher.init(Cipher.ENCRYPT_MODE, k, ivParameterSpec);
//        // 执行加密操作。加密后的结果通常都会用Base64编码进行传输
////        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
//        // 输出Hex
//        return byte2HexString(cipher.doFinal(data.getBytes("UTF-8")));
//    }
//
//    public static String encrypt(String data, String key) throws Exception {
//        String iv = Base64.encodeBase64String(DEFAULT_IV.getBytes(StandardCharsets.UTF_8));
//        return encrypt(data, key, iv);
//    }
//
//    public static String encrypt(String data) throws Exception {
//        String key = Base64.encodeBase64String(DEFAULT_KEY.getBytes(StandardCharsets.UTF_8));
//        String iv = Base64.encodeBase64String(DEFAULT_IV.getBytes(StandardCharsets.UTF_8));
//        return encrypt(data, key, iv);
//    }
//
//    /**
//     * 解密数据
//     *
//     * @param data 待解密数据(base64字符串)
//     * @param key  密钥(8位字符的base64)
//     * @param iv   解密向量(8位字符的base64)
//     * @return 解密后的数据
//     */
//    public static String decrypt(String data, String key, String iv) throws Exception {
//        Key k = toKey(key);
//        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//        IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decodeBase64(iv));
//        // 初始化Cipher对象，设置为解密模式
//        cipher.init(Cipher.DECRYPT_MODE, k, ivParameterSpec);
//        // 执行解密操作（Base64）
////        return new String(cipher.doFinal(Base64.decodeBase64(data)));
//        // 执行解密操作（Hex）
//        return new String(cipher.doFinal(hexString2Byte(data)), "UTF-8");
//    }
//
//    public static String decrypt(String data) throws Exception {
//        String key = Base64.encodeBase64String(DEFAULT_KEY.getBytes(StandardCharsets.UTF_8));
//        String iv = Base64.encodeBase64String(DEFAULT_IV.getBytes(StandardCharsets.UTF_8));
//        return decrypt(data, key, iv);
//    }
//
//    public static String decrypt(String data, String key) throws Exception {
//        String iv = Base64.encodeBase64String(DEFAULT_IV.getBytes(StandardCharsets.UTF_8));
//        return decrypt(data, key, iv);
//    }
//
//
////    public static String byte2HexString(byte[] b) {
////        String a = "";
////        for (int i = 0; i < b.length; i++) {
////            String hex = Integer.toHexString(b[i] & 0xFF);
////            if (hex.length() == 1) {
////                hex = '0' + hex;
////            }
////            a = a + hex;
////        }
////        return a;
////    }
//
//    public static String byte2HexString(byte[] b) {
//        StringBuffer a = new StringBuffer();
//        for (int i = 0; i < b.length; i++) {
//            String hex = Integer.toHexString(b[i] & 0xFF);
//            if (hex.length() == 1) {
//                hex = '0' + hex;
//            }
//            a.append(hex);
//        }
//        return a.toString();
//    }
//
//    public static byte[] hexString2Byte(String hexString) {
//        if (hexString == null || hexString.equals("")) {
//            return null;
//        }
//        hexString = hexString.toUpperCase();
//        int length = hexString.length() / 2;
//        char[] hexChars = hexString.toCharArray();
//        byte[] d = new byte[length];
//        for (int i = 0; i < length; i++) {
//            int pos = i * 2;
//            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
//        }
//        return d;
//    }
//
//    private static byte charToByte(char c) {
//        return (byte) "0123456789ABCDEF".indexOf(c);
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        String source = "{\"authinfo\":{\"serviceId\":\"100001\",\"UserName\":\"\",\"UserPassword\":\"史院乡\",\"HospId\":\"\",\"OperateFlag\":\"1\",\"PrimaryKeyValue\":\"\"},\"datainfo\":{\"jckh\":\"1\",\"yfxm\":\"女方姓名\",\"yfcsrq\":\"\",\"yfsfz\":\"132201199202066219\",\"yfmz\":\"女方民族\",\"czjgmc\":\"史院乡\",\"yflxdh\":\"女方联系电话\",\"yfhjczlx\":\"户籍及常住类型：1户籍常住，2常住非户籍(流入)，4户籍非常住(流出)，9其它\",\"yfhjd\":\"女子户籍地\",\"yfxjddz\":\"女方居住地地址\",\"nzxm\":\"男子姓名\",\"hyrq\":\"2020-01-01\",\"jcsj\":\"\",\"nzcsrq\":\"\"}}";
//        System.out.println("原文: " + source);
////        // 自动生成Key
////        String key = initKey();
//        // 固定Key
//        String ysKey = "EEC8C913";
//        String key = Base64.encodeBase64String(ysKey.getBytes("UTF-8"));
//        System.out.println("密钥: " + key);
//
//        String encryptData = encrypt(source, key, key);
//        System.out.println("加密: " + encryptData);
//
//        String decryptData = decrypt(encryptData, key, key);
//        System.out.println("解密: " + decryptData);
//    }
//}
