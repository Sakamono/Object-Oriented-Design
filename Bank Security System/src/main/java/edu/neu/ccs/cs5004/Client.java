package edu.neu.ccs.cs5004;


/**
 * Represents a client, with both public key and secure key as field.
 *
 * @author zhangxiaoyu
 */
public class Client extends AbstractClient {
  private RsaPair rsaPairs;

  public Client(int idNumber, RsaPair rsaPairs) {
    super(idNumber);
    this.rsaPairs = rsaPairs;
  }

  @Override
  public RsaKey getPublicKey() {
    return this.rsaPairs.getPublicKey();
  }

  /**
   * Getter for secret key.
   *
   * @return the secret key
   */
  public RsaKey getSecretKey() {
    return this.rsaPairs.getSecretKey();
  }


  @Override
  public String toString() {
    return "Client{"
        + "rsaPairs=" + rsaPairs
        + ", idNumber=" + idNumber
        + '}';
  }

}
