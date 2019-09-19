package com.virtusa.vtaf.Model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "mdm", name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer deviceId;
	private Integer UserId;
	private String reservationType;
	private String reservationMadeBy;
	private String reservationMadeFor;
	private ZonedDateTime createTime;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(ZonedDateTime createTime) {
		this.createTime = createTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getReservationMadeBy() {
		return reservationMadeBy;
	}

	public void setReservationMadeBy(String reservationMadeBy) {
		this.reservationMadeBy = reservationMadeBy;
	}

	public String getReservationMadeFor() {
		return reservationMadeFor;
	}

	public void setReservationMadeFor(String reservationMadeFor) {
		this.reservationMadeFor = reservationMadeFor;
	}

}
