package notify.lld.domain.model;

import java.time.Instant;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;
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
import notify.lld.domain.enums.PriorityType;
import notify.lld.domain.enums.StatusType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "qualified-message")
public class QualifiedMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long ID;

    @NonNull
    private String sender;

    @NonNull
    private String receiver;

    @NonNull
    private String message;

    @Nullable
    private StatusType statusType;

    @Nullable
    private PriorityType type;
    
    @NonNull
    private String sendTime;

    @Nullable
    private Instant time;
}
