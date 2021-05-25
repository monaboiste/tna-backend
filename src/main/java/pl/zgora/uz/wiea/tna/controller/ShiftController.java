package pl.zgora.uz.wiea.tna.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zgora.uz.wiea.tna.model.Shift;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;
import pl.zgora.uz.wiea.tna.service.ShiftService;
import pl.zgora.uz.wiea.tna.util.ShiftUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shift")
public class ShiftController {

    private final ShiftService shiftService;

    @PostMapping
    public Shift createShift(@RequestBody final Shift shift) {
        final ShiftEntity shiftEntity = ShiftUtils.mapShiftToEntity(shift);
        return ShiftUtils.mapShiftEntityToShift(shiftService.createShift(shiftEntity));
    }
}
