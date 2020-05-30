package io.sawa.swaggerui.app.resource;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sawa.swaggerui.app.model.Contact;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
@Api(tags = {
	"Provide the CRUD operations for contact address book" }, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AddressResource {
    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/")
    @ApiOperation(value = "Get all addresses from address book", notes = "returns list of contact", response = Contact.class)
    public Collection<Contact> getAllAddresses() {
	return contacts.values();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get single address", notes = "provide the id of the contact", response = Contact.class)
    public Contact getAddress(
	    @ApiParam(value = "id value for retriving contact", required = true) @PathVariable(name = "id") String id) {
	return contacts.get(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create contact address", notes = "provide the all the details of the contact", response = Contact.class)
    public Contact createAddress(@ApiParam(value = "provide json object of contact") @RequestBody Contact contact) {
	contacts.put(contact.getId(), contact);
	return contact;
    }

}
