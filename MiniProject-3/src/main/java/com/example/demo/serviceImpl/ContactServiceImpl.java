package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	
	
	private ContactRepository contactRepo;
	
	
	/*CREATE CONSTRUCTOR emdukamte serviceclass loki repository object inject depend avutahdi kada oka object imko object meda amdukani ok
	
	amte manually ga inject chesthunnam ala kakumda pinacraete chesam kada variable lada contactRepository dani meda @Autowired pedithe kimda constrcutor create cheyaballadu kani sir manually ga chupisthunnadu ok */
	 public ContactServiceImpl(ContactRepository contactRepo) {
	
		 this.contactRepo=contactRepo;
	}
	
	//embded database vadam demtlo [http://localhost:9010/h2-console]
	
	
	// http://localhost:9010/loadForm     save avvataniki eyokka URL ok.
	

	
	@Override
	public Contact getContactById(Integer contactId) {
		
	Optional<Contact> findById=	contactRepo.findById(contactId);
	
	if(findById.isPresent())
	{
		return findById.get(); // recorde vumte ayokka record ni get chesi return cheyali user ki ok.
	}
		return null;   // oka vela record lakapothe it return null ok.
	}
	
	
	/*sir kimda method vachhi getallrecords amdulo code ela marchamu amte evari record active
	 * 
	 * lo vumtado [Y] ayokka record matrame dispplay avvali user ki jsp lo amdukani filervadam [example.of] anedi filter 1.8 new
	 * 
	 * feature adi [Y] vunna record varaku filter chesthadi AMTE delet ani kodithe database
	 * 
	 * lo ayokka record [inactive]] avuthadi [N] kani DELETE AVVADU application lo records database
	 * 
	 * numchi load avuthayee kada so ayokka application lo delete ayenattlu chupisthadi kani database
	 * 
	 * lo delete kadu database open chesthe record vumtadi kani inactive lo. amduke application lo
	 * 
	 * chudataniki delete chesthe record vumdadu delete cheyaga megilina records chudali kada
	 * 
	 * application lo [viewall] contacts kottinappudu database numchi jsp ki vasthayee or two
	 * 
	 * records vumte delete ani kottagane oka record poye one meguluthadi amte kimda method ne
	 * 
	 * retrive chesthadi kani ala RETRIVE CHESETAPPUDU [Y] active records matrame ravali amte
	 * 
	 * neku record delete ayenattu chupistahdi amduke filter vadam database lo matram delete kadu [N] INACTIVE LO POTHADI . INACTIVE LO SAVE AVVU ANI AKKADA CODE RASAM DATABASE LO. DATABASE OPEN CHESTHE
	 * 
	 * RECORD VUMTADI INACTIVE MODE. application lo matram record delete data load chestham kada delete ayenattlu vumatdi
	 * 
	 * ala delete ayenattlu database lo vunna delte chesthe application lo delete ayenattlu vumdataniki
	 * 
	 * filter chesam based on[y] ACTIVE MODE. save chesthe [Y] active record. delet chesthe database lo
	 * 
	 * ayokka rceord ki [N] inactive vasthadi. amte delete ani user drustilo application lo vumdadu
	 * 
	 * because filter based on [Y]. manaki eppudina kavalasinappudu record thechhukovachhu ok.
	 */
	@Override
	public List<Contact> getAllContacts() {
		
		Contact contactFilter=new Contact();
		
		contactFilter.setActiveSw("Y");
		
	Example<Contact> example=Example.of(contactFilter);
		
		List<Contact> contacts=	contactRepo.findAll(example);
		
		return contacts;
	}

	
	/*RECORD SAVE AVUTHUNNAPPDALLA RECORD ACTIVE [Y] RUPAM LO VUMDALI OK
	 * 
	 *  ACTIVE AVVALI BECAUSE SOFT DELET KOSAM. ACTIVE record AVILABLE GA VUMDI USER APPLICATION LO USER VADE APPLICATION LO OK*/
	@Override
	public boolean saveContact(Contact contact) {
		
		
	contact.setActiveSw("Y"); // save ayye record ni active swicth lo vumcham save ayye prathi record active swicth.amte AYOKAK RECORD ACTIVE LO VUMDI ANI
		Contact savedEntity=	contactRepo.save(contact);
		
		if(savedEntity!=null && savedEntity.getContactId()!=null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		
		//HARD DELET APPROACH amte normal ga manam rase code edi general ga ok.
	/*boolean existbyId=	contactRepo.existsById(contactId);
	
	
	if(existbyId)
	{
		contactRepo.deleteById(contactId); //harddelete lo direct ga call method and delete that record perminent ok.
		
		return true;
	}
	
		return false;
	}*/

		
		//PINA LOGIC CHANGE FOR SOFT DELETEKOSAM PIDI HARD DELETE PIDI CODE OK
		
		//SOFT DELETE APPROACH KIMDA CODE
	Optional<Contact> findById=contactRepo.findById(contactId);
	
	
	if(findById.isPresent())
	{
		Contact contact=	findById.get(); //record vumte get cheyye kimda return to jsp or controller edi serviceimpl class kabatti
	
		/*KIMDA [N] amte record inactive lo vumdi ani delet chestham kada ayokka record inactive loki pothadi pina find by id rasam
		
		adi vasthadi ayokka id delete kada so ayokka id find avvagane inactive loki vellipothadi ayokka record*/
		
	        contact.setActiveSw("N"); // bydefault [no] ani ichham
	        // ayokka id amte ayokka record ni manam [soft delte] lo vumcham anuko pina line adi. get ayye record based on id manam soft delete lo vumcham ok
	        contactRepo.save(contact);
	        
	        
	        return true;  //we dont get any exception return true
	}
	
	return false; // edina error vasthe return false ok.
		
	}
}
