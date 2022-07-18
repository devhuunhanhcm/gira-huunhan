package springbootapplication.girahuunhan.role.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootapplication.girahuunhan.role.model.GiraGroup;

@Repository
public interface GiraGroupRepository extends JpaRepository<GiraGroup, UUID>{

}
