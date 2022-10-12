package com.huntercodexs.oauth2clientdemo.config.oauth2.repository;

import com.huntercodexs.oauth2clientdemo.config.oauth2.model.Oauth2ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Oauth2ClientRepository extends JpaRepository<Oauth2ClientEntity, Long> {
    @Query(value = "SELECT * FROM oauth2_client LIMIT 1", nativeQuery = true)
    Oauth2ClientEntity findClientAuthorization();
}
