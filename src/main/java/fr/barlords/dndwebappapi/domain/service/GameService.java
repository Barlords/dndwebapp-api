package fr.barlords.dndwebappapi.domain.service;

import fr.barlords.dndwebappapi.domain.model.Artifact;
import fr.barlords.dndwebappapi.domain.model.Game;
import fr.barlords.dndwebappapi.domain.model.Player;
import fr.barlords.dndwebappapi.domain.model.Pnj;
import fr.barlords.dndwebappapi.server.mapper.GameEntityMapper;
import fr.barlords.dndwebappapi.server.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    public List<Game> getGames() {
        return repository.findAll().stream().map(GameEntityMapper::toDomain).toList();
    }

    public Game getGameById(UUID gameId) throws Exception {
        return GameEntityMapper.toDomain(
                repository.findById(gameId)
                        .orElseThrow(Exception::new));
    }

    public void createGame(Game game) {
        repository.save(GameEntityMapper.fromDomain(game));
    }

    public void addPlayer(UUID gameId, Player player) throws Exception {
        Game game = this.getGameById(gameId);

        List<Player> players = new ArrayList<>(game.getPlayerList());
        players.add(player);

        game = game.withPlayerList(players);

        repository.save(GameEntityMapper.fromDomain(game));
    }

    public void addPnj(UUID gameId, Pnj pnj) throws Exception {
        Game game = this.getGameById(gameId);

        List<Pnj> pnjs = new ArrayList<>(game.getPnjList());
        pnjs.add(pnj);

        game = game.withPnjList(pnjs);

        repository.save(GameEntityMapper.fromDomain(game));
    }

    public void addArtifact(UUID gameId, Artifact artifact) throws Exception {
        Game game = this.getGameById(gameId);

        List<Artifact> artifacts = new ArrayList<>(game.getArtifactList());
        artifacts.add(artifact);

        game = game.withArtifactList(artifacts);

        repository.save(GameEntityMapper.fromDomain(game));
    }



}
