import java.util.*;
public class EmployeeDataManager {

  public ArrayList<String> employeeNames = new ArrayList<String>();
  public ArrayList<Integer> workedHours = new ArrayList<Integer>();
  public ArrayList<Integer> wage = new ArrayList<Integer>();

  public EmployeeDataManager() { //constructor
    System.out.println();
    System.out.println("\t\t\t\tEmployee Data Manager" );
    System.out.println();
    System.out.println("\t\t\t----------------------------------------");
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
    String name = input.nextLine().toLowerCase();
    System.out.print("Please enter skill level (1, 2, 3): ");
    int skillLevel = input.nextInt();
    System.out.print("Please enter worked hour: ");
    int workedHour = input.nextInt();

    if( workedHour >= 0 && workedHour <= 60) { //validate worked hour
      if (calculateWage(skillLevel, workedHour)) { //calling function to calculate wage and validate skillLevel
        //adding data to ArrayList
        employeeNames.add(name);
        workedHours.add(workedHour);
      }
    } else  {
      System.out.println();
      System.out.println("\t----------------------------------------------------------------------");
      System.out.println("\t\tWorked hour must be at the range between 0 and 60 try agin!");
      System.out.println("\t----------------------------------------------------------------------");
    }
  }

  public void selectOption() {
    Scanner input = new Scanner(System.in);
    int selectionValue;
    do{
      System.out.println();
      //displays the menu of the program
      displayMenu();
      System.out.print("Enter options 1-8: ");
      selectionValue = input.nextInt();
      switch(selectionValue) {
        case 1:
          inputData();
          break;
        case 2:
          display();
          break;
        case 3:
          sortByName();
          break;
        case 4:
          sortByHours();
          break;
        case 5:
          searchByName();
          break;
        case 6:
          searchByHours();
          break;
        case 7:
          statistics();
          break;
        case 8:
          System.out.println();
          System.out.println("\t\t-------------------------");
          System.out.println("\t\t\tThank You");
          System.out.println("\t\t-------------------------");
          break;
        default:
          System.out.println();
          System.out.println("\t\t-------------------------");
          System.out.println("\t\t\tWrong Input");
          System.out.println("\t\t-------------------------");

      }
    } while (selectionValue != 8);
  }

  public void display() {
    System.out.println("\t\t\t\tEmployee worked hours & wage");
    System.out.println("\t\t\t========================================");
    System.out.println("\t\t\tEmployee\tWorked hours\tWage");
    System.out.println("\t\t\t----------------------------------------");

    //display all list/Data
    for (int i = 0; i < employeeNames.size(); i++ ) {
      System.out.println("\t\t\t" + employeeNames.get(i) + "\t" + workedHours.get(i) + "\t\t$" + wage.get(i) );
    }

    System.out.println();
    System.out.println("\t\t\tTotal:" + employeeNames.size() + " data entries");
  }

  public void searchByName() {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter employee name: ");
    String searchName = input.nextLine().toLowerCase();

    System.out.println();
    if(employeeNames.contains(searchName)) {
      for ( int i = 0; i < employeeNames.size(); i++ ) {
        if(searchName.equals(employeeNames.get(i))) {
          System.out.println("\t\t\t" + employeeNames.get(i) + " - Worked Hours: " + workedHours.get(i) + " - Wage:$" + wage.get(i) );
        }
      }
      System.out.println("\t\t--------------------------------------------------");
    } else  {
      System.out.println("\t\t--------------------------------------------------");
      System.out.println("\t\t\tSorry! Data Not Found.");
      System.out.println("\t\t--------------------------------------------------");
    }
  }

