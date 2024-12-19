package com.example.proyecto_places;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Place {

    private Long id;
    private String name;
    private String address;
    private String coords;
    private String desc;

    @Setter(AccessLevel.NONE)
    @Builder.Default
    private List<String> tags = new ArrayList<>();
    private String image;

    //Metodo para agregar una lista de tags a un place
    public void addTag(String tag) {
        if(tags.stream().noneMatch(t ->t.equalsIgnoreCase(tag))){
            tags.add(tag);
        }
    }

    //Metodo para remover un tag
    public void removeTag(String tag) {
        tags.removeIf(t -> t.equalsIgnoreCase(tag));
    }

}
