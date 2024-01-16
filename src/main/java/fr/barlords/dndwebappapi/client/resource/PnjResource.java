package fr.barlords.dndwebappapi.client.resource;

import fr.barlords.dndwebappapi.client.dto.player.PlayerDto;
import fr.barlords.dndwebappapi.client.dto.pnj.PnjDto;
import fr.barlords.dndwebappapi.client.mapper.PlayerDtoMapper;
import fr.barlords.dndwebappapi.client.mapper.PnjDtoMapper;
import fr.barlords.dndwebappapi.domain.service.PlayerService;
import fr.barlords.dndwebappapi.domain.service.PnjService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("pnjs")
public class PnjResource {

    @Autowired
    private final PnjService pnjService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PnjDto getPnjById(@PathVariable String id) throws Exception {
        return PnjDtoMapper.toDto(pnjService.getPnjById(UUID.fromString(id)));
    }

}
