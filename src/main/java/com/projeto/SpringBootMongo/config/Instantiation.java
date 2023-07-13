package com.projeto.SpringBootMongo.config;

import com.projeto.SpringBootMongo.dto.AutorDto;
import com.projeto.SpringBootMongo.dto.ComentarioDto;
import com.projeto.SpringBootMongo.modelo.Post;
import com.projeto.SpringBootMongo.modelo.Usuario;
import com.projeto.SpringBootMongo.repositorio.PostRepositorio;
import com.projeto.SpringBootMongo.repositorio.UsuarioRepositorio;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private PostRepositorio postRepositorio;

    @Override
    public void run(String... args) throws Exception {
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        usuarioRepositorio.deleteAll();
        postRepositorio.deleteAll();

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

        usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
        
        

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDto(maria));

        ComentarioDto c1 = new ComentarioDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDto(alex));
        ComentarioDto c2 = new ComentarioDto("Aproveite", sdf.parse("22/03/2018"), new AutorDto(bob));
        ComentarioDto c3 = new ComentarioDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDto(alex));

        post1.getComentarios().addAll(Arrays.asList(c1, c2));
        post2.getComentarios().addAll(Arrays.asList(c3));

        postRepositorio.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        usuarioRepositorio.save(maria);

    }

}
