package com.example.zonky.cucumber;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnyEntityRepository extends JpaRepository<AnyEntity, Long> {
}
