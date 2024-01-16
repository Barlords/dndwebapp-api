package fr.barlords.dndwebappapi.client.dto.game;

import fr.barlords.dndwebappapi.client.dto.artifact.ArtifactDto;
import fr.barlords.dndwebappapi.client.dto.player.PlayerDto;
import fr.barlords.dndwebappapi.client.dto.pnj.PnjDto;

import java.util.List;
import java.util.UUID;

public record GameDto(

        UUID id,
        String name,
        String description,
        String gameMaster,
        List<PlayerDto> playerList,
        List<PnjDto> pnjList,
        List<ArtifactDto> artifactList

) {
}
