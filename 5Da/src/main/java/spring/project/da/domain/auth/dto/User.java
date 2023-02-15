package spring.project.da.domain.auth.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "user_pwd")
	@JsonIgnore
	private String pwd;
	
	@Column(name="user_name",nullable=false)
	private String name;
	
	@Column(name="user_email",nullable=false)
	private String email;
	
	@Column(name="user_image")
	private String image;
	
	@Enumerated(EnumType.STRING)		// JPA로 데이터베이스를 저장할 때 Enum값을 어떤 형태로 저장할지 결정
	@Column(name="user_role")
	private Role role;
	
	@Builder
	public User(String name,String email, String image, Role role) {
		this.name = name;
		this.email = email;
		this.image = image;
		this.role = role;
	}
	
	public User update(String name, String image) {
		this.name = name;
		this.image = image;
		
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}
