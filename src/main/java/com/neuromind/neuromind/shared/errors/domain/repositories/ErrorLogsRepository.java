package com.neuromind.neuromind.shared.errors.domain.repositories;

import com.neuromind.neuromind.shared.errors.domain.entities.ErrorLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogsRepository extends JpaRepository<ErrorLogs, Long> {
}
