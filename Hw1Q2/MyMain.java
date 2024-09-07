import java.io.*;
import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();

        String dataFile = "data.txt";

        // read the data and store it in the linked list
        store(dataFile, personList);

        // display the data
        display(System.out, personList);

        // search for a person by id
        String searchId = "30";
        int index = find(searchId, personList);
        if (index != -1) {
            System.out.println("Person with id " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with id " + searchId + " not found");
        }
    }

    public static void store(String inputFile, LinkedList<Person> personList) {
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

    public static void display(PrintStream outputStream, LinkedList<Person> personList) {
        for (Person person : personList) {
            outputStream.println(person);
        }
    }

    public static int find(String sid, LinkedList<Person> personList) {
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person.getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}