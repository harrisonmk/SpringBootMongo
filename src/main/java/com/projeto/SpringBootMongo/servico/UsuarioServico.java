package com.projeto.SpringBootMongo.servico;

import com.projeto.SpringBootMongo.dto.UsuarioDto;
import com.projeto.SpringBootMongo.modelo.Usuario;
import com.projeto.SpringBootMongo.repositorio.UsuarioRepositorio;
import com.projeto.SpringBootMongo.servico.excecao.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    
    
    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    
    
    public Usuario findById(String id) {
        Optional<Usuario> obj = usuarioRepositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
         
    
    


	public Usuario insert(Usuario obj) {
		return usuarioRepositorio.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		usuarioRepositorio.deleteById(id);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return usuarioRepositorio.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public Usuario fromDTO(UsuarioDto objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}

}
