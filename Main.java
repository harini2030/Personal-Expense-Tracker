import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    int id;
    String category;
    double amount;
    String description;

    Expense(int id, String category, double amount, String description) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public void display() {
        System.out.println(id + " | " + category + " | ₹" + amount + " | " + description);
    }
}

public class Main {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    public static void addExpense() {
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        expenses.add(new Expense(id++, category, amount, description));

        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\nID | Category | Amount | Description");

        for (Expense expense : expenses) {
            expense.display();
        }
    }

    public static void totalExpense() {
        double total = 0;

        for (Expense expense : expenses) {
            total += expense.amount;
        }

        System.out.println("Total Expense: ₹" + total);
    }

    public static void deleteExpense() {
        System.out.print("Enter expense ID: ");
        int deleteId = sc.nextInt();
        sc.nextLine();

        for (Expense expense : expenses) {
            if (expense.id == deleteId) {
                expenses.remove(expense);
                System.out.println("Expense deleted successfully!");
                return;
            }
        }

        System.out.println("Expense not found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalExpense();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}