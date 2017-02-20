package ro.utcluj.sd.assignment4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String password;
	 private UserType userType;
	 
	  @Column(name = "firstName", nullable = false, length = 40)
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    @Column(name = "lastName", nullable = false, length = 40)
	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    @Column(name = "userType", nullable = true)
	    public UserType getUserType() {
	        return userType;
	    }

	    public void setUserType(UserType userType) {
	        this.userType = userType;
	    }
	    
	    @Column(name = "password", nullable = false)
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Column(name = "email", nullable = false, unique = true)
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

}
