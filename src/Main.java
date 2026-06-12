import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("==========================================");
            System.out.println("MENU (Type the number): \n" +
                            "1. Add Expense\n" +
                            "2. View Expense\n" +
                            "3. Delete Expense\n" +
                            "4. Total Spending\n" +
                            "5. View sorted Expense\n" +
                            "6. Save Expense\n" +
                            "7. Quit");
            System.out.println("==========================================");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1 : {
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume leftover newline
                    System.out.print("Use today's date? (Y/N): ");
                    String choiceDate = scanner.nextLine();
                    LocalDate date;
                    if (choiceDate.equalsIgnoreCase("Y")) {
                        date = LocalDate.now();
                    } else {
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        date = LocalDate.parse(scanner.nextLine());
                    }
                    Expense expense = new Expense(date, category, description, amount);
                    manager.addExpense(expense);
                    System.out.println("Expense added successfully.");
                    break;
                }
                case 2 : {
                    for (Expense expense : manager.getExpenses()) {
                        System.out.println(expense);
                    }
                    System.out.println("End of data.");
                    break;
                }
                case 3 : {
                    System.out.print("Date: ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    if (manager.deleteExpense(date, description)) {
                        System.out.println("Deleted Successfully.");
                    } else {
                        System.out.println("Invalid data");
                    }
                    break;
                }
                case 4 : {
                    double total = manager.calculateTotal();
                    System.out.println("Total Expense : " + total);
                    break;
                }
                case 5 : {
                    System.out.println("Select sort type : \n" +
                            "1. Sort By Date\n" +
                            "2. Sort By Amount\n" +
                            "3. Sort By Category");
                    int sortType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descending(y/n) : ");
                    boolean descending = scanner.nextLine().equalsIgnoreCase("Y");
                    switch(sortType) {
                        case 1 : {
                            ArrayList<Expense> sortedExpenses = manager.sortByDate(descending);
                            for(Expense expense : sortedExpenses){
                                System.out.println(expense);
                            }
                            break;
                        }
                        case 2 : {
                            ArrayList<Expense> sortedExpenses = manager.sortByAmount(descending);
                            for(Expense expense : sortedExpenses) {
                                System.out.println(expense);
                            }
                            break;
                        }
                        case 3 : {
                            ArrayList<Expense> sortedExpenses = manager.sortByCategory(descending);
                            for(Expense expense : sortedExpenses) {
                                System.out.println(expense);
                            }
                            break;
                        }
                        default : {
                            System.out.println("Invalid Input. ");
                        }
                    }
                    break;
                }
                case 6 : {
                    manager.saveExpenses();
                    System.out.println("Expenses saved.");
                    break;
                }
                case 7 : {
                    manager.saveExpenses();
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                }
                default : {
                    System.out.println("Invalid Input.");
                }
            }
        }
    }
}