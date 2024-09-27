package com.sbdigital.webapp.SecurityService.Repository;

import com.sbdigital.webapp.SecurityService.Domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
    File findByTaskIdAndUserId(Long taskId, Long userId);
}