package edu.neu.ccs.cs5004;

/**
 * Represents the client interface.
 *
 * @author zhangxiaoyu
 */
public interface IClient {

  /**
   * Gets the public RsaKey of the client.
   *
   * @return the public RsaKey
   */
  RsaKey getPublicKey();

}
