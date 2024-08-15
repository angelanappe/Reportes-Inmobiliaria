package cl.praxis.ReportesInmobiliaria.model.service;

import cl.praxis.ReportesInmobiliaria.model.entities.Role;
import cl.praxis.ReportesInmobiliaria.model.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Role r) {
        Role result = repository.save(r);
        return result != null;
    }

    @Override
    public boolean update(Role r) {
        Role result = repository.save(r);
        return result != null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = repository.existsById(id);
        if (exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
