package fr.barlords.dndwebappapi.client.mapper;

import fr.barlords.dndwebappapi.client.dto.game.CreateGameRequest;
import fr.barlords.dndwebappapi.client.dto.game.GameDto;
import fr.barlords.dndwebappapi.domain.model.Game;

import java.util.UUID;

public interface GameDtoMapper {

    static Game creationRequestToDomain(CreateGameRequest request) {
        return Game.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .description(request.description())
                .gameMaster(request.gameMaster())
                .build();
    }



    static GameDto toDto(Game domain) {
        return new GameDto(
                domain.getId(),
                domain.getName(),
                domain.getDescription(),
                domain.getGameMaster(),
                domain.getPlayerList().stream().map(PlayerDtoMapper::toDto).toList(),
                domain.getPnjList().stream().map(PnjDtoMapper::toDto).toList(),
                domain.getArtifactList().stream().map(ArtifactDtoMapper::toDto).toList()
        );
    }

}
