package standard.common.util.security;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;


public class SecurityAES256 {

  private static volatile SecurityAES256 INSTANCE;

  //암호화에 사용할 비밀키를 입력한다.
  final static String secretKey = "etnersplatformgewsdhjdekhrihh()2"; //32bit
  static String IV = secretKey.substring(0, 16);

  public static SecurityAES256 getInstance() {
    if (INSTANCE == null) {
      synchronized (SecurityAES256.class) {
          if (INSTANCE == null) {
              INSTANCE = new SecurityAES256();
          }
      }
    }
    return INSTANCE;
  }

  //암호화
  public static String AES_Encode(String str)
      throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    byte[] keyData = secretKey.getBytes();

    SecretKey secureKey = new SecretKeySpec(keyData, "AES");

    Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
    c.init(Cipher.ENCRYPT_MODE, secureKey,
        new IvParameterSpec(IV.getBytes(Charset.forName("UTF-8"))));

    byte[] encrypted = c.doFinal(str.getBytes(StandardCharsets.UTF_8));

    String enStr = new String(Base64.encodeBase64(encrypted,true));

    return enStr;
  }

  //복호화
  public static String AES_Decode(String str)
      throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    byte[] keyData = secretKey.getBytes();
    SecretKey secureKey = new SecretKeySpec(keyData, "AES");
    Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
    c.init(Cipher.DECRYPT_MODE, secureKey,
        new IvParameterSpec(IV.getBytes(Charset.forName("UTF-8"))));

    byte[] byteStr = Base64.decodeBase64(Arrays.toString(str.getBytes()));

    return new String(c.doFinal(byteStr), StandardCharsets.UTF_8);
  }
}

