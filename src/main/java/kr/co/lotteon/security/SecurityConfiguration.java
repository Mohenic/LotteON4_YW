package kr.co.lotteon.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 * 날짜 : 2023.10.14
 * 이름 : 최정민
 * 내용 : security 구성 설정
 */
@Log4j2
@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {


	@Autowired
	private SecurityUserService service;

	//기술노트 [Spring] 정적 자원 리소스 경로설정
	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
				// 사이트 위변조 방지 비활성
				.csrf(CsrfConfigurer::disable) // 메서드 참조 연산자로 람다식을 간결하게 표현
				// 폼 로그인 설정
				.formLogin(config -> config.loginPage("/member/login")
						.defaultSuccessUrl("/",true)
						.failureUrl("/member/login?success=100")
						.usernameParameter("uid")
						.passwordParameter("pass"))

				// 로그아웃 설정
				.logout(config -> config
						.logoutUrl("/member/logout")
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.logoutSuccessUrl("/member/login?success=101"))

				// 자동 로그인 설정
				.rememberMe(httpSecurityRememberMeConfigurer -> httpSecurityRememberMeConfigurer
						.rememberMeParameter("auto")
						.alwaysRemember(false)
						.tokenValiditySeconds(60*60*24*30*3)
						.key("autoLogin")
						.userDetailsService(service))

				// 인가 권한 설정
				.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
						.requestMatchers("/admin/**").permitAll()
						.requestMatchers("/member/**").permitAll()
						.requestMatchers("/my/**").permitAll()
						.requestMatchers("/cs/**").permitAll()
						.requestMatchers("/product/**").permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/LotteON").permitAll()
						.requestMatchers("/policy/**").permitAll()
						.requestMatchers("/company/**").permitAll()
						.requestMatchers("/css/**", "/js/**", "/images/**", "/file/**", "/thumbs/**", "/banners/**").permitAll()
						);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}


	//기술노트 [Spring] 정적 자원 리소스 경로설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**")
				.addResourceLocations(resourceLoader.getResource("file:file/"));
		registry.addResourceHandler("/thumbs/**")
				.addResourceLocations(resourceLoader.getResource("file:thumbs/"));
		registry.addResourceHandler("/banners/**")
				.addResourceLocations(resourceLoader.getResource("file:banners/"));
	}


}