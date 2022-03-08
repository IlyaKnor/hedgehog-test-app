package com.knor.profileapp.service;

import com.knor.profileapp.mapper.ProfileMapper;
import com.knor.profileapp.model.Profile;
import com.knor.profileapp.model.converter.ProfileRequestConverter;
import com.knor.profileapp.model.request.CreateProfileRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileMapper profileMapper;
    private final ProfileRequestConverter profileRequestConverter;

    public Profile findById(long id) {
        return profileMapper.select(id);
    }

    public List<Profile> findByNameSegment(String segment) {
        return profileMapper.selectByNameSegment(
                "%" + segment.toLowerCase(Locale.ROOT) + "%"
        );
    }

    public Profile create(CreateProfileRequest profile) {
        Profile created = profileRequestConverter.toProfile(profile);
        profileMapper.insert(created);
        return created;
    }

    public void delete(long id) {
        profileMapper.delete(id);
    }
}
