package edu.neu.ccs.cs5004.problem1;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents a recommendation method "Friend of a friend is a friend".
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class RecommendFriendOfFriend implements RecommendationCriteria {


  /**
   * Generates a priority queue that includes the friends of friends of the given user ID.
   *
   * @param userId   the ID of the user to generate recommendations for.
   * @param graphMap the map to use when generate recommendations.
   * @return a priority queue that includes the friends of friends of the given user ID.
   */
  public static Queue<Integer> generateRecommendation(Integer userId,
                                                      Map<Integer, List<Integer>> graphMap) {
    Queue<Integer> res = new PriorityQueue<Integer>();

    if (graphMap.containsKey(userId)) {
      for (Integer friend : graphMap.get(userId)) {
        if (graphMap.containsKey(friend)) {
          for (Integer friendOfFriend : graphMap.get(friend)) {
            if (!res.contains(friendOfFriend)) {
              res.add(friendOfFriend);
            }
          }
        }
      }
    }
    return res;
  }



//  private static void printQueue() {
//    Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
//    Map<Integer, Integer> influentialMap = new HashMap<Integer, Integer>();
//
//    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
//    Queue<Integer> queue = RecommendFriendOfFriend.generateRecommendation(1,graphMap);
//    int size = queue.size();
//    System.out.println(size);
//    for (int i = 0; i < size; i++) {
//      if (i == size - 1) {
//        System.out.println(queue.poll() + "]");
//      } else {
//        System.out.print(queue.poll() + ", ");
//      }
//    }
//  }
//
//  public static void main(String arg[]) {
//    RecommendFriendOfFriend.printQueue();
//  }
}