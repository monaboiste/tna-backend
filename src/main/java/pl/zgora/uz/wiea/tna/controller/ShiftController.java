package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.Shift;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.service.ShiftService;
import pl.zgora.uz.wiea.tna.util.ShiftUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shifts")
public class ShiftController {

    private final ShiftService shiftService;

    @PostMapping
    public Shift createShift(@RequestBody final Shift shift) {
        final ShiftEntity shiftEntity = ShiftUtils.mapShiftToEntity(shift);
        return ShiftUtils.mapShiftEntityToShift(shiftService.createShift(shiftEntity));
    }

    @GetMapping
    List<Shift>  fetchAllShifts() {
        final List<ShiftEntity> shiftEntities = shiftService.fetchAllShifts();
        final List<Shift> shifts = shiftEntities.parallelStream()
                .map(ShiftUtils::mapShiftEntityToShift)
                .collect(Collectors.toList());
        return shifts;
    }
}
