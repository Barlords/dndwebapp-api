package fr.barlords.dndwebappapi.client.dto.pnj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import fr.barlords.dndwebappapi.server.entity.GameEntity;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PnjDto(

        UUID id,
        String name,
        String race ,
        String description,
        String picturePresentation

) {
}
