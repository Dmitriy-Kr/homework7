package homework7.menu;

import homework7.menu.MenuAction;
import homework7.services.ContactsService;
import homework7.ui.ContactsView;

public class ReadAllContactsMenuAction implements MenuAction {
    private ContactsService phoneBook;
    private ContactsView contactsView;

    public ReadAllContactsMenuAction(ContactsService phoneBook, ContactsView contactsView) {
        this.phoneBook = phoneBook;
        this.contactsView = contactsView;
    }

    @Override
    public void doAction() {
        System.out.println("--------------------------------------------------");
        contactsView.showAllContacts(phoneBook.getAll());
        System.out.println("--------------------------------------------------");
    }

    @Override
    public String getName() {
        return "Показать все контакты";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
