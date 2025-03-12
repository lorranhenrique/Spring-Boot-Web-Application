package com.web.tornese.SpringWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.tornese.SpringWeb.models.Administrador;

//Classe de serviço
@Repository
public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN true ELSE false END from administradores where id = :id", nativeQuery = true)
    public boolean exists(int id);

    @Query(value="SELECT * FROM administradores WHERE email = :email AND senha = :senha", nativeQuery = true)
    public Administrador login(String email, String senha);
}