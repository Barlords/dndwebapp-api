package fr.barlords.dndwebappapi.client.dto.game;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CreateGameRequest(
        @NotNull @JsonProperty("name") String name,
        @NotNull @JsonProperty("description") String description,
        @NotNull @JsonProperty("game_master") String gameMaster
) {
}
