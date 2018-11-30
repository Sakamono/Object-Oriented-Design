package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ClientGeneratorTest {
  ClientGenerator generator = new ClientGenerator(1000);
  Map<Integer,Client> clientDatabase = new HashMap<>();
  Map<Integer,BankClient> bankDatabase = new HashMap<>();

  @Before
  public void setUp() throws Exception {
    generator.generateClient();
    bankDatabase = generator.getBankDatabase();
    clientDatabase = generator.getClientDatabase();
  }

  @Test
  public void generateClient() {
    for(Map.Entry<Integer,Client> entry : clientDatabase.entrySet()){
      assertEquals("public key",entry.getValue().getPublicKey(),bankDatabase
          .get(entry.getKey()).getPublicKey());
    }
  }

  @Test
  public void getBankDatabase() {
    Assert.assertEquals(1000, bankDatabase.size());
  }

  @Test
  public void getClientDatabase() {
    Assert.assertEquals(1000, clientDatabase.size());
  }
}