package homework7.services;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileContactsService extends InMemoryContactsService {
    private Path file = Paths.get("phonebook.txt");

    {
        String[] linesArray = readFile().split(" ");
        for (int i = 0; i < linesArray.length; i += 2) {
            add(new Contact(linesArray[i], linesArray[i + 1]));
        }
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        writeToFile(stringFromContactsList());
    }

    @Override
    public void add(Contact c) {
        super.add(c);
        writeToFile(stringFromContactsList());
    }

    public String readFile() {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().trim();
    }

    public ContactsList contactsListFromString(String s) {
        ContactsList cL = new ContactsList();
        String[] linesArray = s.split(" ");
        for (int i = 0; i < linesArray.length; i += 2) {
            cL.add(new Contact(linesArray[i], linesArray[i + 1]));
        }
        return cL;
    }

    public String stringFromContactsList() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            result.append(get(i).getName()).append(" ");
            result.append(get(i).getNumber());
            if (i != size() - 1) {
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    public void writeToFile(String output) {
        try (FileWriter fw = new FileWriter(file.toFile(), StandardCharsets.UTF_8)) {
            fw.write(output);
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
