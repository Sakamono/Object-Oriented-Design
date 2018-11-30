package edu.neu.ccs.cs5004.problem1;

import java.util.LinkedList;

/**
 * Represents an iterator to loop over a given list of node id from end.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class ReverseNodeIterator extends AbstractNodeIterator {

  /**
   * Create an iterator to loop over a given list of node id from the end.
   *
   * @param list                   LinkedList of the input list of node id
   * @param numberOfUsersToProcess total number of user need to be returned
   */
  public ReverseNodeIterator(LinkedList<Integer> list, Integer numberOfUsersToProcess) {
    super(list, numberOfUsersToProcess);
  }


  @Override
  public Integer next() {
    numberOfProcessedUser++;
    return list.pollLast();
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
