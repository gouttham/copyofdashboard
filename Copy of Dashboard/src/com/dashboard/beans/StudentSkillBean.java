package com.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_studskill")
public class StudentSkillBean {

	@Id
	private int skillAutoId;
	
	@OneToOne
	@JoinColumn(name="studentId")
	private CredentialBean studentId;
	private int skillId;
	public int getSkillAutoId() {
		return skillAutoId;
	}
	public void setSkillAutoId(int skillAutoId) {
		this.skillAutoId = skillAutoId;
	}
	
	public CredentialBean getStudentId() {
		return studentId;
	}
	public void setStudentId(CredentialBean studentId) {
		this.studentId = studentId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	
	
	
}
