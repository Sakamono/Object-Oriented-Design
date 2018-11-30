package edu.neu.ccs.cs5004;


/**
 * Represents RsaPair: a public key and a secret key.
 *
 * @author zhangxiaoyu
 */
public class RsaPair {
  private RsaKey publicKey;
  private RsaKey secretKey;

  /**
   * Constructor for a RsaPair.
   *
   * @param publicKey the public key
   * @param secretKey the secret key
   */
  public RsaPair(RsaKey publicKey, RsaKey secretKey) {
    this.publicKey = publicKey;
    this.secretKey = secretKey;
  }


  /**
   * Getter for the public key.
   *
   * @return public key
   */
  public RsaKey getPublicKey() {
    return publicKey;
  }

  /**
   * Getter for the secret key.
   *
   * @return secret key
   */
  public RsaKey getSecretKey() {
    return secretKey;
  }

  @Override
  public String toString() {
    return "RsaPair{"
        + "publicKey=" + publicKey
        + ", secretKey=" + secretKey
        + '}';
  }
}
