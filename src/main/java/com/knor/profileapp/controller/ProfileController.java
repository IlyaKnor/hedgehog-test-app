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

    @Operation(
            summary = "Проверка наличия пользователя",
            description = "API принимает в себя имя пользователя и отдает ответ, " +
                    "содержащий информацию есть пользователь, или нет в базе"
    )
    @GetMapping(value = "/{name}")
    public ResponseEntity<Profile> findByName(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok(profileService.findByName(name));
    }

    @Operation(
            summary = "Поиск пользователя по фрагменту",
            description = "API принимает в себя часть имени пользователя и выводит всех пользователей," +
                    " которые могут подходить"
    )
    @GetMapping(value = "/segment/{segment}")
    public ResponseEntity<List<Profile>> findByNameSegment(@PathVariable(name = "segment") String segment) {
        return ResponseEntity.ok(profileService.findByNameSegment(segment));
    }

    @Operation(
            summary = "Добавление пользователя",
            description = "API принимает в себя данные “Имя/Фамилия”, записывает это в базу данных"
    )
    @PostMapping()
    public ResponseEntity<Profile> create(@RequestBody CreateProfileRequest profile) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileService.create(profile));
    }

    @Operation(
            summary = "Удаление пользователя по id",
            description = "API принимает в себя id пользователя и удаляет его из базы данных"
    )
    @DeleteMapping(value = "/by-id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") long id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Удаление пользователя по имени",
            description = "API принимает в себя имя пользователя и удаляет его из базы данных"
    )
    @DeleteMapping(value = "/by-name/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable(name = "name")String name) {
        profileService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
