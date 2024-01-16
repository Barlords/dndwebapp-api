package fr.barlords.dndwebappapi.server.mapper;

import fr.barlords.dndwebappapi.domain.model.Artifact;
import fr.barlords.dndwebappapi.domain.model.Pnj;
import fr.barlords.dndwebappapi.server.entity.ArtifactEntity;
import fr.barlords.dndwebappapi.server.entity.PnjEntity;

public interface ArtifactEntityMapper {

    static Artifact toDomain(ArtifactEntity entity) {
        return Artifact.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .description(entity.getDescription())
                .picturePresentation(entity.getPicturePresentation())
                .build();
    }

    static ArtifactEntity fromDomain(Artifact domain) {
        return ArtifactEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .type(domain.getType())
                .description(domain.getDescription())
                .picturePresentation(domain.getPicturePresentation())
                .build();
    }

}
