package edu.neu.ccs.cs5004.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents a recommendation system for a single user.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class SingleUserRecommendation {
  private Integer userId;
  private Queue<Integer> resultQueue;
  private Integer numberOfRecommendations;
  private Integer currentNumberOfRecommendations;
  private static final Integer DEFAULT = 15;
  private static final Integer ZERO = 0;


  /**
   * Creates a recommendation system for a single user.
   *
   * @param userId                         the user id of the user.
   * @param resultQueue                    the recommendation result for the user.
   * @param numberOfRecommendations        the number of recommendations.
   * @param currentNumberOfRecommendations the current number of recommendations.
   */
  private SingleUserRecommendation(Integer userId, Queue<Integer> resultQueue,
                                   Integer numberOfRecommendations,
                                   Integer currentNumberOfRecommendations) {
    this.userId = userId;
    this.resultQueue = resultQueue;
    this.numberOfRecommendations = numberOfRecommendations;
    this.currentNumberOfRecommendations = currentNumberOfRecommendations;
  }

  /**
   * Creates a recommendation system for a single user.
   *
   * @param userId                  the user id of the user.
   * @param numberOfRecommendations the number of recommendations for user.
   */
  public SingleUserRecommendation(Integer userId, Integer numberOfRecommendations) {
    this.userId = userId;
    this.resultQueue = new PriorityQueue<>();
    this.numberOfRecommendations = numberOfRecommendations;
    this.currentNumberOfRecommendations = ZERO;
  }

  /**
   * Creates a recommendation system for a single user.
   *
   * @param userId the user id of the user.
   */
  public SingleUserRecommendation(Integer userId) {
    this.userId = userId;
    this.resultQueue = new PriorityQueue<>();
    this.numberOfRecommendations = DEFAULT;
    this.currentNumberOfRecommendations = ZERO;
  }

  /**
   * Getter for the result queue.
   *
   * @return the result queue.
   */
  public Queue<Integer> getResultQueue() {
    return resultQueue;
  }


  /**
   * Makes recommendation for a single user.
   *
   * @param fileName the source file name.
   * @param base     basic number of followers for influential user.
   * @param maxId    the max id number of all the users.
   */
  public void recommendForUser(String fileName, Integer base, Integer maxId) {
    Map<Integer, List<Integer>> graphMap = new HashMap<>();
    Map<Integer, Integer> influentialMap = new HashMap<>();
    UserGraphGenerationSystem.process(fileName, graphMap, influentialMap);
    Queue<Integer> friendQueue = RecommendFriendOfFriend.generateRecommendation(userId, graphMap);
    Queue<Integer> influentialQueue =
        RecommendByInfluence.generateRecommendation(influentialMap, base);
    Queue<Integer> randomQueue;
    int size1 = friendQueue.size();
    int size2 = influentialQueue.size();
    for (int i = 0; i < size1; i++) {
      if (this.currentNumberOfRecommendations < this.numberOfRecommendations
          && !this.resultQueue.contains(friendQueue.peek())) {
        this.resultQueue.add(friendQueue.poll());
        this.currentNumberOfRecommendations++;
      }
      if (this.currentNumberOfRecommendations >= this.numberOfRecommendations) {
        break;
      }
    }
    for (int i = 0; i < size2; i++) {
      if (this.currentNumberOfRecommendations < this.numberOfRecommendations
          && !this.resultQueue.contains(influentialQueue.peek())) {
        this.resultQueue.add(influentialQueue.poll());
        this.currentNumberOfRecommendations++;
      }
      if (currentNumberOfRecommendations >= numberOfRecommendations) {
        break;
      }
    }

    randomQueue = RecommendRandomUser.generateRecommendations(resultQueue,
        numberOfRecommendations - currentNumberOfRecommendations, maxId);
    int randomQueueSize = randomQueue.size();
    for (int i = 0; i < randomQueueSize; i++) {
      resultQueue.add(randomQueue.poll());
      this.currentNumberOfRecommendations++;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    SingleUserRecommendation that = (SingleUserRecommendation) obj;
    return Objects.equals(userId, that.userId)
        && Objects.equals(numberOfRecommendations, that.numberOfRecommendations)
        && Objects.equals(currentNumberOfRecommendations, that.currentNumberOfRecommendations);
  }


  @Override
  public int hashCode() {
    return Objects.hash(userId, numberOfRecommendations,
        currentNumberOfRecommendations);
  }

  @Override
  public String toString() {
    return "SingleUserRecommendation{"
        + "userId=" + userId
        + ", resultQueue=" + resultQueue
        + ", numberOfRecommendations=" + numberOfRecommendations
        + ", currentNumberOfRecommendations=" + currentNumberOfRecommendations
        + '}';
  }

//  /**
//   * Prints the result queue.
//   */
//  public void printResultQueue() {
//    System.out.println("Recommended users for user ID: " + this.userId + ",
//    are as follows: \n\n");
//
//    System.out.print("[");
//    int size = this.resultQueue.size();
//    for (int i = 0; i < size; i++) {
//      if (i == size - 1) {
//        System.out.println(this.resultQueue.poll() + "]");
//      } else {
//        System.out.print(this.resultQueue.poll() + ", ");
//      }
//    }
//  }

//  public static void main(String arg[]) {
//    SingleUserRecommendation test = new SingleUserRecommendation(35);
//    test.recommendForUser("edges_small.csv", 25, 100);
//    System.out.println("result queue size = " + test.resultQueue.size());
//    test.printResultQueue();
//  }
}
