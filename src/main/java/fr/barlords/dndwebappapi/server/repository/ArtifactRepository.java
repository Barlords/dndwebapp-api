package fr.barlords.dndwebappapi.server.repository;

import fr.barlords.dndwebappapi.server.entity.ArtifactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtifactRepository extends JpaRepository<ArtifactEntity, UUID> {


}
