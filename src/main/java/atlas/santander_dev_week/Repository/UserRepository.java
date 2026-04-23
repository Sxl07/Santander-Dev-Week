package atlas.santander_dev_week.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import atlas.santander_dev_week.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}
