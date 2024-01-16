package fr.barlords.dndwebappapi.client.mapper;

import fr.barlords.dndwebappapi.client.dto.artifact.AddArtifactRequest;
import fr.barlords.dndwebappapi.client.dto.artifact.ArtifactDto;
import fr.barlords.dndwebappapi.domain.model.Artifact;

import java.util.UUID;

public interface ArtifactDtoMapper {

    static Artifact addArtifactRequestToDomain(AddArtifactRequest request) {
        return Artifact.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .type(request.type())
                .description(request.description())
                .build();
    }

    static ArtifactDto toDto(Artifact domain) {
        return new ArtifactDto(
                domain.getId(),
                domain.getName(),
                domain.getType(),
                domain.getDescription(),
                domain.getPicturePresentation()
        );
    }

}
