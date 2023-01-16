package ru.levelup.homework10.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levelup.homework9.dto.CityPageDto;
import ru.levelup.homework9.security.Authorities;
import ru.levelup.homework9.service.CityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;
    private final Authorities authorities;

    @GetMapping
    public CityPageDto find(@PageableDefault(value = 5) Pageable pageable) {
        final CityPageDto page = cityService.getPage(pageable);
        page.setAdmin(authorities.isAdmin());
        return page;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
