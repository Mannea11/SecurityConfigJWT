package com.inlamningsuppgift.memberdb.Entity;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName",length = 20, nullable = false)
    private String firstName;
    @Column(name = "lastName",length = 35, nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;
    @Column(name = "email",length = 50, nullable = false)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "dateOfBirth", nullable = false)
    private Date dateOfBirth;

    public Member(int id, String firstName, String lastName, Address address, String email, String phone, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Member() {

    }


    public int getMemberId() {
        return id;
    }

    public void setMemberId(int memberId) {
        this.id = memberId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBith) {
        this.dateOfBirth = dateOfBith;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}