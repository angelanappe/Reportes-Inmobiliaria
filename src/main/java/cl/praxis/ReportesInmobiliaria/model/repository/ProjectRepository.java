package cl.praxis.ReportesInmobiliaria.model.repository;

import cl.praxis.ReportesInmobiliaria.model.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
