package notify.lld.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import notify.lld.domain.model.QualifiedMessage;

public interface QualifiedRepo extends JpaRepository<QualifiedMessage, Long> {

}
