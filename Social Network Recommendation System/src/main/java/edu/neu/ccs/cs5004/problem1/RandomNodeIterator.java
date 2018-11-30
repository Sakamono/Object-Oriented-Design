package edu.neu.ccs.cs5004.problem1;

import java.util.LinkedList;

/**
 * Represents an iterator to loop over a given list of node id randomly.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class RandomNodeIterator extends AbstractNodeIterator {

  /**
   * Create an iterator to loop over a given list of node id randomly.
   *
   * @param list                   LinkedList of the input list of node id
   * @param numberOfUsersToProcess total number of user need to be returned
   */
  public RandomNodeIterator(LinkedList<Integer> list, Integer numberOfUsersToProcess) {
    super(list, numberOfUsersToProcess);
  }

  @Override
  public Integer next() {
    numberOfProcessedUser++;
    Integer index = (int) Math.floor(Math.random() * list.size());
    Integer val = list.get(index);
    list.remove(index);
    return val;
  }


  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }


  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
