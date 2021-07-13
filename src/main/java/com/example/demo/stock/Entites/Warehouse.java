package com.example.demo.stock.Entites;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Warehouse {
    private static final long serialVersionUID = -823804791978092398L;
@Id
@SequenceGenerator(
        name="stock_sequence",
        sequenceName = "stock_sequence",
        allocationSize = 1
)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )

    private  Long id;
    private String address;
    @OneToOne (cascade = CascadeType.PERSIST)
     private  Users employee;

    @ManyToMany
    private List<Article> lesArticles;


    public Warehouse(String address) {
        this.address = address;
    }

    public Warehouse(String address, Users employee) {

        this.address = address;
        this.employee= employee;

    }

     public Warehouse() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   public Users getEmployee() {
        return employee;
    }

    public void setEmployee(Users lesemploies) {
        this.employee=lesemploies;
    }
}