  public void searchByHours() {
    boolean checkDataExists = false;
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the specific number of worked hours: ");
    int searchHour = input.nextInt();

    System.out.println("The following employees have less than " + searchHour + " worked hours:");
    System.out.println();
    for ( int i = 0; i < workedHours.size(); i++ ) {
      if(searchHour >= workedHours.get(i)) {
        checkDataExists = true;
        System.out.println("\t\t" + employeeNames.get(i) + "  " + workedHours.get(i) + " hours");
      }
    }
    if(!checkDataExists) {
      System.out.println("\t\t--------------------------------------------------");
      System.out.println("\t\t\tSorry! Data not found.");
      System.out.println("\t\t--------------------------------------------------");
    }
    System.out.println();
  }

  public void statistics() {
    System.out.println("\t\t\t\tA simple statistics");
    System.out.println();
    System.out.println("\t\t\t========================================");
    System.out.println();

    for ( int i = 0; i < workedHours.size(); i++ ) {
      //displays lowest workedHour info
      if(checkLowest() == workedHours.get(i)) {
        System.out.println("\tThe employee has lowest worked hours: " + employeeNames.get(i) + ", " + workedHours.get(i) + " hours"  );
      }
      //displays highest workedHour info
      if(checkHighest() == workedHours.get(i)) {
        System.out.println("\tThe employee has highest worked hours: " + employeeNames.get(i) + ", " + workedHours.get(i) + " hours"  );
      }
    }
    System.out.println("\tThe median value of worked hours: ");
  }

  public int checkLowest() {
    int lowest = workedHours.get(1);
    for ( int i = 0; i < workedHours.size(); i++ ) {
      if ( workedHours.get(i) < lowest){
        lowest = workedHours.get(i);
      }
    }
    return lowest;
  }

  public int checkHighest() {
    int highest = 0;
    for ( int i = 0; i < workedHours.size(); i++ ) {
      if ( workedHours.get(i) > highest){
        highest = workedHours.get(i);
      }
    }
    return highest;
  }


  public boolean calculateWage(int skillLevel, int workedHour){
    switch(skillLevel) {
      case 1:
        int wageSkillOne = workedHour * 15;
        wage.add(wageSkillOne);
        return true;
      case 2:
        int wageSkillTwo = workedHour * 17;
        wage.add(wageSkillTwo);
        return true;
      case 3:
        int wageSkillThree = workedHour * 21;
        wage.add(wageSkillThree);
        return true;
      default:
        System.out.println();
        System.out.println("\t\t------------------------------------------------------------");
        System.out.println("\t\t\tWrong Input skillLevel cannot be " + skillLevel + " try again!");
        System.out.println("\t\t------------------------------------------------------------");
        return false;
    }
  }

  public void sortByName() {
    int i = 0;
    int j = employeeNames.size() - 1;
    while(i < employeeNames.size()) {
      while(j > i) {
        if(employeeNames.get(i).compareTo(employeeNames.get(j)) > 0) {
          String tempString = employeeNames.get(i);
          employeeNames.set(i,employeeNames.get(j));
          employeeNames.set(j,tempString);

          int temp = workedHours.get(i);
          workedHours.set(i,workedHours.get(j));
          workedHours.set(j,temp);

          int tempInt = wage.get(i);
          wage.set(i,wage.get(j));
          wage.set(j,tempInt);
        }
        j--;
      }
      i++;
    }
    display();
  }

  public void sortByHours() {
    int i = 0;
    int j = workedHours.size() - 1;
    while (i < workedHours.size()) {
      while(j > i){
        if(workedHours.get(i) > workedHours.get(j)){
          int temp = workedHours.get(i);
          workedHours.set(i,workedHours.get(j));
          workedHours.set(j,temp);

          String tempString = employeeNames.get(i);
          employeeNames.set(i,employeeNames.get(j));
          employeeNames.set(j,tempString);

          int tempInt = wage.get(i);
          wage.set(i,wage.get(j));
          wage.set(j,tempInt);
        }
        j--;
      }
      i++;
    }
    display();
  }

  public static void main(String[] args) {
    //object for calling non-static methods
    EmployeeDataManager dataManager = new EmployeeDataManager();

    //calls the selectOption input module
    dataManager.selectOption();
  }
}
