import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        while (!done) {
            displayList(list);
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Enter your choice [A/D/I/P/Q]: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(list, in);
                    break;
                case "D":
                    deleteItem(list, in);
                    break;
                case "I":
                    insertItem(list, in);
                    break;
                case "P":
                    displayList(list);
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    break;
            }
        }

        System.out.println("Thanks for using ListMaker! Goodbye.");
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A – Add an item");
        System.out.println("D – Delete an item");
        System.out.println("I – Insert an item");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d: %s\n", i + 1, list.get(i));
            }
        }
    }

    private static void addItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter an item to add to the end of the list:");
        list.add(item);
    }

    private static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("Nothing to delete! The list is empty.");
            return;
        }

        displayList(list);
        int itemNum = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, list.size());
        String removed = list.remove(itemNum - 1);
        System.out.println("Deleted: " + removed);
    }

    private static void insertItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter an item to insert into the list:");
        int position = SafeInput.getRangedInt(in, "Enter the position to insert the item at", 1, list.size() + 1);
        list.add(position - 1, item);
        System.out.println("Inserted: " + item + " at position " + position);
    }
}