package notify.lld.domain.model;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import notify.lld.domain.enums.PriorityType;

@Entity
@Table(name = "messages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawMessage {
    @NonNull
    private String sender;
    @NonNull
    private List<String> recievers;
    @NonNull
    private String message;
    @NonNull
    private PriorityType type;
    @NonNull
    private String time;
}
