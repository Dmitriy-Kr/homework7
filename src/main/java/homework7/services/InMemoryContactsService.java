package homework7.services;

import homework7.utils.ListUtils;
import java.util.Locale;

public class InMemoryContactsService implements ContactsService {
    private ContactsList contactsList;

    public InMemoryContactsService() {
        contactsList = new ContactsList();
    }

    @Override
    public ContactsList getAll() {
        return contactsList;
    }

    public Contact get(int index) {
        return contactsList.get(index);
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    @Override
    public void add(Contact c) {
        contactsList.add(c);
    }

    public int size() {
        return contactsList.size();
    }

    @Override
    public ContactsList findByName(String nameLetters) {
        return ListUtils.filter(contactsList, x -> x.getName().toLowerCase(Locale.ROOT)
                .startsWith(nameLetters.toLowerCase(Locale.ROOT)));
    }
}