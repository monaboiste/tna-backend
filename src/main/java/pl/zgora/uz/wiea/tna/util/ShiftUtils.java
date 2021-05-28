package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zgora.uz.wiea.tna.model.Shift;
import pl.zgora.uz.wiea.tna.persistence.entity.ShiftEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShiftUtils {

    static public Shift mapShiftEntityToShift(final ShiftEntity shiftEntity) {
        return Shift.builder()
                .id(shiftEntity.getId())
                .date(shiftEntity.getDate())
                .timeOfDay(shiftEntity.getTimeOfDay())
                .build();
    }

    static public ShiftEntity mapShiftToEntity(final Shift shift) {
        return ShiftEntity.builder()
                .id(shift.getId())
                .date(shift.getDate())
                .timeOfDay(shift.getTimeOfDay())
                .build();
    }
}
