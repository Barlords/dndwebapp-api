package fr.barlords.dndwebappapi.server.mapper;

import fr.barlords.dndwebappapi.domain.model.Game;
import fr.barlords.dndwebappapi.domain.model.Player;
import fr.barlords.dndwebappapi.server.entity.GameEntity;
import fr.barlords.dndwebappapi.server.entity.PlayerEntity;

public interface PlayerEntityMapper {

    static Player toDomain(PlayerEntity entity) {
        return Player.builder()
                .id(entity.getId())
                .name(entity.getName())
                .race(entity.getRace())
                .size(entity.getSize())
                .description(entity.getDescription())
                .background(entity.getBackground())
                .picturePresentation(entity.getPicturePresentation())
                .build();
    }

    static PlayerEntity fromDomain(Player domain) {
        return PlayerEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .race(domain.getRace())
                .size(domain.getSize())
                .description(domain.getDescription())
                .background(domain.getBackground())
                .picturePresentation(domain.getPicturePresentation())
                .build();
    }

}
