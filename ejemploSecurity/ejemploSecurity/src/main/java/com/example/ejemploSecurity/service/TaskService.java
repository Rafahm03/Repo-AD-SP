package com.example.ejemploSecurity.service;

import com.example.ejemploSecurity.modal.Task;
import com.example.ejemploSecurity.repo.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getall(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){

        Optional<Task> taskOp = taskRepository.findById(id);
        return taskOp.get();
    }

    public Task save(Long id){
        Optional<Task> taskOp = taskRepository.findById(id);

        Task task = taskOp.get();
        task.getTitle();
        return taskRepository.save(taskOp.get());
    }
}
