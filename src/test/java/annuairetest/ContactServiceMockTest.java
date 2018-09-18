package annuairetest;


import java.util.Optional;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import annuaire.Contact;
import annuaire.ContactDuplicateException;
import annuaire.ContactNotExistExexption;
import annuaire.ContactService;
import annuaire.IContactDao;

public class ContactServiceMockTest extends EasyMockSupport{
	
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDao contactDao;
	
	@Test(expected = ContactDuplicateException.class)
	public void testAddContact() throws ContactDuplicateException {
		Contact contact = new Contact();
		//1 - Enregistreent des comportement des mocks
		EasyMock.expect(contactDao.findByName("VousMettezLaValeurQueVousVoulez"))
		.andReturn(new Contact());
		
		//2 - Fin d'enregistrement
		replayAll();
		
		//3 - Test
		service.add("VousMettezLaValeurQueVousVoulez");
	}
	
	
	@Test(expected = ContactNotExistExexption.class)
	public void testSupContact() throws ContactNotExistExexption, ContactDuplicateException {
		Contact contact = new Contact();
		contact.setName("VousMettezLaValeurQueVousVoulez");
		//1 - Enregistreent des comportement des mocks
		EasyMock.expect(contactDao.findByName("VousMettezLaValeurQueVousVoulez"))
		.andReturn(null);
		
		//2 - Fin d'enregistrement
		replayAll();
		
				
		//3 - Test
		service.sup("VousMettezLaValeurQueVousVoulez");
	}

}
