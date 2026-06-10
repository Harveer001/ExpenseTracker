import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Expense expense = new Expense(LocalDate.now(), "Food", "Pizza Hut", 100);
        String csv = expense.toCSV();
        System.out.println(csv);
        Expense loaded = Expense.fromCSV(csv);
        System.out.println(loaded);
    }
}