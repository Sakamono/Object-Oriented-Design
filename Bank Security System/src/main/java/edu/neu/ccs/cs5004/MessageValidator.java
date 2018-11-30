package edu.neu.ccs.cs5004;

import java.util.List;
import java.util.Map;

/**
 * Represents a message validator, which will fill the message map with
 * isValid and isVerified information.
 *
 * @author zhangxiaoyu
 */
public class MessageValidator {
  private Map<Integer, List<Message>> messagesMap;
  private Map<Integer, BankClient> bankDatabase;
  private static final int BASE_TEN = 10;
  private static final int DEPOSIT_WITHDRAWAL_FLAG = 4;


  /**
   * Constructor for a message validator.
   *
   * @param messagesMap  the messages map
   * @param bankDatabase the bank client database
   */
  public MessageValidator(Map<Integer, List<Message>> messagesMap,
                          Map<Integer, BankClient> bankDatabase) {
    this.messagesMap = messagesMap;
    this.bankDatabase = bankDatabase;
  }


  /**
   * Helper function to check if the message is valid.
   *
   * @param client  the client
   * @param message the message
   * @return true if the message is valid and false otherwise
   */
  private boolean checkIsValid(BankClient client, Message message) {
    int lastDigit = message.getMessageContent() % BASE_TEN;
    int amount = message.getMessageContent() / BASE_TEN;
    if (lastDigit <= DEPOSIT_WITHDRAWAL_FLAG) {
      return amount <= client.getDepositLimit();
    } else {
      return amount <= client.getWithdrawalLimit();
    }
  }

  /**
   * Validates the message map and set isValid and isVerified field for every message.
   */
  public void validate() {
    for (Map.Entry<Integer, List<Message>> messagesOneId : messagesMap.entrySet()) {
      //get bank client
      int clientId = messagesOneId.getKey();
      BankClient bankClient = bankDatabase.get(clientId);

      //loop for each message with this ID
      for (Message messageData : messagesOneId.getValue()) {
        //check if this message is verified
        boolean isVerified = SignatureVerification.checkIsVerified(bankClient, messageData);
        //check if the request amount exceed limitation
        boolean isValid = checkIsValid(bankClient, messageData);
        //set the corresponding fields of message
        messageData.setVerified(isVerified);
        messageData.setValid(isValid);
      }
    }
  }

  /**
   * Getter for the messages map.
   *
   * @return the messages map
   */
  public Map<Integer, List<Message>> getMessagesMap() {
    return messagesMap;
  }

  /**
   * Getter for the bank client database.
   *
   * @return the bank client database
   */
  public Map<Integer, BankClient> getBankDatabase() {
    return bankDatabase;
  }

  @Override
  public String toString() {
    return "MessageValidator{"
        + "messagesMap=" + messagesMap
        + ", bankDatabase=" + bankDatabase
        + '}';
  }
}







