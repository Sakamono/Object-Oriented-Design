package edu.neu.ccs.cs5004.problem1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents an abstract iterator to loop over a given list of node id.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public abstract class AbstractNodeIterator implements Iterator<Integer> {
  protected LinkedList<Integer> list = new LinkedList<>();
  protected Integer numberOfProcessedUser = 0;
  protected Integer numberOfUsersToProcess;

  /**
   * Creates an abstract iterator to loop over a given list of node id.
   *
   * @param list                   LinkedList of the input list of node id
   * @param numberOfUsersToProcess total number of user need to be returned
   */
  public AbstractNodeIterator(LinkedList<Integer> list, Integer numberOfUsersToProcess) {
    this.numberOfUsersToProcess = numberOfUsersToProcess;
    this.list = list;
  }


  @Override
  public boolean hasNext() {
    return list.size() > 0 && numberOfProcessedUser < numberOfUsersToProcess;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("remove is not supported in node iterator");
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AbstractNodeIterator)) {
      return false;
    }
    AbstractNodeIterator that = (AbstractNodeIterator) obj;
    return list.equals(that.list)
        &&
        Objects.equals(numberOfProcessedUser, that.numberOfProcessedUser)
        &&
        Objects.equals(numberOfUsersToProcess, that.numberOfUsersToProcess);
  }


  @Override
  public int hashCode() {

    return Objects.hash(list, numberOfProcessedUser, numberOfUsersToProcess);
  }
}
