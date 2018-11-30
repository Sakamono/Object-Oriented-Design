package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsaPairGeneratorTest {

  RsaPairGenerator generator = new RsaPairGenerator();

  @Test
  public void generateRsaPair() {
    RsaPair rsaPair = generator.generateRsaPair();
    RsaKey publicKey = rsaPair.getPublicKey();
    RsaKey secretKey = rsaPair.getSecretKey();
    System.out.println(generator);
    System.out.println(rsaPair);
    Assert.assertEquals(publicKey.getDivisor(),secretKey.getDivisor());
  }
}