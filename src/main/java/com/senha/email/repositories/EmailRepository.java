package com.senha.email.repositories;

import com.senha.email.entitites.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
}
