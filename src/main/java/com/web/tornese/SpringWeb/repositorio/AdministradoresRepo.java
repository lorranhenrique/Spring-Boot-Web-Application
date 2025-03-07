package com.web.tornese.SpringWeb.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.tornese.SpringWeb.models.Administrador;

//Classe de serviço
@Repository
public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    
}
