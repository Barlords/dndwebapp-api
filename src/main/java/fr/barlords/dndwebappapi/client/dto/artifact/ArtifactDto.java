package fr.barlords.dndwebappapi.client.dto.artifact;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import fr.barlords.dndwebappapi.server.entity.GameEntity;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record ArtifactDto(

        UUID id,
        String name,
        String type,
        String description,
        String picturePresentation

) {
}
