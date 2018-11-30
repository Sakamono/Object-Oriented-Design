package edu.neu.ccs.cs5004;


import java.math.BigInteger;
import java.util.Random;

/**
 * Represents a Rsa Pair Generator.
 *
 * @author zhangxiaoyu
 */
public class RsaPairGenerator {
  private BigInteger primeP;
  private BigInteger primeQ;
  private static final int BIT_LENGTH = 50;

  /**
   * Constructor for RsaPairGenerator.
   */
  public RsaPairGenerator() {
    Random random = new Random();
    this.primeP = BigInteger.probablePrime(BIT_LENGTH, random);
    this.primeQ = BigInteger.probablePrime(BIT_LENGTH, random);
    while (primeP.equals(primeQ)) {
      this.primeQ = BigInteger.probablePrime(BIT_LENGTH, random);
    }
  }


  /**
   * Generates the power of the two random big prime numbers.
   *
   * @return n = p * q
   */
  private BigInteger generatePower() {
    return this.primeP.multiply(this.primeQ);
  }

  /**
   * Generates the power of the two random big prime numbers minus one.
   *
   * @return phi(n) = (p - 1) * (q - 1)
   */
  private BigInteger generatePhi() {
    return (this.primeP.subtract(BigInteger.ONE)).multiply(this.primeQ.subtract(BigInteger.ONE));
  }

  /**
   * Generates a RsaPair.
   *
   * @return a PsaPair
   */
  public RsaPair generateRsaPair() {
    BigInteger gcdA;
    Random random = new Random();
    BigInteger powerN = this.generatePower();
    BigInteger phi = this.generatePhi();
    gcdA = BigInteger.valueOf(random.nextInt(Integer.MAX_VALUE));
    while (!(powerN.gcd(gcdA)).equals(BigInteger.ONE)
        || !(phi.gcd(gcdA)).equals(BigInteger.ONE)) {
      gcdA = BigInteger.valueOf(random.nextInt(Integer.MAX_VALUE));
    }
    BigInteger modeInverseB = gcdA.modInverse(phi);
    RsaKey publicKey = new RsaKey(modeInverseB, powerN);
    RsaKey secretKey = new RsaKey(gcdA, powerN);
    //System.out.println("Public" + publicKey);
    //System.out.println("Secret" + secretKey);
    return new RsaPair(publicKey, secretKey);
  }


  @Override
  public String toString() {
    return "RsaPairGenerator{"
        + "primeP=" + primeP
        + ", primeQ=" + primeQ
        + '}';
  }

//  public static void main(String[] args) {
//    RsaPairGenerator generator = new RsaPairGenerator();
//    System.out.println(generator);
//    RsaPair rsa = generator.generateRsaPair();
//    System.out.println(rsa);
//  }
}
