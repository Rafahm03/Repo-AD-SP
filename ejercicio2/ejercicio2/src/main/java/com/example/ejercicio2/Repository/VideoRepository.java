package com.example.ejercicio2.Repository;

import com.example.ejercicio2.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
