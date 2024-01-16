package fr.barlords.dndwebappapi.client.resource;

import fr.barlords.dndwebappapi.client.dto.player.PlayerDto;
import fr.barlords.dndwebappapi.client.mapper.PlayerDtoMapper;
import fr.barlords.dndwebappapi.domain.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("players")
public class PlayerResource {

    @Autowired
    private final PlayerService playerService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PlayerDto getPlayerById(@PathVariable String id) throws Exception {
        return PlayerDtoMapper.toDto(playerService.getPlayerById(UUID.fromString(id)));
    }

}
