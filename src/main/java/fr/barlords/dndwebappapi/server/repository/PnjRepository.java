package fr.barlords.dndwebappapi.server.repository;

import fr.barlords.dndwebappapi.server.entity.PnjEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PnjRepository extends JpaRepository<PnjEntity, UUID> {


}
