import java.io.*;
import java.util.*;

class PersonList {
    private LinkedList<Person> personList;

    public PersonList() {
        personList = new LinkedList<>();
    }

    public void store(String inputFile) {
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String firstName = data[0];
                String lastName = data[1];
                String id = data[2];
                Person person = new Person(firstName, lastName, id);
                personList.add(person);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        }
    }

    public void display(PrintStream out) {
        for (Person person : personList) {
            out.println(person);
        }
    }

    public int find(String id) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}

public class MyMain {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        // Create a data file with data for a few person objects
        String dataFile = "data.txt";

        // Call the store() method to read the data and store it in the linked list
        personList.store(dataFile);

        // Call the display() method to display the data
        personList.display(System.out);

        // Invoke the find() method to search for a person by id
        String searchId = "30";
        int index = personList.find(searchId);
        if (index != -1) {
            System.out.println("Person with id " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with id " + searchId + " not found");
        }
    }
}