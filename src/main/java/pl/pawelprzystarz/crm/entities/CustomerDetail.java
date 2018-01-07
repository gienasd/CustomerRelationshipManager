package pl.pawelprzystarz.crm.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_number")
    @Size(min = 9, max = 12, message = "Your phone number should have from 9 to 12 numbers!")
    private String phoneNumber;

    @Max(value = 60, message = "Address should not have more than 60 letters! Try to be specific!")
    private String address;

    @Pattern(regexp = "[0-9]{11}", message = "Pesel should have 11 digits")
    private String pesel;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerDetail() {
    }

    public CustomerDetail(String phoneNumber, String address, String pesel) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerDetail{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", pesel='" + pesel + '\'' +
                ", customer=" + customer +
                '}';
    }
}
