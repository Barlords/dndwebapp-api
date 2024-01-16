package fr.barlords.dndwebappapi.domain.model;

import fr.barlords.dndwebappapi.client.dto.artifact.ArtifactDto;
import fr.barlords.dndwebappapi.client.dto.player.PlayerDto;
import fr.barlords.dndwebappapi.client.dto.pnj.PnjDto;
import fr.barlords.dndwebappapi.server.entity.GameEntity;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class Player {

    @Builder.Default
    UUID id = UUID.randomUUID();

    @With
    String name;

    @With
    String race;

    @With
    String size;

    @With
    String description;

    @With
    String background;

    @With
    String picturePresentation;

}
