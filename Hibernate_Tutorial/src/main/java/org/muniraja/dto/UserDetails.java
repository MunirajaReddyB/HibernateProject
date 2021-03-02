package org.muniraja.dto;

import javax.persistence.*;
import java.util.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

//@Entity annotation tells to the hibernate this the type of object which needs to be persist.
//@id define this particular property is the primary key for the table
//@Column tells to the hibernate use this name as column name instead of property name
//@Transient annotation tells to hibernate this particular property is not mandatory
//@GeneratedValue is for generating PK of the table automatically.

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "USER_ID")
    private int userId;
    @Column (name = "USER_NAME")
    private String userName;
/*    @Embedded
    private Address address;*/

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS",joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(name="increment-gen",strategy = "increment")
    @CollectionId(columns = {@Column(name="ADDRESS_ID")}, type = @Type(type="long"), generator ="increment-gen" )
    private List<Address> listOfAddress = new ArrayList();
    public List<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(List<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

}
