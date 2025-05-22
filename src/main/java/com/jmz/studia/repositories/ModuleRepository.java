package com.jmz.studia.repositories;

import com.jmz.studia.domain.modules.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {
}
