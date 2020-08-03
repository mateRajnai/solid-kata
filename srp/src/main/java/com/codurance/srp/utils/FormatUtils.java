package com.codurance.srp.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatUtils {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String AMOUNT_FORMAT = "#.00";

    public static String formatDate(LocalDate date) {
        return FormatUtils.formatDate(date, DATE_FORMAT);
    }

    // overloading, új lehetőséggel kibővítettük, ha más format-t használnánk
    // uaz formatNumberre
    public static String formatDate(LocalDate date, String dateFormat) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        return dateFormatter.format(date);
    }

    public static String formatNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(AMOUNT_FORMAT, DecimalFormatSymbols.getInstance(Locale.UK));
        return decimalFormat.format(amount);
    }
}
