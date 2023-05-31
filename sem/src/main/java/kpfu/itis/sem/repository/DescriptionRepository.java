package kpfu.itis.sem.repository;

import kpfu.itis.sem.entity.DescriptionEntity;
import kpfu.itis.sem.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DescriptionRepository extends JpaRepository<DescriptionEntity, UUID> {

    Optional<DescriptionEntity> findByProductId(ProductEntity product);
}
