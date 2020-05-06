package com.multai.vip.bean;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image_model")
public class ImageModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "itemId")
	private int itemId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

	@Column
	private int restaurantId;

	public ImageModel() {
	}

	public ImageModel(int itemId, String name, String type, byte[] picByte) {
		this.itemId = itemId;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	public ImageModel(String name, String type, byte[] picByte) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return this.picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "ImageModel [id=" + id + ", itemId=" + itemId + ", name=" + name + ", type=" + type + ", picByte="
				+ Arrays.toString(picByte) + ", restaurantId=" + restaurantId + "]";
	}

}
