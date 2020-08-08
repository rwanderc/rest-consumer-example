package com.wandercosta.example.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    private final SchoolRepository repository;
    private final ModelMapper mapper;

    public SampleController(final SchoolRepository repository,
                            final ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping(path = "/schools")
    public List<SchoolDTO> getSchools() {
        log.info("Call to /schools");
        final List<School> schools = repository.getSchools();
        final List<SchoolDTO> schoolDTOs = schools.stream()
                .map(s -> mapper.map(s, SchoolDTO.class))
                .collect(Collectors.toList());
        return schoolDTOs;
    }

    @GetMapping(path = "/schools/{id}")
    public SchoolDTO getSchool(@PathVariable long id) {
        log.info("Call to /schools/{}", id);
        final School school = repository.getSchool(id);
        final SchoolDTO schoolDTO = mapper.map(school, SchoolDTO.class);
        return schoolDTO;
    }
}
