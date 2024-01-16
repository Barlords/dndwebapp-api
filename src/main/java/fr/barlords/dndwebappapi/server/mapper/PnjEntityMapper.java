package fr.barlords.dndwebappapi.server.mapper;

import fr.barlords.dndwebappapi.domain.model.Player;
import fr.barlords.dndwebappapi.domain.model.Pnj;
import fr.barlords.dndwebappapi.server.entity.PlayerEntity;
import fr.barlords.dndwebappapi.server.entity.PnjEntity;

public interface PnjEntityMapper {

    static Pnj toDomain(PnjEntity entity) {
        return Pnj.builder()
                .id(entity.getId())
                .name(entity.getName())
                .race(entity.getRace())
                .description(entity.getDescription())
                .picturePresentation(entity.getPicturePresentation())
                .build();
    }

    static PnjEntity fromDomain(Pnj domain) {
        return PnjEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .race(domain.getRace())
                .description(domain.getDescription())
                .picturePresentation(domain.getPicturePresentation())
                .build();
    }

}
