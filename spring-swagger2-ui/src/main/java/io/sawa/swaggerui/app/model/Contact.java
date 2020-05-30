package io.sawa.swaggerui.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This object contains all the fields for the contact details")
public class Contact {
    @ApiModelProperty(value = "Id of the contact")
    private String id;

    @ApiModelProperty(value = "Name of the contact")
    private String name;

    @ApiModelProperty(value = "Phone number of the contact")
    private String phoneNumber;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

}
