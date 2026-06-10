import java.time.LocalDate;

public class Expense{

//FIELDS

    private LocalDate date;
    private String category;
    private String description;
    private double amount;

//GETTERS

    public LocalDate getDate() {
        return date;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public double getAmount() {
        return amount;
    }

//SETTERS

    public void setDate(LocalDate date) {
        if(date == null) {
            this.date = LocalDate.now();
        } else {
            this.date = date;
        }
    }
    public void setCategory(String category ) {
        if(category == null || category.trim().isEmpty()){
            this.category = "Uncategorized";
        } else {
            this.category = category;
        }
    }
    public void setDescription(String description) {
        if(description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("Description is not valid");
        }
        this.description = description;
    }
    public void setAmount(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

//CONSTRUCTOR

    public Expense(LocalDate date, String category, String description, double amount) {
        setDate(date);
        setCategory(category);
        setDescription(description);
        setAmount(amount);
    }

//

    @Override
    public String toString() {
        return "| " + date + " | " + category + " | " + description + " | " + amount + " | ";
    }

//

    public String toCSV() {
        return date + "," + category + "," + description + "," + amount ;
    }

    public static Expense fromCSV(String line) {
        String[] parts = line.split(",");
        LocalDate date = LocalDate.parse(parts[0]);
        String category = parts[1];
        String description = parts[2];
        double amount = Double.parseDouble(parts[3]);

        return new Expense(date, category, description, amount);
    }
}