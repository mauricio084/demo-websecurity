package com.javeriana.demo.websecurity.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.javeriana.demo.websecurity.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

  Optional<Usuario> findByUsername(String value);
}
