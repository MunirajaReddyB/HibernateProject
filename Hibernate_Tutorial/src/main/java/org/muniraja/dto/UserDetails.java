package org.muniraja.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

//@Entity annotation tells to the hibernate this the type of object which needs to be persist.
//@id define this particular property is the primary key for the table
//@Column tells to the hibernate use this name as column name instead of property name
//@Transient annotation tells to hibernate this particular property is not mandatory
@Entity (name = "USER_DETAILS")
public class UserDetails {

    @Id
    @Column (name = "USER_ID")
    private int userId;
    @Column (name = "USER_NAME")
    private String userName;
    //@Transient
    private String vehicletype;

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

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

}
