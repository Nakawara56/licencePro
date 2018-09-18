package annuaire;
public class ContactService {
private IContactDao dao;

public void ajouterContact() {
	
}
public void add(String nom) throws ContactDuplicateException{
	
	if (!nom.equals("")&&nom.length()>2 && nom.length()<39) {
		if(dao.findByName(nom) != null){
			throw new ContactDuplicateException("Contact already exists");
		}
		
		Contact cont = new Contact();
		cont.setName(nom);
		dao.add(cont);
	}else {
		System.out.println("Le nom du contact ne remplis pas les conditions");
	}
}
public void sup(String nom) throws ContactNotExistExexption{
	if(dao.findByName(nom) == null){
		throw new ContactNotExistExexption("Contact doesn't exist");
	}
	
	Contact cont = new Contact();
	cont.setName(nom);
	dao.sup(cont);
}
}
