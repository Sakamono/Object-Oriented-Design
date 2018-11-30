package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents a client generator.
 *
 * @author zhangxiaoyu
 */
public class ClientGenerator {
  private int numberOfClients;
  private Map<Integer, BankClient> bankDatabase;
  private Map<Integer, Client> clientDatabase;

  /**
   * Constructor for client generator.
   *
   * @param numberOfClients the number of clients to be generated
   */
  public ClientGenerator(int numberOfClients) {
    this.numberOfClients = numberOfClients;
    this.bankDatabase = new HashMap<>();
    this.clientDatabase = new HashMap<>();
  }

  /**
   * Generates clients.
   */
  public void generateClient() {
    this.mapGenerator();
  }

  /**
   * Helper function to generate bank database and client database.
   */
  private void mapGenerator() {
    for (int i = 0; i < this.numberOfClients; i++) {
      Random random = new Random();
      int clientId = random.nextInt(Integer.MAX_VALUE);
      while (this.clientDatabase.containsKey(clientId)) {
        clientId = random.nextInt(Integer.MAX_VALUE);
      }
      RsaPairGenerator rsaPairGenerator = new RsaPairGenerator();
      RsaPair rsaPair = rsaPairGenerator.generateRsaPair();
      Client client = new Client(clientId, rsaPair);
      BankClient bankClient = BankClient.generateFromClient(client);
      this.clientDatabase.put(clientId, client);
      this.bankDatabase.put(clientId, bankClient);

    }
  }

  /**
   * Getter for the bank database.
   *
   * @return the bank database
   */
  public Map<Integer, BankClient> getBankDatabase() {
    return bankDatabase;
  }

  /**
   * Getter for the client database.
   *
   * @return the client database
   */
  public Map<Integer, Client> getClientDatabase() {
    return clientDatabase;
  }

  @Override
  public String toString() {
    return "ClientGenerator{"
        + "numberOfClients=" + numberOfClients
        + ", bankDatabase=" + bankDatabase
        + ", clientDatabase=" + clientDatabase
        + '}';
  }
}
