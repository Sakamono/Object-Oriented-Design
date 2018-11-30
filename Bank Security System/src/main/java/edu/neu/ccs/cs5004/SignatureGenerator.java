package edu.neu.ccs.cs5004;

import java.math.BigInteger;
import java.util.Random;

/**
 * Represents the signature generation process.
 *
 * @author zhangxiaoyu
 */
public class SignatureGenerator {

  /**
   * Generates the digital signature.
   * @param client the client
   * @param messageContent the message content
   * @param isValid the message is deemed valid or not
   * @return the digital signature
   */
  public static BigInteger digitalSignatureGenerator(Client client,
                                                     int messageContent,
                                                     boolean isValid) {
    Random random = new Random();
    BigInteger digitalSignature;
    if (isValid) {
      BigInteger bigIntegerMessage = BigInteger.valueOf(messageContent);
      digitalSignature = bigIntegerMessage.modPow(client.getSecretKey().getPower(),
          client.getSecretKey().getDivisor());
    } else {
      digitalSignature = BigInteger.valueOf(random.nextInt(Integer.MAX_VALUE));
    }
    return digitalSignature;
  }

}
