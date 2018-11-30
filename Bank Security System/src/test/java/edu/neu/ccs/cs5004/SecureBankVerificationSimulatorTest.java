package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecureBankVerificationSimulatorTest {
  SecureBankVerificationSimulator simulator1;
  SecureBankVerificationSimulator simulator2;
  SecureBankVerificationSimulator simulator3;
  SecureBankVerificationSimulator simulator4;
  SecureBankVerificationSimulator simulator5;
  SecureBankVerificationSimulator simulator6;
  SecureBankVerificationSimulator simulator7;
  SecureBankVerificationSimulator simulator8;
  SecureBankVerificationSimulator simulator9;
  String[] args1 = {"10000","200", "50.0", "test1.csv"};
  String[] args2 = {"10000"};// number is wrong
  String[] args3 = {"60000","200", "50.0", "test1.csv"};//first argument is wrong
  String[] args4 = {"-1","200", "50.0", "test1.csv"};//first argument is wrong
  String[] args5 = {"10000","10001", "50.0", "test1.csv"};//second argument is wrong
  String[] args6 = {"10000","-1", "50.0", "test1.csv"};//second argument is wrong
  String[] args7 = {"10000","200", "101.0", "test1.csv"};//third argument is wrong
  String[] args8 = {"10000","10001", "-1.0", "test1.csv"};//third argument is wrong
  String[] args9 = {"10000","200", "50.0", "test1"};//forth argument is wrong


  @Before
  public void setUp() throws Exception {
    simulator1 = new SecureBankVerificationSimulator(args1);
    simulator2 = new SecureBankVerificationSimulator(args2);
    simulator3 = new SecureBankVerificationSimulator(args3);
    simulator4 = new SecureBankVerificationSimulator(args4);
    simulator5 = new SecureBankVerificationSimulator(args5);
    simulator6 = new SecureBankVerificationSimulator(args6);
    simulator7 = new SecureBankVerificationSimulator(args7);
    simulator8 = new SecureBankVerificationSimulator(args8);
    simulator9 = new SecureBankVerificationSimulator(args9);
  }

  @Test
  public void main() {
    SecureBankVerificationSimulator.main(args1);
  }
}