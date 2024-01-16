package fr.barlords.dndwebappapi.domain.service;

import fr.barlords.dndwebappapi.domain.model.Player;
import fr.barlords.dndwebappapi.domain.model.Pnj;
import fr.barlords.dndwebappapi.server.mapper.PlayerEntityMapper;
import fr.barlords.dndwebappapi.server.mapper.PnjEntityMapper;
import fr.barlords.dndwebappapi.server.repository.PlayerRepository;
import fr.barlords.dndwebappapi.server.repository.PnjRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PnjService {

    private final PnjRepository repository;

    public Pnj getPnjById(UUID id) throws Exception {
        return PnjEntityMapper.toDomain(
                repository.findById(id)
                        .orElseThrow(Exception::new));
    }

}
