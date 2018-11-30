package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.attackresult.Hit;
import edu.neu.ccs.cs5004.model.attackresult.Miss;
import edu.neu.ccs.cs5004.model.attackresult.Sunk;
import edu.neu.ccs.cs5004.model.battlefield.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class ConsolePrinterTest {
  private ConsolePrinter printer;
  private ConsolePrinter sameRefPrinter;
  private ConsolePrinter sameStateAsPrinter;
  private ConsolePrinter yetAnotherPrinter;
  private ConsolePrinter nullPrinter = null;
  private Map map;
  ByteArrayInputStream in;
  private AttackResult attackResult1;
  private AttackResult attackResult2;
  private AttackResult attackResult3;



  @Before
  public void setUp() throws Exception {
    printer = new ConsolePrinter();
    map = new Map();
    sameRefPrinter = printer;
    sameStateAsPrinter = new ConsolePrinter();
    yetAnotherPrinter = new ConsolePrinter();
    attackResult1 = new Hit();
    attackResult2 = new Miss();
    attackResult3 = new Sunk();

  }

  @Test
  public void toConsole() {
    printer.toConsole(map);
  }

  @Test
  public void toEnemyMap() {
    printer.toEnemyMap(map);
  }

  @Test
  public void printRegularGame() {

  }

  @Test
  public void printDebugGame() {
  }

  @Test
  public void mode() {
    in = new ByteArrayInputStream("D".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,ConsolePrinter.mode());
    System.setIn(System.in);

    in = new ByteArrayInputStream("G".getBytes());
    System.setIn(in);
    Assert.assertEquals(false,ConsolePrinter.mode());
    System.setIn(System.in);

  }

  @Test
  public void numOfShip() {
    in = new ByteArrayInputStream("1".getBytes());
    System.setIn(in);
    Assert.assertEquals(1,ConsolePrinter.numOfShip("BattleShip"));
    System.setIn(System.in);
  }

  @Test
  public void randPlace() {
    in = new ByteArrayInputStream("N".getBytes());
    System.setIn(in);
    Assert.assertEquals(false,ConsolePrinter.randPlace());
    System.setIn(System.in);

    in = new ByteArrayInputStream("Y".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,ConsolePrinter.randPlace());
    System.setIn(System.in);

  }

  @Test
  public void smartAttack() {
    in = new ByteArrayInputStream("R".getBytes());
    System.setIn(in);
    Assert.assertEquals(false,ConsolePrinter.smartAttack());
    System.setIn(System.in);

    in = new ByteArrayInputStream("S".getBytes());
    System.setIn(in);
    Assert.assertEquals(true,ConsolePrinter.smartAttack());
    System.setIn(System.in);


  }

  @Test
  public void gameStart() {
    ConsolePrinter.gameStart();
  }

  @Test
  public void attackMessage() {
    ConsolePrinter.attackMessage(attackResult1);
    ConsolePrinter.attackMessage(attackResult2);
    ConsolePrinter.attackMessage(attackResult3);
  }

  @Test
  public void printWin() {
    ConsolePrinter.printWin();
  }

  @Test
  public void printLose() {
    ConsolePrinter.printLose();
  }

  @Test
  public void printName() {
    ConsolePrinter.printName();
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(printer.equals(printer));
    Assert.assertTrue(printer.equals(sameRefPrinter));
    Assert.assertTrue(printer.equals(sameStateAsPrinter));
    Assert.assertTrue(sameStateAsPrinter.equals(printer));
    Assert.assertEquals(printer.equals(sameStateAsPrinter)
        && sameStateAsPrinter.equals(yetAnotherPrinter), yetAnotherPrinter.equals(printer));
    Assert.assertFalse(printer.equals(map));
    Assert.assertFalse(printer.equals(nullPrinter));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(printer.equals(sameRefPrinter),
        printer.hashCode() == sameRefPrinter.hashCode());
    Assert.assertEquals(printer.equals(sameStateAsPrinter),
        printer.hashCode() == sameStateAsPrinter.hashCode());
  }
}