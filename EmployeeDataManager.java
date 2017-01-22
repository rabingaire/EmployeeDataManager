import java.util.*;
public class EmployeeDataManager {

  public void displayMenu() {
    System.out.println("1. Input and validate data");
    System.out.println("2. Display");
    System.out.println("3. Sort by name");
    System.out.println("4. Sort by hours");
    System.out.println("5. Search by name");
    System.out.println("6. Search by hours");
    System.out.println("7. Statistics");
    System.out.println("8. Exit");
  }

  public void displayTitle(String displayTitle, String displayDecoration) {
    System.out.println();
    for(int i = 0; i < 50; i++) {
      if(i < 29) {
        System.out.print(" ");
      } else if(i == 29) {
        System.out.println(displayTitle);
        System.out.println();
      } else if(i>=30 && i<49) {
        System.out.print(" ");
      } else {
        for(int j = 0; j < 45; j++) {
          System.out.print(displayDecoration);
        }
        System.out.println();
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    //object for calling non-static methods
    EmployeeDataManager dataManager = new EmployeeDataManager();
    //displays the title of the program
    dataManager.displayTitle("Employee Data Manager","-");
    //displays the menu of the program
    dataManager.displayMenu();
    
  }
}
