package edu.neu.ccs.cs5004;

import java.math.BigInteger;

/**
 * Represents the signature verification process.
 *
 * @author zhangxiaoyu
 */
public class SignatureVerification {

  /**
   * Checks if the message is verified.
   * @param bankClient the bank client
   * @param message the message to be checked
   * @return true if the message is verified, and false otherwise
   */
  public static boolean checkIsVerified(BankClient bankClient, Message message) {
    RsaKey publicKey = bankClient.getPublicKey();
    BigInteger messageContent = BigInteger.valueOf(message.getMessageContent());
    BigInteger messageDecryption = message.getDigitalSignature().modPow(publicKey.getPower(),
        publicKey.getDivisor());
    return messageContent.equals(messageDecryption);
  }
}
