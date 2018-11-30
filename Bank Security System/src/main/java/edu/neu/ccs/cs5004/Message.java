package edu.neu.ccs.cs5004;

import java.math.BigInteger;

/**
 * Represents a message with the message content and a digital signature.
 *
 * @author zhangxiaoyu
 */
public class Message {
  private int messageContent;
  private BigInteger digitalSignature;
  private boolean verifiedStatus;
  private boolean validStatus;
  private int clientId;
  private static final int DEFAULT_ID = 0;

  /**
   * Constructor for message.
   *
   * @param messageContent   messageContent
   * @param digitalSignature digitalSignature
   */
  public Message(int messageContent, BigInteger digitalSignature) {
    this.messageContent = messageContent;
    this.digitalSignature = digitalSignature;
    this.verifiedStatus = false;
    this.validStatus = false;
    this.clientId = DEFAULT_ID;
  }

  /**
   * Getter for message content.
   *
   * @return messageContent
   */
  public int getMessageContent() {
    return messageContent;
  }

  /**
   * Getter for message digitalSignature.
   *
   * @return digitalSignature
   */
  public BigInteger getDigitalSignature() {
    return digitalSignature;
  }


  /**
   * Setter for isValid.
   *
   * @param valid boolean
   */
  public void setValid(boolean valid) {
    validStatus = valid;
  }


  /**
   * Setter for isVerified.
   *
   * @param verified boolean
   */
  public void setVerified(boolean verified) {
    verifiedStatus = verified;
  }

  /**
   * Getter for isVerified.
   *
   * @return true if the message is verified, and false otherwise
   */
  public boolean isVerified() {
    return verifiedStatus;
  }

  /**
   * Getter for isValid.
   *
   * @return true if the message is valid, and false otherwise
   */
  public boolean isValid() {
    return validStatus;
  }

  /**
   * Setter for client Id.
   *
   * @param clientId the client Id.
   */
  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  @Override
  public String toString() {
    return "Message{"
        + "messageContent=" + messageContent
        + ", digitalSignature=" + digitalSignature
        + ", isVerified=" + verifiedStatus
        + ", isValid=" + validStatus
        + ", clientId=" + clientId
        + '}';
  }
}
