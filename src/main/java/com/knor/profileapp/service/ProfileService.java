package com.knor.profileapp.service;

import com.knor.profileapp.mapper.ProfileMapper;
import com.knor.profileapp.model.Profile;
import com.knor.profileapp.model.converter.ProfileRequestConverter;
import com.knor.profileapp.model.request.CreateProfileRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileMapper profileMapper;
    private final ProfileRequestConverter profileRequestConverter;

    public Profile findByName(String name) {
        return profileMapper.selectByName(name.toLowerCase());
    }

    public List<Profile> findByNameSegment(String segment) {
        return profileMapper.selectByNameSegment(
                "%" + segment.toLowerCase() + "%"
        );
    }

    public Profile create(CreateProfileRequest profile) {
        Profile created = profileRequestConverter.toProfile(profile);
        profileMapper.insert(created);
        return created;
    }

    public void deleteById(long id) {
        profileMapper.deleteById(id);
    }

    public void deleteByName(String name) {
        profileMapper.deleteByName(name.toLowerCase());
    }
}
