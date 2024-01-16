package fr.barlords.dndwebappapi.server.repository;

import fr.barlords.dndwebappapi.server.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID> {


}
