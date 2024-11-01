package com.chldbwls92.spring.ex.database.domain;

import java.time.LocalDateTime;

// Domain
// Entity Class
// 대상 테이블의 컬럼 이름과 정확히 일치하는 멤버변수를 가진 클래스
// 한행의 정보를 모두 저장하는 객체를 만들기 위한 목적
public class UsedGoods {
	
	// 컬럼 이름과 정확히 일치, type 일치
	private int id;
	private int sellerId;
	private String title;
	private int price;
	private String description;
	private String image;
	private LocalDateTime careatedAt;
	private LocalDateTime updatedAt;
	
	
	
	// get set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCareatedAt() {
		return careatedAt;
	}
	public void setCareatedAt(LocalDateTime careatedAt) {
		this.careatedAt = careatedAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
	
}
