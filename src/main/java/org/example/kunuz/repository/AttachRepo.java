package org.example.kunuz.repository;

import org.example.kunuz.model.Attach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachRepo extends JpaRepository<Attach , UUID> {
}
