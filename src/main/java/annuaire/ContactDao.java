package annuaire;
import java.util.List;

public class ContactDao implements IContactDao {

private List<Contact> contacts ;

/* (non-Javadoc)
 * @see annuaire.IContact#readAll()
 */
@Override
public List<Contact>readAll() {
	return contacts;
}
/* (non-Javadoc)
 * @see annuaire.IContact#findByName(java.lang.String)
 */
@Override
public 	Contact findByName(String name) {
	Contact cont = new Contact();
	for (Contact contact : contacts) {
		if (contact.getName().equals(name)) {
			cont = contact;
		}
	}
	
	
	return cont;
}
/* (non-Javadoc)
 * @see annuaire.IContact#add(annuaire.Contact)
 */
@Override
public void add(Contact contact) {
	contacts.add(contact);
}
@Override
public void sup(Contact contact) {
	contacts.remove(contact);

}
}
