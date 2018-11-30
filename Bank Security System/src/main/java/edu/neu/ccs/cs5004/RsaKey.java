package edu.neu.ccs.cs5004;

import java.math.BigInteger;

/**
 * Represents RsaKey : a pair of Large Prime Numbers: power and divisor.
 *
 * @author zhangxiaoyu
 */
public class RsaKey {
  private BigInteger power;
  private BigInteger divisor;

  /**
   * Constructor for a RsaKey.
   *
   * @param power   power number
   * @param divisor divisor number
   */
  public RsaKey(BigInteger power, BigInteger divisor) {
    this.power = power;
    this.divisor = divisor;
  }

  /**
   * Gets the power number of the RsaKey.
   *
   * @return power number.
   */
  public BigInteger getPower() {
    return power;
  }

  /**
   * Gets the divisor number of the RsaKey.
   *
   * @return divisor number
   */
  public BigInteger getDivisor() {
    return divisor;
  }

  @Override
  public String toString() {
    return "RsaKey{"
        + "power=" + power
        + ", divisor=" + divisor
        + '}';
  }

}
