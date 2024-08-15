package cl.praxis.ReportesInmobiliaria.controller;

import cl.praxis.ReportesInmobiliaria.model.entities.Project;
import cl.praxis.ReportesInmobiliaria.model.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProjectRestController {

    private final ProjectService service;

    public ProjectRestController(ProjectService service) {
        this.service = service;
    }

    private HttpStatus status = HttpStatus.OK;

    @GetMapping
    public ResponseEntity<List<Project>> findAll(){
        List<Project> projects = service.findAll();
        if(projects == null || projects.isEmpty()){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(projects, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findOne(@PathVariable("id") Long id){
        Project project = service.findOne(id);

        if (project == null) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(project, status);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project){
        Project createdProject = service.create(project);

        if (createdProject == null){
            status = HttpStatus.CONFLICT;
        } else {
            status = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(createdProject, status);
    }

    @PutMapping
    public ResponseEntity<Project> update(@RequestBody Project p){
        Project project = service.update(p);
        if(project == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(project, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean delete = service.delete(id);

        if(delete){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
