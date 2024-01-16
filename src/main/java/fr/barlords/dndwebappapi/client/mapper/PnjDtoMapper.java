package fr.barlords.dndwebappapi.client.mapper;

import fr.barlords.dndwebappapi.client.dto.pnj.AddPnjRequest;
import fr.barlords.dndwebappapi.client.dto.pnj.PnjDto;
import fr.barlords.dndwebappapi.domain.model.Pnj;

import java.util.UUID;

public interface PnjDtoMapper {

    static Pnj addPnjRequestToDomain(AddPnjRequest request) {
        return Pnj.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .race(request.race())
                .description(request.description())
                .build();
    }

    static PnjDto toDto(Pnj domain) {
        return new PnjDto(
                domain.getId(),
                domain.getName(),
                domain.getRace(),
                domain.getDescription(),
                domain.getPicturePresentation()
        );
    }

}
