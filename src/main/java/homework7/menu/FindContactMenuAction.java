package homework7.menu;

import homework7.services.ContactsService;
import homework7.ui.ContactsView;

import java.util.Scanner;

public class FindContactMenuAction implements MenuAction {
    Scanner scanner;
    private ContactsService phoneBook;
    private ContactsView contactsView;

    public FindContactMenuAction(Scanner scanner, ContactsService phoneBook, ContactsView contactsView) {
        this.scanner = scanner;
        this.phoneBook = phoneBook;
        this.contactsView = contactsView;
    }

    @Override
    public void doAction() {
        System.out.print("Введите имя или начальные буквы имени: ");
        String nameLetters = scanner.nextLine();
        contactsView.showAllContacts(phoneBook.findByName(nameLetters));
    }

    @Override
    public String getName() {
        return "Найти контакт";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
