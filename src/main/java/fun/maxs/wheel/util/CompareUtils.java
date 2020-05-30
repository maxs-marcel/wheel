package fun.maxs.wheel.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 * 比较工具
 * @author maxs
 */
public class CompareUtils {
    private CompareUtils() {
    }

    /**
     * 非空校验
     */
    private static boolean paramNonNull(BigDecimal a, BigDecimal b){
        return Objects.nonNull(a) && Objects.nonNull(b);
    }
    /**
     * 非空校验
     */
    private static boolean paramNonNull(LocalDateTime a, LocalDateTime b){
        return Objects.nonNull(a) && Objects.nonNull(b);
    }
    /**
     * 非空校验
     */
    private static boolean paramNonNull(LocalDate a, LocalDate b){
        return Objects.nonNull(a) && Objects.nonNull(b);
    }
    /**
     * 非空校验
     */
    private static boolean paramNonNull(LocalTime a, LocalTime b){
        return Objects.nonNull(a) && Objects.nonNull(b);
    }

    /**
     * BigDecimal比较
     */
    public static class BigDecimals {
        private BigDecimals() {
        }

        /**
         * a > b
         */
        public static boolean gt(BigDecimal a, BigDecimal b) {
            return paramNonNull(a, b) && a.compareTo(b) > 0;
        }

        /**
         * a >= b
         */
        public static boolean gte(BigDecimal a, BigDecimal b) {
            return paramNonNull(a, b) && a.compareTo(b) >= 0;
        }

        /**
         * a < b
         */
        public static boolean lt(BigDecimal a, BigDecimal b) {
            return paramNonNull(a, b) && a.compareTo(b) < 0;
        }

        /**
         * a <= b
         */
        public static boolean lte(BigDecimal a, BigDecimal b) {
            return paramNonNull(a, b) && a.compareTo(b) <= 0;
        }

        /**
         * a == b
         */
        public static boolean eq(BigDecimal a, BigDecimal b) {
            return paramNonNull(a, b) && a.compareTo(b) == 0;
        }
    }

    /**
     * LocalDateTime比较
     */
    public static class LocalDateTimes {
        private LocalDateTimes() {
        }

        /**
         * a > b
         */
        public static boolean gt(LocalDateTime a, LocalDateTime b) {
            return paramNonNull(a, b) && a.compareTo(b) > 0;
        }

        /**
         * a >= b
         */
        public static boolean gte(LocalDateTime a, LocalDateTime b) {
            return paramNonNull(a, b) && a.compareTo(b) >= 0;
        }

        /**
         * a < b
         */
        public static boolean lt(LocalDateTime a, LocalDateTime b) {
            return paramNonNull(a, b) && a.compareTo(b) < 0;
        }

        /**
         * a <= b
         */
        public static boolean lte(LocalDateTime a, LocalDateTime b) {
            return paramNonNull(a, b) && a.compareTo(b) <= 0;
        }

        /**
         * a == b
         */
        public static boolean eq(LocalDateTime a, LocalDateTime b) {
            return paramNonNull(a, b) && a.compareTo(b) == 0;
        }

    }

    /**
     * LocalDateTime比较
     */
    public static class LocalDates {
        private LocalDates() {
        }

        /**
         * a > b
         */
        public static boolean gt(LocalDate a, LocalDate b) {
            return paramNonNull(a, b) && a.compareTo(b) > 0;
        }

        /**
         * a >= b
         */
        public static boolean gte(LocalDate a, LocalDate b) {
            return paramNonNull(a, b) && a.compareTo(b) >= 0;
        }

        /**
         * a < b
         */
        public static boolean lt(LocalDate a, LocalDate b) {
            return paramNonNull(a, b) && a.compareTo(b) < 0;
        }

        /**
         * a <= b
         */
        public static boolean lte(LocalDate a, LocalDate b) {
            return paramNonNull(a, b) && a.compareTo(b) <= 0;
        }

        /**
         * a == b
         */
        public static boolean eq(LocalDate a, LocalDate b) {
            return paramNonNull(a, b) && a.compareTo(b) == 0;
        }

    }

    /**
     * LocalDateTime比较
     */
    public static class LocalTimes {
        private LocalTimes() {
        }

        /**
         * a > b
         */
        public static boolean gt(LocalTime a, LocalTime b) {
            return paramNonNull(a, b) && a.compareTo(b) > 0;
        }

        /**
         * a >= b
         */
        public static boolean gte(LocalTime a, LocalTime b) {
            return paramNonNull(a, b) && a.compareTo(b) >= 0;
        }

        /**
         * a < b
         */
        public static boolean lt(LocalTime a, LocalTime b) {
            return paramNonNull(a, b) && a.compareTo(b) < 0;
        }

        /**
         * a <= b
         */
        public static boolean lte(LocalTime a, LocalTime b) {
            return paramNonNull(a, b) && a.compareTo(b) <= 0;
        }

        /**
         * a == b
         */
        public static boolean eq(LocalTime a, LocalTime b) {
            return paramNonNull(a, b) && a.compareTo(b) == 0;
        }

    }
}
