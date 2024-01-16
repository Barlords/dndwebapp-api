package fr.barlords.dndwebappapi.client.dto.player;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PlayerDto(
        UUID id,
        String name,
        String race,
        String size,
        String description,
        String background,
        String picturePresentation
) {
}
