import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Expense expense1 = new Expense(LocalDate.now(), "Food", "Pizza", 700);
        //Expense expense2 = new Expense(LocalDate.now(), "Play", "Cricket", 100);
        ExpenseManager expenseManage= new ExpenseManager();
        //expenseManage.addExpense(expense1);
        //expenseManage.addExpense(expense2);
        //double total = expenseManage.calculateTotal();
        //System.out.println(total);
        //System.out.println(expenseManage.getExpenses().size());
        //expenseManage.saveExpenses();
        //ExpenseManager manager = new ExpenseManager();
        expenseManage.loadExpenses();
        System.out.println(expenseManage.getExpenses().size());
    }
}