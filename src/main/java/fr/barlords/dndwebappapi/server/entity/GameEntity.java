package fr.barlords.dndwebappapi.server.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "game")
public class GameEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy =  "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "gameMaster")
    private String gameMaster;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PlayerEntity> playerEntityList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PnjEntity> pnjEntityList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ArtifactEntity> artifactEntityList;
}


