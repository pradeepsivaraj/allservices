package com.tastyfood.order.my.food.usermanagementservice.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.NaturalId;
 
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User implements Serializable{
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotBlank
    @Size(min=3, max = 50)
    private String name;
 
    @NotBlank
    @Size(min=3, max = 50)
    private String username;
 
    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
 
    @NotBlank
    @Size(min=6, max = 100)
    private String password;
    
    @NotBlank
    @Size(max = 250)
    private String address;
    
    @NotBlank
    @Size(max = 25)
    private String city;
    
    @NotBlank
    @Size(max = 25)
    private String state;
    
    private long phone;
 
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
 
    public User() {}
 
    public User(String name, String username, String email, String password, String address,
    		String city, String state, long phone) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
    }
 
    

	public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public Set<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
    
    
}