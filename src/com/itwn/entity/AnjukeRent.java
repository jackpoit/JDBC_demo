package com.itwn.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class AnjukeRent implements Serializable {
	private static final long serialVersionUID = -8599481742930360952L;
	private Integer id;
	private String zone;
	private String trainLine;
	private BigDecimal rentMoney;
	private String room;
	private String rentType;
	private String layout;
	private String direction;

	public AnjukeRent() {
	}

	public AnjukeRent(Integer id, String zone, String trainLine, BigDecimal rentMoney, String room, String rentType, String layout, String direction) {
		this.id = id;
		this.zone = zone;
		this.trainLine = trainLine;
		this.rentMoney = rentMoney;
		this.room = room;
		this.rentType = rentType;
		this.layout = layout;
		this.direction = direction;
	}

	public AnjukeRent(String zone, String trainLine, BigDecimal rentMoney, String room, String rentType, String layout, String direction) {
		this.zone = zone;
		this.trainLine = trainLine;
		this.rentMoney = rentMoney;
		this.room = room;
		this.rentType = rentType;
		this.layout = layout;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "AnjukeRent{" +
				"id=" + id +
				", zone='" + zone + '\'' +
				", trainLine='" + trainLine + '\'' +
				", rentMoney=" + rentMoney +
				", room='" + room + '\'' +
				", rentType='" + rentType + '\'' +
				", layout='" + layout + '\'' +
				", direction='" + direction + '\'' +
				'}'+"\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTrainLine() {
		return trainLine;
	}

	public void setTrainLine(String trainLine) {
		this.trainLine = trainLine;
	}

	public BigDecimal getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(BigDecimal rentMoney) {
		this.rentMoney = rentMoney;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
