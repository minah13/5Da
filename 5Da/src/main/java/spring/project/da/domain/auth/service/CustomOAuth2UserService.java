package spring.project.da.domain.auth.service;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.project.da.domain.auth.dto.OAuthAttributes;
import spring.project.da.domain.auth.dto.SessionUser;
import spring.project.da.domain.auth.dto.User;
import spring.project.da.domain.auth.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	private final UserRepository userRepository;
	private final HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();	//현재 로그인 진행중인 서비스를 구분하는 코드(구글인지 네이버인지)
		String userNameAttributeName = userRequest.getClientRegistration()		// OAuth2 로그인 진행시 기본키가 되는 필드값(구글만 사용) 
				.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
		
		OAuthAttributes attributes = OAuthAttributes.		// OAuth2UserService를 통해 가져온 OAuth2USer의 attribute를 저장
				of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		
		User user = saveOrUpdate(attributes);
		httpSession.setAttribute("user", new SessionUser(user));	// 세션에 저장
		
		return new DefaultOAuth2User(		// DefaultOAuth2User(권한,attributes,attributeKey)
				Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
				attributes.getAttributes(),
				attributes.getNameAttributeKey());
	}
	
	private User saveOrUpdate(OAuthAttributes attributes) {	// 사용자 정보가 업데이트 되었을 때를 대비
		User user = userRepository.findByEmail(attributes.getEmail())		// 해당 이메일을 찾기
	            .map(entity -> entity.update(attributes.getName(),attributes.getImage()))	// 이메일이 있다면 Name,Image 정보 업데이트
	            .orElse(attributes.toEntity());		// 

	    return userRepository.save(user);
	}
}
