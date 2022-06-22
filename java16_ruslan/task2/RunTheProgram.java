package task2;
import java.io.*;
import java.util.*;
public class RunTheProgram {
  private static String p;
  static boolean reg(String S) { // just input control
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("[1-5]");
    java.util.regex.Matcher m = p.matcher(S);
    return m.matches();
  }

  public static void main(String[] args) throws District.SquareLogicException {
    try {
      Scanner in = new Scanner(new File("inputForTask2.txt"));
      Country country = new Country();
      String name = in .next();
      String capital = in .next();
      City capital0 = new City(capital);
      int numberr = in .nextInt();
      Region[] regions = new Region[numberr + 5];
      for (int i = 0; i < numberr; i++) {
        String namei = in .next();
        int numberdi = in .nextInt();
        String capitali = in .next();
        City capitali0 = new City(capitali);
        District[] districts = new District[numberdi + 5];
        for (int j = 0; j < numberdi; j++) {
          String nameij = in .next();
          String capitalij = in .next();
          City capitalij0 = new City(capitalij);
          double squareij = in .nextDouble();
          districts[j] = new District(nameij, capitalij0, squareij);
        }
        regions[i] = new Region(namei, capitali0, numberdi, districts);
      }
      country.setName(name);
      country.setCapital(capital0);
      country.setNumberr(numberr);
      country.setRegions(regions);
      //country.getName();
      int memory1 = 9, choice = -7;
      try {
        while (choice != 0) {
          System.out.print("\nSelect an option (method) and then press Enter:\n1. Show this capital\n2. Show this regions' centers and the total number of regions\n3. Compute this square\n4. Exit!\n");
          int[] mem1 = new int[java.lang.Math.abs(memory1)];
          memory1 *= (choice == 5) ? 100 : 1;
          if (choice != 5)        // in console select option 5 just for testing out of memory
               while (true) {     // just input control
                p = (new java.util.Scanner(System.in)).next();
                if (reg(p)) {
                  choice = Integer.valueOf(p);
                  break;
                    } else {
                 System.out.println("Enter only one natural number between 1 and 5:");
                }
                }
          switch (choice) {
          case 1:
            System.out.println("\n"+country.getCapital()+"\n*************************************");
            break;
          case 2:
            country.getRegionCenters();
            country.getRegionCount();
            break;
          case 3:
            System.out.println("\n"+country.CalculateSquare()+"\n*************************************");
            break;
          case 4:
            System.exit(0);
            break;
          default:
            break;
          }
        }
      } catch (OutOfMemoryError e) {
        System.out.println("out of memory");
      }
    } catch (FileNotFoundException e) {
      System.out.println("cannot open the file inputForTask2.txt");
    } catch (District.SquareLogicException e) {
      System.out.println("square is negative or incorrectly defined");
    }
  }
}