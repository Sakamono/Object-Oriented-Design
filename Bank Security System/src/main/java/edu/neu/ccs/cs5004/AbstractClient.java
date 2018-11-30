package edu.neu.ccs.cs5004;

/**
 * Represents the abstract client with common field and behaviours.
 *
 * @author zhangxiaoyu
 */
public abstract class AbstractClient implements IClient {
  protected int idNumber;

  /**
   * Constructor for an abstract client.
   *
   * @param idNumber the client ID number
   */
  public AbstractClient(int idNumber) {
    this.idNumber = idNumber;
  }

  /**
   * Gets the abstract client's Id number.
   *
   * @return the client's Id number
   */
  public int getIdNumber() {
    return idNumber;
  }

  /**
   * Sets the abstract client's Id number.
   *
   * @param idNumber the client's Id number to be set
   */
  public void setIdNumber(int idNumber) {
    this.idNumber = idNumber;
  }

}
