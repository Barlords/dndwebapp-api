package fr.barlords.dndwebappapi.client.mapper;

import fr.barlords.dndwebappapi.client.dto.player.AddPlayerRequest;
import fr.barlords.dndwebappapi.client.dto.player.PlayerDto;
import fr.barlords.dndwebappapi.domain.model.Player;

import java.util.UUID;

public interface PlayerDtoMapper {

    static Player addPlayerRequestToDomain(AddPlayerRequest request) {
        return Player.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .race(request.race())
                .size(request.size())
                .description(request.description())
                .background(request.background())
                .build();
    }

    static PlayerDto toDto(Player domain) {
        return new PlayerDto(
                domain.getId(),
                domain.getName(),
                domain.getRace(),
                domain.getSize(),
                domain.getDescription(),
                domain.getBackground(),
                domain.getPicturePresentation()
        );
    }

}
