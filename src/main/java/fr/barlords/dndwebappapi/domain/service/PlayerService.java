package fr.barlords.dndwebappapi.domain.service;

import fr.barlords.dndwebappapi.domain.model.Artifact;
import fr.barlords.dndwebappapi.domain.model.Game;
import fr.barlords.dndwebappapi.domain.model.Player;
import fr.barlords.dndwebappapi.domain.model.Pnj;
import fr.barlords.dndwebappapi.server.mapper.GameEntityMapper;
import fr.barlords.dndwebappapi.server.mapper.PlayerEntityMapper;
import fr.barlords.dndwebappapi.server.repository.GameRepository;
import fr.barlords.dndwebappapi.server.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;

    public Player getPlayerById(UUID id) throws Exception {
        return PlayerEntityMapper.toDomain(
                repository.findById(id)
                        .orElseThrow(Exception::new));
    }

}
