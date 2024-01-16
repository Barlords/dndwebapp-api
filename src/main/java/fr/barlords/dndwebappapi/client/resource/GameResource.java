package fr.barlords.dndwebappapi.client.resource;

import fr.barlords.dndwebappapi.client.dto.artifact.AddArtifactRequest;
import fr.barlords.dndwebappapi.client.dto.game.CreateGameRequest;
import fr.barlords.dndwebappapi.client.dto.game.GameDto;
import fr.barlords.dndwebappapi.client.dto.player.AddPlayerRequest;
import fr.barlords.dndwebappapi.client.dto.pnj.AddPnjRequest;
import fr.barlords.dndwebappapi.client.mapper.ArtifactDtoMapper;
import fr.barlords.dndwebappapi.client.mapper.GameDtoMapper;
import fr.barlords.dndwebappapi.client.mapper.PlayerDtoMapper;
import fr.barlords.dndwebappapi.client.mapper.PnjDtoMapper;
import fr.barlords.dndwebappapi.domain.service.GameService;
import fr.barlords.dndwebappapi.external.minio.MinioException;
import fr.barlords.dndwebappapi.external.minio.MinioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("games")
public class GameResource {

    @Autowired
    private final GameService gameService;

    private final MinioService minioService;

    @GetMapping
    @ResponseStatus(OK)
    public List<GameDto> getGames() {
        return gameService.getGames().stream().map(GameDtoMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public GameDto getGameById(@PathVariable String id) throws Exception {
        return GameDtoMapper.toDto(gameService.getGameById(UUID.fromString(id)));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createGame(@RequestBody CreateGameRequest request) {
        gameService.createGame(GameDtoMapper.creationRequestToDomain(request));
    }

    @PatchMapping(value = "/addPlayer", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(OK)
    public void addPlayer(
            @Valid @RequestPart("picture_presentation") MultipartFile pictureFile,
            @Valid @RequestPart("add_player_request") AddPlayerRequest request
    ) throws Exception {
        String picturePath = request.name()+"/"+pictureFile.getOriginalFilename();

        try {
            minioService.upload(picturePath, pictureFile.getInputStream(), pictureFile.getContentType());
        } catch (MinioException e) {
            throw new IllegalStateException("The file cannot be upload on the internal storage. Please retry later", e);
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot be read", e);
        }

        gameService.addPlayer(
                UUID.fromString(request.gameId()),
                PlayerDtoMapper.addPlayerRequestToDomain(request).withPicturePresentation(picturePath)
        );
    }

    @PatchMapping(value = "/addPnj", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(OK)
    public void addPnj(
            @Valid @RequestPart("picture_presentation") MultipartFile pictureFile,
            @Valid @RequestPart("add_pnj_request") AddPnjRequest request
    ) throws Exception {

        String picturePath = request.name()+"/"+pictureFile.getOriginalFilename();

        try {
            minioService.upload(picturePath, pictureFile.getInputStream(), pictureFile.getContentType());
        } catch (MinioException e) {
            throw new IllegalStateException("The file cannot be upload on the internal storage. Please retry later", e);
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot be read", e);
        }

        gameService.addPnj(
                UUID.fromString(request.gameId()),
                PnjDtoMapper.addPnjRequestToDomain(request).withPicturePresentation(picturePath));
    }

    @PatchMapping("/addArtifact")
    @ResponseStatus(OK)
    public void addArtifact(
            @Valid @RequestPart("picture_presentation") MultipartFile pictureFile,
            @Valid @RequestPart("add_artifact_request") AddArtifactRequest request
    ) throws Exception {

        String picturePath = request.name()+"/"+pictureFile.getOriginalFilename();

        try {
            minioService.upload(picturePath, pictureFile.getInputStream(), pictureFile.getContentType());
        } catch (MinioException e) {
            throw new IllegalStateException("The file cannot be upload on the internal storage. Please retry later", e);
        } catch (IOException e) {
            throw new IllegalStateException("The file cannot be read", e);
        }

        gameService.addArtifact(
                UUID.fromString(request.gameId()),
                ArtifactDtoMapper.addArtifactRequestToDomain(request).withPicturePresentation(picturePath));
    }

}
