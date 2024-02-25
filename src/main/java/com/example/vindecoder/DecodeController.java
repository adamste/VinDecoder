package com.example.vindecoder;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DecodeController {
    private final DecoderService decoderService;

    @GetMapping(value = "/api/decode")
    public ResponseEntity<CarFeatures> getDecoded(@RequestParam(value = "vin") String vin) {
        return ResponseEntity.ok(decoderService.decode(vin));
    }

    @ExceptionHandler({WrongVinFormat.class})
    public ResponseEntity<?> handleException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Wrong VIN format");
    }
}
