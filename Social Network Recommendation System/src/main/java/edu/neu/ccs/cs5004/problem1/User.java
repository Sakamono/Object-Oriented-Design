package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Represents a user with all the details.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class User implements Comparable<User> {
  private Integer userId;
  private String dateCreated;
  private String gender;
  private Integer age;
  private String city;

  /**
   * Creates a new user item given the information of the user.
   *
   * @param userId      the unique user id.
   * @param dateCreated the date when the user is created in the system. In MM/DD/YY format.
   * @param gender      the gender of the user. M for male, F for female, O for other.
   * @param age         the age of the user.
   * @param city        the city where the user is from.
   */
  public User(Integer userId, String dateCreated, String gender, Integer age, String city) {
    this.userId = userId;
    this.dateCreated = dateCreated;
    this.gender = gender;
    this.age = age;
    this.city = city;
  }

  /**
   * Getter for the property 'userId'.
   *
   * @return the value of property 'userId'.
   */
  public Integer getUserId() {
    return this.userId;
  }


  /**
   * Compare two users simply basing on the user IDs of the two users.
   *
   * @param user the user to compare to.
   * @return 1 if this user's ID is larger than that of the given user, 0 if both are the same ID,
   *     -1 if this user's ID is smaller than that of the given user.
   */
  @Override
  public int compareTo(User user) {
    if (this.getUserId() < user.getUserId()) {
      return -1;
    } else if (this.getUserId().equals(user.getUserId())) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public String toString() {
    return "[" + "User " + this.userId + ", " + this.dateCreated + ", "
        + this.gender + ", " + this.age + ", " + this.city + "]";
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    User user = (User) object;
    return Objects.equals(userId, user.userId)
        &&
        Objects.equals(dateCreated, user.dateCreated)
        &&
        Objects.equals(gender, user.gender)
        &&
        Objects.equals(age, user.age)
        &&
        Objects.equals(city, user.city);
  }

  @Override
  public int hashCode() {

    return Objects.hash(userId, dateCreated, gender, age, city);
  }

//  public static void main(String[] args) {
//    User newUser = new User(1, "2/3/2000", "M", 33, "Seattle");
//    System.out.println(newUser);
//  }
}