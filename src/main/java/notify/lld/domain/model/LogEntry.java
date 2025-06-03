package notify.lld.domain.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "logs")
public class LogEntry {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
    @NonNull
    private Long messageID;
    @NonNull
    private String status;
}
