package ru.levelup.homework10.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levelup.homework10.dto.RegionPageDto;
import ru.levelup.homework10.security.Authorities;
import ru.levelup.homework10.service.RegionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionService regionService;
    private final Authorities authorities;

    @GetMapping
    public RegionPageDto find(@PageableDefault(value = 5) Pageable pageable) {
        final RegionPageDto page = regionService.getPage(pageable);
        page.setAdmin(authorities.isAdmin());
        return page;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        regionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
