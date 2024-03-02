package org.esg.exercise.repository;

import org.esg.exercise.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
    List<CustomerEntity> findByCustomerRef(String customerRef);
}
