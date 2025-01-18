package br.com.codemathsz.stage.services;

import br.com.codemathsz.stage.models.Roles;
import br.com.codemathsz.stage.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    private RolesRepository repository;

    public Roles create(Roles role){
        var newRole = Roles.builder()
                .active(role.getActive() == null)
                .name(role.getName().toUpperCase())
                .build();
        return this.repository.save(newRole);
    }
}