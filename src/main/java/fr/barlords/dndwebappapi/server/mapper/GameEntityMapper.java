package fr.barlords.dndwebappapi.server.mapper;

import fr.barlords.dndwebappapi.domain.model.Game;
import fr.barlords.dndwebappapi.server.entity.GameEntity;

public interface GameEntityMapper {

    static Game toDomain(GameEntity entity) {
        return Game.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .gameMaster(entity.getGameMaster())
                .playerList(entity.getPlayerEntityList().stream().map(PlayerEntityMapper::toDomain).toList())
                .pnjList(entity.getPnjEntityList().stream().map(PnjEntityMapper::toDomain).toList())
                .artifactList(entity.getArtifactEntityList().stream().map(ArtifactEntityMapper::toDomain).toList())
                .build();
    }

    static GameEntity fromDomain(Game domain) {
        return GameEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .gameMaster(domain.getGameMaster())
                .playerEntityList(domain.getPlayerList().stream().map(PlayerEntityMapper::fromDomain).toList())
                .pnjEntityList(domain.getPnjList().stream().map(PnjEntityMapper::fromDomain).toList())
                .artifactEntityList(domain.getArtifactList().stream().map(ArtifactEntityMapper::fromDomain).toList())
                .build();
    }

}
