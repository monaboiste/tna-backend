package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.persistence.entity.TimeOfDay;
import pl.zgora.uz.wiea.tna.persistence.repository.ShiftRepository;
import pl.zgora.uz.wiea.tna.service.exception.ShiftNotFoundException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShiftService {

    private final ShiftRepository shiftRepository;

    @Transactional
    public ShiftEntity createShift(final ShiftEntity shiftEntity) {
        return shiftRepository.saveAndFlush(shiftEntity);
    }

    public List<ShiftEntity> fetchAllShifts() {
        return shiftRepository.findAll();
    }

    public ShiftEntity fetchShiftById(final long shiftId) {
        return shiftRepository.findById(shiftId)
                .orElseThrow(ShiftNotFoundException::new);
    }

    public Optional<ShiftEntity> fetchShiftByDateAndTimeOfDay(final Date date,
                                                              final TimeOfDay timeOfDay) {
        return shiftRepository.findByDateAndTimeOfDay(date, timeOfDay);
    }
}
