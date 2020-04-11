package ZCW.dotaapi.service;

import ZCW.dotaapi.module.Record;
import ZCW.dotaapi.repository.RecordRepository;
import kong.unirest.HttpResponse;
import kong.unirest.JsonObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordService {

    private RecordRepository rr;

    @Autowired
    public RecordService (RecordRepository recordRepository) {
        this.rr = recordRepository;
    }

    public Record createRecord(Record record) {
        return rr.save(record);
    }

    public Optional<Record> findById(Long id) {
        return rr.findById(id);
    }

    public Iterable<Record> findAll() {
        return rr.findAll();
    }

    public boolean deleteById(Long id) {
        rr.deleteById(id);
        return true;
    }

    // This returns the JSON String
    public String fetchAPI(String query) {
        HttpResponse<String> response = Unirest.get(query).asString();
        return response.getBody();
    }

    // This turns the JSON string into an object.
    public Record convertToObject(String fetchedInfo) {
        JsonObjectMapper jsonObjectMapper = new JsonObjectMapper();
        return jsonObjectMapper.readValue(fetchedInfo, Record.class);
    }

    public Record retrieveInformation(Record record) {
        createRecord(record);
        return record;
    }
}
