package com.knor.profileapp.controller;

import com.knor.profileapp.model.Profile;
import com.knor.profileapp.model.request.CreateProfileRequest;
import com.knor.profileapp.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Поиск пользователя по id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Profile> findById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(profileService.findById(id));
    }

    @Operation(summary = "Поиск пользователя по фрагменту")
    @GetMapping(value = "/segment/{segment}")
    public ResponseEntity<List<Profile>> findByNameSegment(@PathVariable(name = "segment") String segment) {
        return ResponseEntity.ok(profileService.findByNameSegment(segment));
    }

    @Operation(summary = "Создание пользователя")
    @PostMapping()
    public ResponseEntity<Profile> create(@RequestBody CreateProfileRequest profile) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileService.create(profile));
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") long id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
