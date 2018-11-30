package edu.neu.ccs.cs5004.problem1;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents a recommendation system.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class RecommendationSystem {
  private static final Integer DEFAULT_NUMBER_OF_USERS_TO_PROCESS = 50;
  private static final Integer DEFAULT_NUMBER_OF_RECOMMENDATIONS = 15;
  private static final String DEFAULT_FLAG = "s";
  private static final String START_FLAG = "s";
  private static final String END_FLAG = "e";
  private static final String RANDOM_FLAG = "r";
  private static final String USER_FLAG = "-u";
  private static final String RECOMMENDATION_FLAG = "-r";
  private static final String PROCESSING_FLAG = "-f";
  private static final Integer USER_SIZE_BASE = 100;
  private static final Integer LOW_INFLUENCE_BASE = 25;
  private static final Integer HIGH_INFLUENCE_BASE = 250;

  private static final String USAGE = "Usage: <file1> <file2> <file3> "
      + "(<flag1> <value1>) (<flag2> <value2>) (<flag3> <value3>)\n";
  private static final String FILE_1 = "<file1>: a String, denoting the name of a CSV file "
      + "containing information about the users (nodes) in the considered network.\n";
  private static final String FILE_2 = "<file2>: a String, denoting the name of a CSV file "
      + "containing information about the edges, where an edge {x, y} denotes "
      + "that user x follows user.\n";
  private static final String FILE_3 = "<file3>: a String, denoting the name of the CSV file used "
      + "to store the output data.\n";
  private static final String FLAG_1 = "<flag1>: '-f', denoting the existence of "
      + "the processing flag.\n";
  private static final String VALUE_1 = "<value1>: a character from the set {s,e,r}, "
      + "where s represents the flag to process users from the beginning, e represents a flag "
      + "to process users from the end, and r represents a flag to process users "
      + "in some random order.\n";
  private static final String FLAG_2 = "<flag2>: '-u', denoting the existence of "
      + "number of users to process.\n";
  private static final String VALUE_2 = "<value2>: an integer in the set [1, 100], "
      + "defining the number of users"
      + "that need recommendations from your system. The default value for "
      + "this parameter is 50. That means that, if not specified differently, your system "
      + "should generate recommendations for 50 social network users.\n";
  private static final String FLAG_3 = "<flag3>: '-r', denoting the existence of "
      + "number of recommendations.\n";
  private static final String VALUE_3 = "<value3>: an integer in the set [1, 100], "
      + "defining the number of recommendations made for a single user. The default value is 15.\n";


  private String nodesFile;
  private String edgesFile;
  private String outputFile;
  private Integer numberOfUsersToProcess = DEFAULT_NUMBER_OF_USERS_TO_PROCESS;
  private String processingFlag = DEFAULT_FLAG;
  private Integer numberOfRecommendations = DEFAULT_NUMBER_OF_RECOMMENDATIONS;
  private AbstractNodeIterator nodeIterator;
  private Integer userSize;
  private Integer influenceBase;
  private Integer argsSize;

  /**
   * Represents a recommendation system.
   *
   * @param args the input parameter args
   */
  public RecommendationSystem(String[] args) {
    this.argsSize = args.length;
    if (argsSize >= 3) {
      this.nodesFile = args[0];
      this.edgesFile = args[1];
      this.outputFile = args[2];


      if (argsSize >= 5) {
        optionParser(args[3], args[4]);
      }
      if (argsSize >= 7) {
        optionParser(args[5], args[6]);
      }
      if (argsSize == 9) {
        optionParser(args[7], args[8]);
      }

      this.userSize = InputProcessSystem.process(this.nodesFile).size() - 1;
      LinkedList<Integer> list = new LinkedList<Integer>();
      for (int i = 0; i <= userSize; i++) {
        list.add(i);
      }

      this.influenceBase = (this.userSize <= USER_SIZE_BASE)
          ? LOW_INFLUENCE_BASE : HIGH_INFLUENCE_BASE;

      switch (this.processingFlag) {
        case START_FLAG:
          nodeIterator = new NodeIterator(list, this.numberOfUsersToProcess);
          break;
        case END_FLAG:
          nodeIterator = new ReverseNodeIterator(list, this.numberOfUsersToProcess);
          break;
        case RANDOM_FLAG:
          nodeIterator = new RandomNodeIterator(list, this.numberOfUsersToProcess);
          break;
        default:
          this.showUsage();
          break;
      }
    }
  }

  /**
   * helper function the parse the command line option.
   *
   * @param name  String of the option
   * @param value String of the option
   */
  private void optionParser(String name, String value) {
    switch (name) {
      case USER_FLAG:
        this.numberOfUsersToProcess = Integer.parseInt(value);
        break;
      case RECOMMENDATION_FLAG:
        this.numberOfRecommendations = Integer.parseInt(value);
        break;
      case PROCESSING_FLAG:
        this.processingFlag = value;
        break;
      default:
        this.showUsage();
        break;
    }
  }

  /**
   * Make recommendations and write the result to file.
   */
  public void makeRecommendation() {
    if (argsSize < 3) {
      this.showUsage();
      // System.exit(1);
      return;
    }
    if (argsSize == 4 || argsSize == 6 || argsSize == 8 || argsSize > 9) {
      this.showUsage();
      return;
    }

    OutputRecommendations out = new OutputRecommendations(this.outputFile);
    while (this.nodeIterator.hasNext()) {
      Integer userIndex = this.nodeIterator.next();
      SingleUserRecommendation singleUserRecommendation = new SingleUserRecommendation(userIndex,
          this.numberOfRecommendations);
      singleUserRecommendation.recommendForUser(this.edgesFile, this.influenceBase, userSize);
      out.writeRecommendation(this.nodeIterator, this.numberOfUsersToProcess,
          this.numberOfRecommendations, this.edgesFile, this.influenceBase, this.userSize);
    }
  }

  /**
   * Prints out the usage when arguments are wrong.
   */
  public void showUsage() {
    System.out.println(USAGE);
    System.out.println(FILE_1);
    System.out.println(FILE_2);
    System.out.println(FILE_3);
    System.out.println(FLAG_1);
    System.out.println(VALUE_1);
    System.out.println(FLAG_2);
    System.out.println(VALUE_2);
    System.out.println(FLAG_3);
    System.out.println(VALUE_3);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    RecommendationSystem that = (RecommendationSystem) obj;
    return Objects.equals(nodesFile, that.nodesFile)
        && Objects.equals(edgesFile, that.edgesFile)
        && Objects.equals(outputFile, that.outputFile)
        && Objects.equals(processingFlag, that.processingFlag)
        && Objects.equals(numberOfUsersToProcess, that.numberOfUsersToProcess)
        && Objects.equals(numberOfRecommendations, that.numberOfRecommendations)
        && Objects.equals(nodeIterator, that.nodeIterator)
        && Objects.equals(userSize, that.userSize)
        && Objects.equals(influenceBase, that.influenceBase)
        && Objects.equals(argsSize, that.argsSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodesFile, edgesFile, outputFile,
        processingFlag, numberOfUsersToProcess, numberOfRecommendations,
        nodeIterator, userSize, influenceBase, argsSize);
  }

  public static void main(String[] args) {
    RecommendationSystem system = new RecommendationSystem(args);
    system.makeRecommendation();
  }
}