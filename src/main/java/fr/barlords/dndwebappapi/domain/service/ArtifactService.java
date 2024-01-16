package fr.barlords.dndwebappapi.domain.service;

import fr.barlords.dndwebappapi.domain.model.Artifact;
import fr.barlords.dndwebappapi.domain.model.Pnj;
import fr.barlords.dndwebappapi.server.mapper.ArtifactEntityMapper;
import fr.barlords.dndwebappapi.server.mapper.PnjEntityMapper;
import fr.barlords.dndwebappapi.server.repository.ArtifactRepository;
import fr.barlords.dndwebappapi.server.repository.PnjRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArtifactService {

    private final ArtifactRepository repository;

    public Artifact getArtifactById(UUID id) throws Exception {
        return ArtifactEntityMapper.toDomain(
                repository.findById(id)
                        .orElseThrow(Exception::new));
    }

}
