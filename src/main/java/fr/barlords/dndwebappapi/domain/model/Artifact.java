package fr.barlords.dndwebappapi.domain.model;

import fr.barlords.dndwebappapi.server.entity.GameEntity;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Value
@Builder
public class Artifact {

    @Builder.Default
    UUID id = UUID.randomUUID();

    @With
    String name;

    @With
    String type;

    @With
    String description;

    @With
    String picturePresentation;

}
