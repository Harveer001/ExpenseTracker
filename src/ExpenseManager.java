import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private static final String FILE_PATH = "data/expenses.csv";

//CONSTRUCTOR

    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpenses();
    }

//METHODS

    public void addExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }
        expenses.add(expense);
    }

    public ArrayList<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    public double calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    public void saveExpenses() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for(Expense expense:expenses) {
                writer.write(expense.toCSV());
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public void loadExpenses() {
        expenses.clear();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while((line = reader.readLine()) != null) {
                Expense expense = Expense.fromCSV(line);
                addExpense(expense);
            }
        }
        catch(IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }

    public boolean deleteExpense(LocalDate date, String description){
        for(int i = 0; i < expenses.size(); i++){
            Expense expense = expenses.get(i);
            if(expense.getDate().equals(date) && expense.getDescription().equals(description)) {
                expenses.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Expense> sortByAmount(boolean descending) {
        ArrayList<Expense> sortedExpenses = new ArrayList<>(expenses);
        if (descending) {
            sortedExpenses.sort(Comparator.comparingDouble(Expense::getAmount).reversed());
        } else {
            sortedExpenses.sort(Comparator.comparingDouble(Expense::getAmount));
        }
        return sortedExpenses;
    }
    public ArrayList<Expense> sortByDate(boolean descending) {
        ArrayList<Expense> sortedExpenses = new ArrayList<>(expenses);
        if (descending) {
            sortedExpenses.sort(Comparator.comparing(Expense::getDate).reversed());
        } else {
            sortedExpenses.sort(Comparator.comparing(Expense::getDate));
        }
        return sortedExpenses;
    }
    public ArrayList<Expense> sortByCategory(boolean descending) {
        ArrayList<Expense> sortedExpenses = new ArrayList<>(expenses);
        if (descending) {
            sortedExpenses.sort(Comparator.comparing(Expense::getCategory).reversed());
        } else {
            sortedExpenses.sort(Comparator.comparing(Expense::getCategory));
        }
        return sortedExpenses;
    }
}