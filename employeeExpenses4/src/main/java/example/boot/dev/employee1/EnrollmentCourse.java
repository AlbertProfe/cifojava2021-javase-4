package example.boot.dev.employee1;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table	


public class EnrollmentCourse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enrollmentDate;
	
	private String room;
	private boolean online;
	
	@ManyToOne
	@JoinColumn(name = "TEACHER_FID")
	private Employee teacher;
	//private String teacher;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date initDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finishDate;
	private String calendarCourse;
	private double fee;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_FID")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "CERTIFICATE_FID")
	private Certificate certificate;
	
	public EnrollmentCourse() {
		super();
	}
	
	public EnrollmentCourse(Date enrollmentDate, String room, boolean online, Date initDate,
			Date finishDate, String calendarCourse, double fee) {
		super();
		this.enrollmentDate = enrollmentDate;
		this.room = room;
		this.online = online;
		this.initDate = initDate;
		this.finishDate = finishDate;
		this.calendarCourse = calendarCourse;
		this.fee = fee;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public Date getInitDate() {
		return initDate;
	}
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getCalendarCourse() {
		return calendarCourse;
	}
	public void setCalendarCourse(String calendarCourse) {
		this.calendarCourse = calendarCourse;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	
	public Employee getTeacher() {
		return teacher;
	}

	public void setTeacher(Employee teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "EnrollmentCourse [id=" + id + ", enrollmentDate=" + enrollmentDate + ", room=" + room + ", online="
				+ online + ", teacher=" + teacher + ", initDate=" + initDate + ", finishDate=" + finishDate
				+ ", calendarCourse=" + calendarCourse + ", fee=" + fee + "]";
	}

}
