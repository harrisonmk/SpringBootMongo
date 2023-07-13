package com.projeto.SpringBootMongo.controle;

import com.projeto.SpringBootMongo.dto.UsuarioDto;
import com.projeto.SpringBootMongo.modelo.Post;
import com.projeto.SpringBootMongo.modelo.Usuario;
import com.projeto.SpringBootMongo.servico.UsuarioServico;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControle {

    @Autowired
    private UsuarioServico usuarioServico;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDto>> findAll() {
        List<Usuario> list = usuarioServico.findAll();
        List<UsuarioDto> listDto = list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto); //retorna o status 200
    }

    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDto> findById(@PathVariable String id) {
        Usuario obj = usuarioServico.findById(id);
        return ResponseEntity.ok().body(new UsuarioDto(obj)); //retorna o status 200
    }

    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UsuarioDto objDto) {
        Usuario obj = usuarioServico.fromDTO(objDto);
        obj = usuarioServico.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();  //retorna o status 201
    }

    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usuarioServico.delete(id);
        return ResponseEntity.noContent().build(); // retorna 204
    }

    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UsuarioDto objDto, @PathVariable String id) {
        Usuario obj = usuarioServico.fromDTO(objDto);
        obj.setId(id);
        obj = usuarioServico.update(obj);
        return ResponseEntity.noContent().build(); //retorna 204
    }

    
    
    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        Usuario obj = usuarioServico.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

    
    
}
