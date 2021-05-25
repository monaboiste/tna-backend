package pl.zgora.uz.wiea.tna.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.ShiftRepository;

import java.util.List;

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
}
