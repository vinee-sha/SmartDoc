package com.ts.dto;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;
@XmlRootElement
@Entity
public class Department {
	@Id@GeneratedValue
	private int departmentId;
	private String departmentName;
	//@ManyToOne
	//@JoinColumn(name="patientId")
	//private Patient patient;
	
	//@OneToOne
	//@JoinColumn(name="doctorId")
	//private Doctor doctor;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	

}
