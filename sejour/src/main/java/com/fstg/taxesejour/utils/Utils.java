package com.fstg.taxesejour.utils;


import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Slf4j
public class Utils {
    private Utils() {
    }

    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-mm-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static BigDecimal stringToBigDecimal(String input) {
        return new BigDecimal(input);
    }

    public static Date expectedDate(int numTrim, int annee) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (numTrim) {
            case 1:
                stringBuilder.append(annee).append("-03").append("-31");
                break;
            case 2:
                stringBuilder.append(annee).append("-06").append("-30");
                break;
            case 3:
                stringBuilder.append(annee).append("-09").append("-30");
                break;
            case 4:
                stringBuilder.append(annee).append("-12").append("-31");
                break;
            default:
                return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(stringBuilder.toString());
        } catch (ParseException e) {
            return null;
        }
    }

    public static int getNumberOfMonthRetard(int numTrim, int annee) {
        Date datePresentation = new Date();
        Date expectedDatePresentation = expectedDate(numTrim, annee);
        if (expectedDatePresentation == null) return -1;
        if (isAfter(datePresentation, expectedDatePresentation)) {
            return 0; // ila b4a ikhls xi trim en avance cad nombreMoisRetard =0;
        }
        return monthsBetween(datePresentation, expectedDatePresentation);
    }

    public static int monthsBetween(Date d1, Date d2) {
        if (d2 == null || d1 == null) {
            return -1;//Error
        }
        Calendar m_calendar = Calendar.getInstance();
        m_calendar.setTime(d1);
        int nDay1 = 12 * 30 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH) * 30 + m_calendar.get(Calendar.DATE);
        m_calendar.setTime(d2);
        int nDay2 = 12 * 30 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH) * 30 + m_calendar.get(Calendar.DATE);
        return Math.abs(nDay1 - nDay2) / 30;
    }


//    public static void getMontant(TaxeSejourTrimPojo taxeSejourTrimPojo, Double tauxRetardPremierMois, Double tauxRetardAutreMois, long nombreNuit, int nombreMoiRetard) {
//        calculateMontantRetard(tauxRetardPremierMois, taxeSejourTrimPojo, tauxRetardAutreMois, nombreNuit, nombreMoiRetard);
//    }

    public static BigDecimal getMontant(Double taux, long nombreNuit) {
        return BigDecimal.valueOf(
                (nombreNuit * taux));
    }

    public static void calculateMontantRetard(Double tauxRetardPremierMois, TaxeSejourTrimPojo taxeSejourTrimPojo, Double tauxRetardAutreMois, int nombreMoiRetard) {
        if (nombreMoiRetard > 0) {
            BigDecimal premierMoiRetard = BigDecimal.valueOf(taxeSejourTrimPojo.getNombreNuit() * tauxRetardPremierMois);
            BigDecimal autreMoisRetard = BigDecimal.valueOf((taxeSejourTrimPojo.getNombreNuit() * tauxRetardAutreMois) * (nombreMoiRetard - 1));
            taxeSejourTrimPojo.setPremierMoisRetard(premierMoiRetard);
            taxeSejourTrimPojo.setAutreMoisRetard(autreMoisRetard);
            taxeSejourTrimPojo.setMontantRetard(premierMoiRetard.add(autreMoisRetard));
            log.info("data in utils {} ", taxeSejourTrimPojo);
        }
    }

    public static boolean isAfter(Date dateMin, Date dateMax) {
        return dateMax.getTime() > dateMin.getTime();
    }
}
