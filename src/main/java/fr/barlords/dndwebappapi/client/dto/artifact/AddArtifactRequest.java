package fr.barlords.dndwebappapi.client.dto.artifact;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AddArtifactRequest(
        @NotNull @JsonProperty("game_id") String gameId,
        @NotNull @JsonProperty("name") String name,
        @NotNull @JsonProperty("type") String type,
        @NotNull @JsonProperty("description") String description
) {
}
