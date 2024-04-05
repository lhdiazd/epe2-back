package cl.epe2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.epe2.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String userName);
}
