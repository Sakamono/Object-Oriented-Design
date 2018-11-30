package edu.neu.ccs.cs5004;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Represents a output processor.
 *
 * @author zhangxiaoyu
 */
public class OutputProcessor {
  private MessageValidator validator;

  public OutputProcessor(MessageValidator validator) {
    this.validator = validator;
  }

  /**
   * Writes message result to the output file.
   * @param outputFileName the output file name
   */
  public void output(String outputFileName) {
    PrintWriter output = null;
    try {
      //output file
      File file = new File(outputFileName);
      Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
      output = new PrintWriter(writer);
      //Add header
      output.println("Transaction number-Date,Time,Client ID,Message,Digital signature,Verified,"
          + "Transactions status");
      //transactionNumber works as the record of increasing transaction number
      int transactionNumber = 1;
      Map<Integer, List<Message>> messagesMap = this.validator.getMessagesMap();
      for (Map.Entry<Integer, List<Message>> messagesOneId : messagesMap.entrySet()) {
        //get client Info
        int clientId = messagesOneId.getKey();
        //loop for each message with this ID
        for (Message messageData : messagesOneId.getValue()) {
          //write into file
          output.println(transactionNumber + "-" + this.getDay() + ","
              + this.getTime() + "," + clientId + ","
              + messageData.getMessageContent() + "," + messageData.getDigitalSignature()
              + "," + messageData.isVerified()
              + "," + this.getTransactionStatus(messageData));
          // increase the record of transaction number
          transactionNumber++;

        }
      }


    } catch (IOException ioe) {
      System.out.println("Something went wrong" + ioe.getMessage());
    } finally {
      if (output != null) {
        output.close();
      }
    }
  }

  /**
   * Gets the current date.
   * @return current date.
   */
  private String getDay() {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(date);
  }

  /**
   * Gets the current time.
   * @return current time.
   */
  private String getTime() {
    Date date = new Date();
    DateFormat timeFormat = DateFormat.getTimeInstance();
    return timeFormat.format(date);
  }


  /**
   * Tells the message is deposit or withdrawal.
   *
   * @param message the checked message
   * @return true if the message is for deposit, and false if the message is for withdrawal
   */
  private boolean depositOrWithdrawal(Message message) {
    int lastDigit = message.getMessageContent() % 10;
    return lastDigit >= 0 && lastDigit <= 4;
  }


  /**
   * Gets transaction status.
   *
   * @param message the input message
   * @return the corresponding string
   */
  private String getTransactionStatus(Message message) {
    if (depositOrWithdrawal(message)) {
      if (message.isVerified() && message.isValid()) {
        return "deposit accepted";
      } else {
        return "deposit rejected";
      }
    } else {
      if (message.isVerified() && message.isValid()) {
        return "withdrawal accepted";
      } else {
        return "withdrawal rejected";
      }
    }
  }

}
