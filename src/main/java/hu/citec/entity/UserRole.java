package hu.citec.entity;

public class UserRole {
	
	private int id;
	private int userId;
	private int roleId;
	
	public UserRole(int id, int userId, int roleId) {
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRoles [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append("]");
		return builder.toString();
	}
}
