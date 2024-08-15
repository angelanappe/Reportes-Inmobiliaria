package cl.praxis.ReportesInmobiliaria.model.repository;

import cl.praxis.ReportesInmobiliaria.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
