package pl.pawelprzystarz.crm.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    @Column(name = "realisation_time")
    private int realisationTime;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
                                                   CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "customer_transaction", joinColumns = @JoinColumn(name = "transaction_id"),
                inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    public Transaction() {
    }

    public Transaction(String name, double price, int realisationTime) {
        this.name = name;
        this.price = price;
        this.realisationTime = realisationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRealisationTime() {
        return realisationTime;
    }

    public void setRealisationTime(int realisationTime) {
        this.realisationTime = realisationTime;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", realisationTime=" + realisationTime +
                ", customers=" + customers +
                '}';
    }
}
