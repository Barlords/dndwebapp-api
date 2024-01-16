package fr.barlords.dndwebappapi.client.dto.pnj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AddPnjRequest(
        @NotNull @JsonProperty("game_id") String gameId,
        @NotNull @JsonProperty("name") String name,
        @NotNull @JsonProperty("race") String race,
        @NotNull @JsonProperty("description") String description
) {
}
