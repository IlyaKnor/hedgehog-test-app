package com.knor.profileapp.model.converter;

import com.knor.profileapp.model.Profile;
import com.knor.profileapp.model.request.CreateProfileRequest;
import org.springframework.stereotype.Component;

@Component
public class ProfileRequestConverter {
    public Profile toProfile(CreateProfileRequest createProfileRequest) {
        return new Profile(createProfileRequest.getName(), createProfileRequest.getSurname());
    }
}
