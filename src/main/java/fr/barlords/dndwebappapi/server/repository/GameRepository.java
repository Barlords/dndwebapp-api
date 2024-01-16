package fr.barlords.dndwebappapi.server.repository;

import fr.barlords.dndwebappapi.server.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface GameRepository extends JpaRepository<GameEntity, UUID> {


}
