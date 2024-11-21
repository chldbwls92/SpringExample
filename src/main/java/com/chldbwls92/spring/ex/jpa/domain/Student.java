package com.chldbwls92.spring.ex.jpa.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder(toBuilder=true)
// 기본 생성자 추가
@NoArgsConstructor
//원래 생성자 만들려면 다 나열해야 됐는데 allargsContructor 이거만 넣으면 다 나열됨
@AllArgsConstructor
//jpa를 설정해놨기 때문에 getter setter annotation만 넣으면 됨
@Getter
// 배틱으로 묶어서 정확한 테이블 이름 명시해줘야됨
@Table(name="`new_student`")
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	// 스네이크가 아닌 카멜로 되어있는 애들을 다 column으로 직접 엮어줘야돼
	@Column(name="phoneNumber")
	private String phoneNumber;
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@Column(name="createdAt")
	// insert 할 때 알아서 채워줌
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	
	
}
