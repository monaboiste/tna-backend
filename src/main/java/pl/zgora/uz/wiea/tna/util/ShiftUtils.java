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
                .startedAt(shiftEntity.getStartedAt())
                .endedAt(shiftEntity.getEndedAt())
                .build();
    }

    static public ShiftEntity mapShiftToEntity(final Shift shift) {
        return ShiftEntity.builder()
                .id(shift.getId())
                .startedAt(shift.getStartedAt())
                .endedAt(shift.getEndedAt())
                .build();
    }
}
