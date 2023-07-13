
package com.projeto.SpringBootMongo.repositorio;

import com.projeto.SpringBootMongo.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

    
    
}
