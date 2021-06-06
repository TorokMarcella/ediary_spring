package hu.citec.entity;

import java.sql.Date;

public class SubjectGrade {
	
	private int id;
	private int subjectId;
	private int userId;
	private Date date;
	private String description;
	private int teacherId;
	private int grade;
	
	public SubjectGrade() {
	}
	
	public SubjectGrade(int id, int subjectId, int userId, Date date, String description, int teacherId, int grade) {
		this.id = id;
		this.subjectId = subjectId;
		this.userId = userId;
		this.date = date;
		this.description = description;
		this.teacherId = teacherId;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubjectGrade [id=");
		builder.append(id);
		builder.append(", subjectId=");
		builder.append(subjectId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", date=");
		builder.append(date);
		builder.append(", description=");
		builder.append(description);
		builder.append(", teacherId=");
		builder.append(teacherId);
		builder.append(", grade=");
		builder.append(grade);
		builder.append("]");
		return builder.toString();
	}
}
