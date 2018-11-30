package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MessageValidatorTest {
  ClientGenerator generator = new ClientGenerator(50);
  Map<Integer,Client> clientDatabase = new HashMap<>();
  Map<Integer,BankClient> bankDatabase = new HashMap<>();
  MessageGenerator messageGenerator;
  Map<Integer, List<Message>> messageMap = new HashMap<>();
  MessageValidator messageValidator;

  @Before
  public void setUp() throws Exception {
    generator.generateClient();
    clientDatabase = generator.getClientDatabase();
    bankDatabase = generator.getBankDatabase();
    messageGenerator = new MessageGenerator(clientDatabase,
        50,50.0);
    messageMap = messageGenerator.generateMessage();
    messageValidator = new MessageValidator(messageMap,bankDatabase);
  }

  @Test
  public void validate() {
    messageValidator.validate();
  }

  @Test
  public void getMessagesMap() {
    System.out.println(messageValidator.getMessagesMap());
  }

  @Test
  public void getBankDatabase() {
    System.out.println(messageValidator.getBankDatabase());
  }
}