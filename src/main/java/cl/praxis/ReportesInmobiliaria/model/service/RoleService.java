package cl.praxis.ReportesInmobiliaria.model.service;

import cl.praxis.ReportesInmobiliaria.model.entities.Role;
import cl.praxis.ReportesInmobiliaria.model.entities.User;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findOne(int id);
    boolean create(Role r);
    boolean update(Role r);
    boolean delete(int id);
}
