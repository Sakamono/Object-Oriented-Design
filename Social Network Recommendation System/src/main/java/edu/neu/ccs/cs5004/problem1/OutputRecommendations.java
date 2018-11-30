package edu.neu.ccs.cs5004.problem1;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Objects;
import java.util.Queue;

/**
 * Represents an output system to make a .csv file for all the selected users.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class OutputRecommendations {
  private String outputFile;

  /**
   * Creates a output system to make a .csv file.
   *
   * @param outputFile the output file path
   */
  public OutputRecommendations(String outputFile) {
    this.outputFile = outputFile;
//    writeLine("Node ID", "Recommended Nodes", false);
  }

  /**
   * Write a recommendation for a given user.
   *
   * @param iterator the iterator to generate next user ID.
   * @param numberOfUsersToProcess the number of users to process.
   * @param numberOfRecommendations the number of recommendations for a single user.
   * @param edgesFile the edges file.
   * @param influenceBase the influence base for a influential user.
   * @param maxId the maximum user ID of the user base.
   */
  public void writeRecommendation(AbstractNodeIterator iterator, Integer numberOfUsersToProcess,
                                  Integer numberOfRecommendations,
                                  String edgesFile, Integer influenceBase, Integer maxId) {

    try (Writer fileWriter = new OutputStreamWriter(
        new FileOutputStream(outputFile), "UTF-8")) {

      fileWriter.write("Node ID,Recommended nodes\n\n");

      while (iterator.hasNext() && numberOfUsersToProcess >= 1) {
        numberOfUsersToProcess -= 1;
        Integer userId = iterator.next();
        SingleUserRecommendation res = new SingleUserRecommendation(userId,
            numberOfRecommendations);
        res.recommendForUser(edgesFile, influenceBase, maxId);
        fileWriter.write(userId + ",");
        Queue<Integer> recQueue = res.getResultQueue();
        int recQueueSize = recQueue.size();
        for (int i = 0; i < recQueueSize; i++) {
          fileWriter.write(recQueue.poll() + " ");
        }
        fileWriter.write("\n");
      }
    } catch (IOException e) {
      System.out.println("Something went wrong: " + e.getMessage());
      e.printStackTrace();
    }
  }



  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof OutputRecommendations)) {
      return false;
    }
    OutputRecommendations that = (OutputRecommendations) obj;
    return Objects.equals(outputFile, that.outputFile);
  }


  @Override
  public int hashCode() {
    return Objects.hash(outputFile);
  }
}
