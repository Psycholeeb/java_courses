package com.courses.spalah.mvc;

import com.courses.spalah.mvc.request.PlaneRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ievgen Tararaka
 */
@RestController
@RequestMapping(value = "/planes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaneController {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PlaneRequest> savePlane(@RequestBody PlaneRequest plane) {
        return new ResponseEntity<PlaneRequest>(plane, HttpStatus.OK);
    }
}
