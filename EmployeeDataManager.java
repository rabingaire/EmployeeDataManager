import java.util.*;
public class EmployeeDataManager {

  public String[] employeeNames;
  public int[] workedHour;

  public EmployeeDataManager(String displayTitle, String displayDecoration) { //constructor
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

  public void inputData() {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter employee name: ");
    String employeeName = input.nextLine();
    System.out.print("Please enter skill level (1, 2, 3): ");
    int skillLevel = input.nextInt();
  }

  public boolean isValidName(String name){
    
  }

  public void selectOption() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter options 1-8: ");
    int selectionValue = input.nextInt();
    switch(selectionValue) {
      case 1:
        inputData();
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      case 5:
        break;
      case 6:
        break;
      case 7:
        break;
      case 8:
        break;
      default:
        System.out.println("Wrong Input");
    }
  }

  public static void main(String[] args) {
    //object for calling non-static methods
    EmployeeDataManager dataManager = new EmployeeDataManager("Employee Data Manager","-");
    //displays the menu of the program
    dataManager.displayMenu();
    //calls the selectOption input module
    dataManager.selectOption();
  }
}
