package notify.lld.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import notify.lld.api.dto.QMessageResponse;
import notify.lld.facade.MessageWrapper;

@RestController
@RequestMapping("/message")
public class MessageControl {
    @Autowired
    private MessageWrapper messageWrapper;

    @PostMapping("/send")
    public ResponseEntity<String> send(QMessageResponse qm) {
        try {
            if (messageWrapper.fireMessage(qm))
                return ResponseEntity.ok().body("Request sent successfully with Status : " + HttpStatus.ACCEPTED);
            return ResponseEntity.internalServerError()
                    .body("Request failed with Status code : " + HttpStatus.BAD_REQUEST + " and error : due to internal failure !! ");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Request failed with Status code : " + HttpStatus.BAD_REQUEST + " and error : " + e.getMessage());
        }
    }
}
