package spring.project.da.domain.auth.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable{
	String name;
	String email;
	String image;
	
	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.image = user.getImage();
	}
}
