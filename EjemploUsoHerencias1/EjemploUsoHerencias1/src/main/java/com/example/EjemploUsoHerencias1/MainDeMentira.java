package com.example.EjemploUsoHerencias1;

import com.example.EjemploUsoHerencias1.modeljoined.Persona;
import com.example.EjemploUsoHerencias1.modeljoined.Profesor;
import com.example.EjemploUsoHerencias1.modelmappedsuperclass.Monitor;
import com.example.EjemploUsoHerencias1.modelmappedsuperclass.Producto;
import com.example.EjemploUsoHerencias1.modelsingletable.Admin;
import com.example.EjemploUsoHerencias1.modelsingletable.Cliente;
import com.example.EjemploUsoHerencias1.modelsingletable.Usuario;
import com.example.EjemploUsoHerencias1.repojoined.PersonaRepository;
import com.example.EjemploUsoHerencias1.repojoined.ProfesorRepository;
import com.example.EjemploUsoHerencias1.repomappedsuperclass.MonitorRepository;
import com.example.EjemploUsoHerencias1.repomappedsuperclass.ProductoRepository;
import com.example.EjemploUsoHerencias1.reposingletable.AdminRepository;
import com.example.EjemploUsoHerencias1.reposingletable.ClienteRepository;
import com.example.EjemploUsoHerencias1.reposingletable.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {
    private final MonitorRepository monitorRepository;
    private final ProductoRepository productoRepository;
    private final PersonaRepository personaRepository;
    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;
    private final AdminRepository adminRepository;
    private final ClienteRepository clienteRepository;

    @PostConstruct
    public void run() {
        //Cargamos datod de prueba para la herencia MappedSuperClass
       /* Producto producto1 = Producto.builder().nombre("Producto A").descripcion("Descripción del Producto A").build();
        Producto producto2 = Producto.builder().nombre("Producto B").descripcion("Descripción del Producto B").build();**/


        Monitor monitor1 = Monitor.builder().modelo("Modelo 2025").tipoPantalla("LCD").build();
        Monitor monitor2 = Monitor.builder().modelo("Modelo PRO").tipoPantalla("OLED").build();

        productoRepository.save(monitor1);
        productoRepository.save(monitor2);

        System.out.println("Mostramos objetos");
        productoRepository.findAll().forEach(System.out::println);
        monitorRepository.findAll().forEach(System.out::println);

        //Cargamos datos de prueba para la herencia Joined

        Persona persona1 = Persona.builder().nombre("Luismi").apellido(" López Magaña").build();
        Persona persona2 = Persona.builder().nombre("Ángel").apellido("Naranjo Martinez").build();

        personaRepository.save(persona1);
        personaRepository.save(persona2);

        Profesor profesor1 = Profesor.builder().asignatura("Acceso a datos").departamento("DAM").build();
        Profesor profesor2 = Profesor.builder().asignatura("Programación").departamento("DAM").build();

        profesorRepository.save(profesor1);
        profesorRepository.save(profesor2);

        System.out.println("Mostramos objetos");
        personaRepository.findAll().forEach(System.out::println);
        profesorRepository.findAll().forEach(System.out::println);

        //Cargamos datos de prueba para la herencia Single Table

        Usuario usuario1 =Usuario.builder().fullName("Rafa Hernández Meléndez").username("Rafahm03").build();
        Usuario usuario2 =Usuario.builder().fullName("Carlos Ruiz López").username("TuCarlitosSevillista04").build();

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        Admin admin1 =  Admin.builder().build();
        Cliente cliente1 = Cliente.builder().telefono("+34 3567235786").build();

        adminRepository.save(admin1);
        clienteRepository.save(cliente1);

        System.out.println("Mostramos objetos");
        usuarioRepository.findAll().forEach(System.out::println);
        adminRepository.findAll().forEach(System.out::println);
        clienteRepository.findAll().forEach(System.out::println);

    }
}

