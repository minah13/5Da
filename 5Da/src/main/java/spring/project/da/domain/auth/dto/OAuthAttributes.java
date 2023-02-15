package spring.project.da.domain.auth.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String image;
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String image) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.image = image;
	}
	
	public static OAuthAttributes of(String registrationId,
									String userNameAttributeName,
									Map<String,Object> attributes) {
		return ofGoogle(userNameAttributeName,attributes);
	}
	
	private static OAuthAttributes ofGoogle(String userNameAttributeName,
											Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.image((String) attributes.get("image"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	public User toEntity() {
		return User.builder()
				.name(name)
				.email(email)
				.image(image)
				.role(Role.GUEST)
				.build();
	}
}
