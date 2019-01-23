package myEntities;

import java.util.List;

public class MyUser {
	
	private Long id;
	private Long theId;
	private String email;
	private String login;
	private String firstName;
	private String lastName;
	private List<MyGrant> myGrants;


	public MyUser() {
		super();
	}

	public MyUser(String email, String login, String firstName, String lastName) {
		this();
		this.email = email;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTheId() {
		return theId;
	}

	public void setTheId(Long theId) {
		this.theId = theId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public List<MyGrant> getMyGrants() {
		return myGrants;
	}

	public void setMyGrants(List<MyGrant> myGrants) {
		this.myGrants = myGrants;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", theId=" + theId + ", email=" + email + ", login=" + login + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}



}
