package notify.lld.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import notify.lld.domain.model.LogEntry;

public interface LogRepo extends JpaRepository<LogEntry, Long> {
    
}
