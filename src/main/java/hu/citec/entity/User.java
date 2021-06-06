package hu.citec.entity;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private boolean activated;
	private boolean blocked;
	
	public User() {
	}
	
	public User(int id, String username, String password, String fullName, String email, boolean activated,
			boolean blocked) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.activated = activated;
		this.blocked = blocked;
	}
	
	public User(int id, String username, String password, String fullName, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", activated=");
		builder.append(activated);
		builder.append(", blocked=");
		builder.append(blocked);
		builder.append("]");
		return builder.toString();
	}
}
