package com.ctl.smartsignage.dto;

/**
 * @author Shivansh Bhatnagar
 */
public class RegistrationDTO {

    private Long customerId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String street;
    private String city;
    private String stateName;
    private String postalCode;
    private Long phoneId;
    private String imeiNumber;
    private String model;
    private String os;
    private String macAddress;
    private String serviceProvider;
    private String phoneNumber;
    private String phoneAccountNumber;
    private String accHolderName;
    private String accNumber;
    private String organization;
    private Long countryId;
    private String countryName;
    public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	private String token;
    private String profilePic;
    private String address;
    private String deviceType;
    private String deviceToken;

    /**
     * @return the customerId
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }



//    /**
//     * @return the accountId
//     */
//    public Long getAccountId() {
//        return accountId;
//    }
//
//    /**
//     * @param accountId the accountId to set
//     */
//    public void setAccountId(Long accountId) {
//        this.accountId = accountId;
//    }

    /**
     * @return the phoneId
     */
    public Long getPhoneId() {
        return phoneId;
    }

    /**
     * @param phoneId the phoneId to set
     */
    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    /**
     * @return the imeiNumber
     */
    public String getImeiNumber() {
        return imeiNumber;
    }

    /**
     * @param imeiNumber the imeiNumber to set
     */
    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the serviceProvider
     */
    public String getServiceProvider() {
        return serviceProvider;
    }

    /**
     * @param serviceProvider the serviceProvider to set
     */
    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    /**
     * @return the phoneAccountNumber
     */
    public String getPhoneAccountNumber() {
        return phoneAccountNumber;
    }

    /**
     * @param phoneAccountNumber the phoneAccountNumber to set
     */
    public void setPhoneAccountNumber(String phoneAccountNumber) {
        this.phoneAccountNumber = phoneAccountNumber;
    }

    /**
     * @return the accHolderName
     */
    public String getAccHolderName() {
        return accHolderName;
    }

    /**
     * @param accHolderName the accHolderName to set
     */
    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    /**
     * @return the accNumber
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * @param accNumber the accNumber to set
     */
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

  
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  

    /**
     * @return the macAddress
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * @param macAddress the macAddress to set
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    
    /**
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @return the country
     */
    public Long getCountryId() {
        return countryId;
    }

    /**
     * @param country the country to set
     */
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
    
}
