package notify.lld.utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import notify.lld.api.dto.QMessageResponse;
import notify.lld.domain.model.QualifiedMessage;

@Service
public class Converter {
    
    public static Instant convertTimeToInstant(String timeString) {
        LocalTime time = LocalTime.parse(timeString); // format: "HH:mm:ss"
        // Get today's date
        LocalDate today = LocalDate.now();
        // Combine date and time to form a LocalDateTime
        LocalDateTime dateTime = LocalDateTime.of(today, time);
        // Convert to Instant using system default time zone
        return dateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    public static QualifiedMessage convertDtoMessage(QMessageResponse qm) {
        return QualifiedMessage.builder()
        .ID(Helper.generateID())
        .sender(qm.getSender())
        .receiver(qm.getReciever())
        .message(qm.getMessage())
        .statusType(Helper.startStatus())
        .type(Helper.startPriority())
        .sendTime(qm.getSendTime())
        .time(convertTimeToInstant(qm.getSendTime()))
        .build();
    }
}
