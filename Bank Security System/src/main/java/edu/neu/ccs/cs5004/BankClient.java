package edu.neu.ccs.cs5004;

import java.util.Random;

/**
 * Represents a bank client, with only public key as field.
 *
 * @author zhangxiaoyu
 */
public class BankClient extends AbstractClient {
  private RsaKey publicKey;
  private int depositLimit;
  private int withdrawalLimit;
  private static final int MAX_DEPOSIT_LIMIT = 2001;
  private static final int MAX_WITHDRAWAL_LIMIT = 3001;

  /**
   * Constructor for a bank client.
   *
   * @param idNumber  the client's ID number
   * @param publicKey the client's public key
   */
  public BankClient(int idNumber, RsaKey publicKey) {
    super(idNumber);
    this.publicKey = publicKey;
    Random random = new Random();
    this.depositLimit = random.nextInt(MAX_DEPOSIT_LIMIT);
    this.withdrawalLimit = random.nextInt(MAX_WITHDRAWAL_LIMIT);
  }

  /**
   * Creates a bank client form a client.
   *
   * @param client the client
   * @return the bank client
   */
  public static BankClient generateFromClient(Client client) {
    return new BankClient(client.getIdNumber(), client.getPublicKey());
  }


  @Override
  public RsaKey getPublicKey() {
    return publicKey;
  }

  /**
   * Getter for deposit limit.
   *
   * @return the deposit limit
   */
  public int getDepositLimit() {
    return depositLimit;
  }

  /**
   * Getter for withdrawal limit.
   *
   * @return the withdrawal limit
   */
  public int getWithdrawalLimit() {
    return withdrawalLimit;
  }


  @Override
  public String toString() {
    return "BankClient{"
        + "publicKey=" + publicKey
        + ", depositLimit=" + depositLimit
        + ", withdrawalLimit=" + withdrawalLimit
        + ", idNumber=" + idNumber
        + '}';
  }

}
