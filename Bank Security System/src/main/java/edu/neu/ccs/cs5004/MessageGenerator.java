package edu.neu.ccs.cs5004;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


/**
 * Represents a message generator.
 *
 * @author zhangxiaoyu
 */
public class MessageGenerator {
  private Map<Integer, Client> clientDatabase;
  private int numberOfVerifications;
  private double invalidPercentage;
  private static final int MAX_MESSAGE = 30001;
  private static final int BASE = 100;

  /**
   * Constructor for message generator.
   *
   * @param clientDatabase        the client database
   * @param numberOfVerifications the number of verifications
   * @param invalidPercentage     the percentage of invalid messages
   */
  public MessageGenerator(Map<Integer, Client> clientDatabase,
                          int numberOfVerifications, double invalidPercentage) {
    this.clientDatabase = clientDatabase;
    this.numberOfVerifications = numberOfVerifications;
    this.invalidPercentage = invalidPercentage;
  }

  /**
   * Generates messages.
   *
   * @return messages map, Key: client id, Value:List of messages
   */
  public Map<Integer, List<Message>> generateMessage() {
    Map<Integer, List<Message>> messagesMap = new HashMap<>();

    //Get all clients ID for later randomly choosing Id
    Set<Integer> idSet = clientDatabase.keySet();
    Integer[] idArray = new Integer[idSet.size()];
    idArray = idSet.toArray(idArray);
    int invalidMessageNumber = (int)(Math.round(numberOfVerifications * invalidPercentage / BASE));
    int invalidCount = 1;

    //Loop to generate each message
    for (int i = 0; i < numberOfVerifications; i++) {
      Random random = new Random();


      //Randomly choose one client Id and get secret Key
      int clientId = idArray[random.nextInt(idArray.length)];
      Client client = clientDatabase.get(clientId);

      //randomly generate messageContent [0,30000]
      int messageContent = random.nextInt(MAX_MESSAGE);
      boolean isValid = true;
      if (invalidCount > invalidMessageNumber) {
        isValid = false;
      }
      //Double randomNumber = random.nextDouble() * BASE;
      //System.out.println(randomNumber);

      //Generate digital signature.
      BigInteger digitalSignature = SignatureGenerator
          .digitalSignatureGenerator(client, messageContent,
              isValid);
      invalidCount++;
      //create message instance
      Message messageData = new Message(messageContent,
          digitalSignature);
      messageData.setClientId(clientId);
      //Map Key: client id, Map Value: List of messages with same IDs.
      // If already contains, update.Else, put a new pair.
      if (messagesMap.containsKey(clientId)) {
        messagesMap.get(clientId).add(messageData);
      } else {
        List<Message> messageList = new ArrayList<>();
        messageList.add(messageData);
        messagesMap.put(clientId, messageList);
      }
    }
    return messagesMap;
  }


  @Override
  public String toString() {
    return "MessageGenerator{"
        + "clientDatabase=" + clientDatabase
        + ", numberOfVerifications=" + numberOfVerifications
        + ", invalidPercentage=" + invalidPercentage
        + '}';
  }


//  public static void main(String[] args) {
//    RsaPairGenerator rsaPairGenerator = new RsaPairGenerator();
//    RsaPair rsaPair = rsaPairGenerator.generateRsaPair();
//    Client client = new Client(1000,rsaPair);
//    BigInteger signature = SignatureGenerator.digitalSignatureGenerator(client,20005,
//        15.0,0.0);
//    System.out.println("Signature: " + signature);
//    BankClient bankClient = BankClient.generateFromClient(client);
//    RsaKey publicKey = bankClient.getPublicKey();
//    System.out.println(client);
//    System.out.println(bankClient);
//    Message message = new Message(20005,signature);
//
//    Boolean b = SignatureVerification.checkIsVerified(bankClient, message);
//    System.out.println(b);
//  }
}

