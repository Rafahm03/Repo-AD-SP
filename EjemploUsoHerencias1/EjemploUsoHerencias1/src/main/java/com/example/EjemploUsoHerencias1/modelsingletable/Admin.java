package com.example.EjemploUsoHerencias1.modelsingletable;

import jakarta.persistence.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@ToString
public class Admin extends Usuario{


}
