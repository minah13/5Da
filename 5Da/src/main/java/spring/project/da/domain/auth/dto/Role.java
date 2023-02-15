package spring.project.da.domain.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	
	// 스프링 시큐리티에서는 권한 코드에 항상 ROLE_이 있어야만 한다.
	
	GUEST("ROLE_GUEST","손님"),		// name(key,title)
	USER("ROLE_USER","일반 사용자");
	
	private final String key;
	private final String title;
	
}
