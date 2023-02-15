package spring.project.da.domain.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.project.da.domain.auth.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {		// User 테이블에서 JPA 적용
	
	// 기본 메소드
	// findAll() : 전체 목록 조회
	// fidnById(id) : 기본키 레코드 조회
	// save(user) : 테이블에 저장
	// saveAll(userList) : 
	// delete(user)
	// deleteAll(userList)
	// count()
	// exists(id)
	// flush()
	
	// 이미 생성된 사용자인지 처음 가입한 사용자인지 판단하기 위한 메소드
	Optional<User> findByEmail(String email);
}
