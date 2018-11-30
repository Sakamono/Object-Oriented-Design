package edu.neu.ccs.cs5004;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents the secure bank verification system.
 *
 * @author zhangxiaoyu
 */
public class SecureBankVerificationSimulator {
  private int numberOfClients;
  private int numberOfVerifications;
  private double invalidPercentage;
  private String outputFileName;
  private static final int MAX_CLIENT_NUMBER = 50000;
  private static final int MAX_VERIFICATION_NUMBER = 10000;
  private static final double MAX_PERCENTAGE = 100.0;
  private static final int INTEGER_LOWER_BOUND = 0;
  private static final double REAL_LOWER_BOUND = 0.0;

  /**
   * Constructor.
   *
   * @param args command line input
   */
  public SecureBankVerificationSimulator(String[] args) {
    if (!(checkInput(args))) {
      return;
    }
    this.numberOfClients = Integer.parseInt(args[0]);
    this.numberOfVerifications = Integer.parseInt(args[1]);
    this.invalidPercentage = Double.parseDouble(args[2]);
    this.outputFileName = args[3];

  }


  private boolean checkInput(String[] args) {
    // Check total number of input arguments
    if (args.length != 4) {
      showErrorMessage("You should enter exactly 4 parameters!");
      return false;
    }
    // Check the first input
    if (Integer.parseInt(args[0]) >= MAX_CLIENT_NUMBER
        || Integer.parseInt(args[0]) <= INTEGER_LOWER_BOUND) {
      showErrorMessage("The first input is invalid!");
      return false;
    }
    // Check the second input
    if (Integer.parseInt(args[1]) >= MAX_VERIFICATION_NUMBER
        || Integer.parseInt(args[1]) <= INTEGER_LOWER_BOUND) {
      showErrorMessage("The second input is invalid!");
      return false;
    }

    // Check the third input
    if (Double.parseDouble(args[2]) >= MAX_PERCENTAGE
        || Double.parseDouble(args[2]) <= REAL_LOWER_BOUND) {
      showErrorMessage("The third input is invalid!");
      return false;
    }
    // Check the fourth input
    String outputFileName = args[3];
    Pattern pattern = Pattern.compile(".+\\.csv");
    Matcher matcher = pattern.matcher(outputFileName);
    if (!matcher.matches()) {
      showErrorMessage("The forth input is invalid!");
      return false;
    }

    return true;

  }

  /**
   * Outputs the error message and the command line arguments input instruction.
   *
   * @param error the error message to be printed.
   */
  private void showErrorMessage(String error) {
    System.out.println("Error: " + error);
    printInstructions();
  }

  private void printInstructions() {
    String string = "\nPlease give four command line input as followed:\n\n";
    string += "\t\tThe number of unique bank clients(An integer in [0, 50000];\n";
    string += "\t\tThe number of unique verifications(An integer in [0, 10000];\n";
    string += "\t\tThe percentage of invalid messages(A real number in [0, 100], "
        + "where 0 means that all of the messages are valid and 100 means all of"
        + " the messages are invalid;\n";
    string += "\t\tThe output file name, and it should be *.csv.\n";
    System.out.println(string);
  }

  /**
   * Simulates the message verification process, including generate client,
   * generate message, validate message and file output.
   */
  private void simulate() {
    // Generate clients
    ClientGenerator clientGenerator = new ClientGenerator(this.numberOfClients);
    clientGenerator.generateClient();

    /* (Info only known to bank) Map Key: client ID,
                                Map Value: <public key, deposit limit, withdrawal limit>*/
    Map<Integer, BankClient> bankClientDatabase = clientGenerator.getBankDatabase();
    //(Info only known to client) Map Key: id, Map Value: RsaPair<public key, secret key>
    Map<Integer, Client> clientSelfDataBase = clientGenerator.getClientDatabase();

    // Generate messages
    MessageGenerator messGenerator = new MessageGenerator(clientSelfDataBase,
        this.numberOfVerifications,
        this.invalidPercentage);
    // Map Key:client ID, Map Value: message, digital signature
    Map<Integer, List<Message>> messagesMap = messGenerator.generateMessage();

    // Validate messages
    MessageValidator validator = new MessageValidator(messagesMap, bankClientDatabase);
    validator.validate();
    // Output .csv file
    OutputProcessor outputProcessor = new OutputProcessor(validator);
    outputProcessor.output(this.outputFileName);

  }

  /**
   * Main method to run the program.
   *
   * @param args command line input
   */
  public static void main(String[] args) {
    SecureBankVerificationSimulator simulator = new SecureBankVerificationSimulator(args);

    simulator.simulate();
  }

  @Override
  public String toString() {
    return "SecureBankVerificationSimulator{"
        + "numberOfClients=" + numberOfClients
        + ", numberOfVerifications=" + numberOfVerifications
        + ", invalidPercentage=" + invalidPercentage
        + ", outputFileName='" + outputFileName + '\''
        + '}';
  }
}




