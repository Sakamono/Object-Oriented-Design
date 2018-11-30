package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class MessageGeneratorTest {
  ClientGenerator generator = new ClientGenerator(50);
  Map<Integer,Client> clientDatabase = new HashMap<>();
  MessageGenerator messageGenerator;
  Map<Integer, List<Message>> messageMap = new HashMap<>();

  @Before
  public void setUp() throws Exception {
    generator.generateClient();
    clientDatabase = generator.getClientDatabase();
    messageGenerator = new MessageGenerator(clientDatabase,
        50,50.0);
  }

  @Test
  public void generateMessage() {
    messageMap = messageGenerator.generateMessage();
    for(Map.Entry<Integer,List<Message>> entry: messageMap.entrySet()){
      assertTrue(clientDatabase.containsKey(entry.getKey()));
    }
    System.out.println(messageMap);
  }
}