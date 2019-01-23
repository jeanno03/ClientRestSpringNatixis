package myEntities;

public class MyGrant {
	
	private Long id;
	private String name;
	private Long theId;
	
	public MyGrant() {
		super();
	}

	public MyGrant(Long id, String name, Long theId) {
		super();
		this.id = id;
		this.name = name;
		this.theId = theId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTheId() {
		return theId;
	}

	public void setTheId(Long theId) {
		this.theId = theId;
	}

	@Override
	public String toString() {
		return "MyGrant [id=" + id + ", name=" + name + ", theId=" + theId + "]";
	}
	
	

}
