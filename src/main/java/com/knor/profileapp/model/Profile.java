package com.knor.profileapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Profile {
    private Long id;
    private String name;
    private String surname;

    public Profile(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
