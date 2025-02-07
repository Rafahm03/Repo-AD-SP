package com.example.ejemploSecurity.repo;

import com.example.ejemploSecurity.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
