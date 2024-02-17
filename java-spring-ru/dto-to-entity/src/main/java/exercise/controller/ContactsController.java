package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO newContact) {
        Contact contact = toEntity(newContact);
        contactRepository.save(contact);
        return toDTO(contact);
    }

    private ContactDTO toDTO(Contact savedContact) {
        var result = new ContactDTO();
        result.setId(savedContact.getId());
        result.setFirstName(savedContact.getFirstName());
        result.setLastName(savedContact.getLastName());
        result.setPhone(savedContact.getPhone());
        result.setCreatedAt(savedContact.getCreatedAt());
        result.setUpdatedAt(savedContact.getCreatedAt());
        return result;
    }

    private Contact toEntity(ContactCreateDTO newContact) {
        var contact = new Contact();
        contact.setFirstName(newContact.getFirstName());
        contact.setLastName(newContact.getLastName());
        contact.setPhone(newContact.getPhone());
        return contact;
    }
    // END
}
