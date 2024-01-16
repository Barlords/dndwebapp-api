package fr.barlords.dndwebappapi.client.resource;

import fr.barlords.dndwebappapi.client.dto.artifact.ArtifactDto;
import fr.barlords.dndwebappapi.client.dto.pnj.PnjDto;
import fr.barlords.dndwebappapi.client.mapper.ArtifactDtoMapper;
import fr.barlords.dndwebappapi.client.mapper.PnjDtoMapper;
import fr.barlords.dndwebappapi.domain.service.ArtifactService;
import fr.barlords.dndwebappapi.domain.service.PnjService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("artifacts")
public class ArtifactResource {

    @Autowired
    private final ArtifactService service;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ArtifactDto getArtifactById(@PathVariable String id) throws Exception {
        return ArtifactDtoMapper.toDto(service.getArtifactById(UUID.fromString(id)));
    }

}
