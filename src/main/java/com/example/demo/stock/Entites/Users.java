package com.example.demo.stock.Entites;

import javax.persistence.*;

@Entity
@Table
public class Users {
    private static final long serialVersionUID = -8838091838951636964L;
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "users_sequence"
            )
    @Column(

            updatable = false
    )

    private long id;
    @Column(

            nullable = false
    )
    private String firstName;
    private String lastName;
    @OneToOne( cascade = CascadeType.PERSIST)
      private Warehouse warehouse;

    public Users(String firstName, String lastName, Warehouse warehouse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.warehouse = warehouse;
    }

    public Users() {
    }

    public Users(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id_user) {
        this.id = id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
