package com.knor.profileapp.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProfileRequest {
    private String name;
    private String surname;
}
