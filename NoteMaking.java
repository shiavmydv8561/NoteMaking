import java.util.ArrayList;
import java.util.Scanner;

  class Note {
    private final String title;
    private final String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void display() {
        System.out.println("\nTitle: " + title);
        System.out.println("Content: " + content);
    }

    public String getTitle() {
        return title;
    }
}
public class NoteMaking{

    private static final ArrayList<Note> notes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Note Taking Application ---");
            System.out.println("1. Create Note");
            System.out.println("2. View Notes");
            System.out.println("3. Search Note by Title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createNote();
                case 2 -> viewNotes();
                case 3 -> searchNote();
                case 4 -> System.out.println("Exiting app... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

     private static void createNote() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        Note note = new Note(title, content);
        notes.add(note);
        System.out.println("Note saved successfully.");
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }

        System.out.println("\n--- Your Notes ---");
        for (Note note : notes) {
            note.display();
        }
    }

    private static void searchNote() {
        System.out.print("Enter title to search: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;

        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(searchTitle)) {
                note.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Note not found.");
        }
    }
}
