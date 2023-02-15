package spring.project.da.global.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;
import spring.project.da.domain.auth.service.CustomOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity	// Spring Security 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	   protected void configure(HttpSecurity http) throws Exception {
	       http
	               .csrf().disable()
	               .headers().frameOptions().disable() // h2-console화면을 사용하기 위해 해당 옵션을 disable 한다.
	               .and()
	                   .authorizeRequests()    // URL별 권한 관리를 설정하는 옵션의 시작점이다.
	                   .antMatchers("/", "/css/**", "/images/**",
	                           "/js/**", "/h2-console/**").permitAll()	// 권한 관리 대상을 지정하는 옵션이다.
	                   //.antMatchers("/api/v1/**").hasRole(Role.USER.name())
	                   .anyRequest().authenticated()	// 설정된 값들 이외의 나머지 URL은 인증된 사용자에게만 허용
	               .and()
	                   .logout()	// 로그아웃 기능에 대한 여러 설정의 진입점
	                       .logoutSuccessUrl("/")	// 로그아웃 성공시 / 주소로 이동
	               .and()
	                   .oauth2Login()	// OAuth2 로그인 기능에 대한 여러 설정의 진입점
	                       .userInfoEndpoint()	// OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
	                           .userService(customOAuth2UserService);	// 소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스 구현체 등록
	   }
}
