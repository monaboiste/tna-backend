package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    public static String toTitleCase(final String text) {
        StringBuilder sb = new StringBuilder(text.length());
        final String[] words = text.split(" ");
        int index = 0;
        for (final String word : words) {
            final String firstLetter = word.substring(0, 1);
            final String reminder = word.substring(1);
            sb.append(firstLetter.toUpperCase()).append(reminder.toLowerCase());

            if (index < words.length - 1) {
                sb.append(" ");
            }
            index++;
        }
        return sb.toString();
    }
}