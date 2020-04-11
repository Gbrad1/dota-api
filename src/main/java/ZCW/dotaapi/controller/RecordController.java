package ZCW.dotaapi.controller;

import ZCW.dotaapi.module.Record;
import ZCW.dotaapi.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    private RecordService rs;

    @Autowired
    public RecordController(RecordService recordService) {
        this.rs = recordService;
    }

    @GetMapping("/dotaFASE/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable Long id) {
        return new ResponseEntity<>(rs.findById(id), HttpStatus.OK);
    }

    @GetMapping("/dotaFASE/")
    public ResponseEntity<Iterable<Record>> getAllRecords() {
        return new ResponseEntity<>(rs.findAll(), HttpStatus.OK);
    }

}
