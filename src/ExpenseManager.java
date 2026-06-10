import java.io.*;
import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private static final String FILE_PATH = "data/expenses.csv";

//CONSTRUCTOR

    public ExpenseManager() {
        expenses = new ArrayList<>();
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
}