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
        Producto producto1 = new Producto(1L, "Producto A", "Descripción del Producto A");
        Producto producto2 = new Producto(2L, "Producto B", "Descripción del Producto B");

        productoRepository.save(producto1);
        productoRepository.save(producto2);

        Monitor monitor1 = new Monitor(producto1.getId(), "Monitor X", "Monitor de alta calidad", "LCD", "Modelo 2025");
        Monitor monitor2 = new Monitor(producto2.getId(), "Monitor Y", "Monitor gaming", "OLED", "Modelo PRO");

        monitorRepository.save(monitor1);
        monitorRepository.save(monitor2);

        System.out.println("Mostramos objetos");
        productoRepository.findAll().forEach(System.out::println);
        monitorRepository.findAll().forEach(System.out::println);

        //Cargamos datos de prueba para la herencia Joined

        Persona persona1 = new Persona(3L, "Luismi", " López Magaña");
        Persona persona2 = new Persona(4L, "Ángel", "Naranjo Martinez");

        personaRepository.save(persona1);
        personaRepository.save(persona2);

        Profesor profesor1 = new Profesor(persona1.getId(), persona1.getNombre(), persona1.getApellido(), "Acceso a datos", "DAM");
        Profesor profesor2 = new Profesor(persona2.getId(), persona2.getNombre(), persona2.getApellido(), "Programación", "DAM");

        profesorRepository.save(profesor1);
        profesorRepository.save(profesor2);

        System.out.println("Mostramos objetos");
        personaRepository.findAll().forEach(System.out::println);
        profesorRepository.findAll().forEach(System.out::println);

        //Cargamos datos de prueba para la herencia Single Table

        Usuario usuario1 = new Usuario(5L, "Rafa Hernández Meléndez", "Rafahm03");
        Usuario usuario2 = new Usuario(6L, "Carlos Ruiz López", "TuCarlitosSevillista04");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        Admin admin1 = new Admin(usuario1.getId(), usuario1.getFullName(), usuario2.getUsername());
        Cliente cliente1 = new Cliente(usuario2.getId(), usuario2.getFullName(), usuario2.getUsername(), "+34 738234234");

        adminRepository.save(admin1);
        clienteRepository.save(cliente1);

        System.out.println("Mostramos objetos");
        usuarioRepository.findAll().forEach(System.out::println);
        adminRepository.findAll().forEach(System.out::println);
        clienteRepository.findAll().forEach(System.out::println);

    }
}

