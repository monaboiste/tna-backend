package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.zgora.uz.wiea.tna.model.Shift;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.service.ShiftService;
import pl.zgora.uz.wiea.tna.util.ShiftUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shifts")
public class ShiftController {

    private final ShiftService shiftService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Shift createShift(@RequestBody @Valid final Shift shift) {
        final ShiftEntity shiftEntity = ShiftUtils.mapShiftToEntity(shift);
        return ShiftUtils.mapShiftEntityToShift(shiftService.createShift(shiftEntity));
    }

    @GetMapping
    public List<Shift>  fetchAllShifts() {
        final List<ShiftEntity> shiftEntities = shiftService.fetchAllShifts();
        final List<Shift> shifts = shiftEntities.parallelStream()
                .map(ShiftUtils::mapShiftEntityToShift)
                .collect(Collectors.toList());
        return shifts;
    }
}
