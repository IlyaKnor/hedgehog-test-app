package com.knor.profileapp;

import com.knor.profileapp.mapper.ProfileMapper;

import com.knor.profileapp.model.Profile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileMapperTest {

    @Autowired
    ProfileMapper profileMapper;
    @Test
    public void test() {
        Profile profile = new Profile("Biba", "Boba");
        profileMapper.insert(profile);
        Assert.assertNotNull(profile.getId());
    }
}
