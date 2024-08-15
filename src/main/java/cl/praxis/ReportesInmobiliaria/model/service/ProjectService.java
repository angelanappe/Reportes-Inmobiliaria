package cl.praxis.ReportesInmobiliaria.model.service;

import cl.praxis.ReportesInmobiliaria.model.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findOne(Long id);
    Project create(Project p);
    Project update(Project p);
    boolean delete(Long id);
}
