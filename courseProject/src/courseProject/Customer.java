package courseProject;

public class Customer {
    private String customerId;
    private String customerSSN;
    private String lastName;
    private String firstName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    // Setters
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }


    public String toString() {//confirm with professor if all titles should be across the top or if should be aligned this way
        return "Customer ID: " + customerId  + "\n" +
               "SSN: " + customerSSN + "\n" +
               "Name: " + firstName + " " + lastName + "\n" +
               "Address: " + street + ", " + city + ", " + state + " " + zip + "\n" +
               "Phone: " + phone + "\n";
    }
}
