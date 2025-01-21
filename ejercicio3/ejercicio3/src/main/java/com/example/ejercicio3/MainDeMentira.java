package com.example.ejercicio3;

import com.example.ejercicio3.model.Bicicleta;
import com.example.ejercicio3.model.Estacion;
import com.example.ejercicio3.model.Uso;
import com.example.ejercicio3.model.Usuario;
import com.example.ejercicio3.repo.BicicletaRepository;
import com.example.ejercicio3.repo.EstacionRepository;
import com.example.ejercicio3.repo.UsoRepository;
import com.example.ejercicio3.repo.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final EstacionRepository estacionRepository;
    private final BicicletaRepository bicicletaRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsoRepository usoRepository;

    @PostConstruct
    public void run() {
        Estacion estacion = Estacion.builder()
                .numero(1)
                .nombre("Estación estación")
                .coordenadas("40.4168,-3.7038")
                .capacidad(10)
                .build();
        estacionRepository.save(estacion);

        Bicicleta bicicleta1 = Bicicleta.builder()
                .marca("Trek")
                .modelo("FX 3")
                .estado("En uso")
                .build();
        estacion.addBicicleta(bicicleta1);

        Bicicleta bicicleta2 = Bicicleta.builder()
                .marca("Specialized")
                .modelo("Sirrus")
                .estado("Disponible")
                .build();
        estacion.addBicicleta(bicicleta2);

        bicicletaRepository.saveAll(List.of(bicicleta1, bicicleta2));
        estacionRepository.save(estacion);

        Usuario usuario = Usuario.builder()
                .nombre("Rafa Hernandez")
                .numTarjeta("892376589")
                .pin(1234)
                .saldo(50.0)
                .build();
        usuarioRepository.save(usuario);

        Uso uso = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(1))
                .fechaFin(LocalDateTime.now())
                .coste(5.0)
                .build();
        usuario.addUso(uso);
        bicicleta1.addUso(uso);

        usoRepository.save(uso);

    }
}