package ZCW.dotaapi.repository;

import ZCW.dotaapi.module.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findBySteamId(Long id);
}
