package fr.barlords.dndwebappapi.domain.model;

import fr.barlords.dndwebappapi.client.dto.artifact.ArtifactDto;
import fr.barlords.dndwebappapi.client.dto.player.PlayerDto;
import fr.barlords.dndwebappapi.client.dto.pnj.PnjDto;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class Game {

    @Builder.Default
    UUID id = UUID.randomUUID();

    @With
    String name;

    @With
    String description;

    @With
    String gameMaster;

    @With
    @Builder.Default
    List<Player> playerList = new ArrayList<>();

    @With
    @Builder.Default
    List<Pnj> pnjList = new ArrayList<>();

    @With
    @Builder.Default
    List<Artifact> artifactList = new ArrayList<>();

}
