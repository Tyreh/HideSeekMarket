package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GeneradorTarjetas {
    private final Dto dto;
    private final Random random;
    private final Date date;
    private final Calendar calendar;

    public GeneradorTarjetas(Dto dto) {
        this.dto = dto;
        random = new Random();
        date = new Date();
        calendar = Calendar.getInstance();
    }

    public String generarBin() {
        int bin1 = 1000 + random.nextInt(9000);
        int bin2 = 1000 + random.nextInt(9000);
        int bin3 = 1000 + random.nextInt(9000);
        int bin4 = 1000 + random.nextInt(9000);
        String finalBin = "" + bin1 + bin2 + bin3 + bin4;

        for (Cliente cliente : dto.getArrayClientes()) {
            if (cliente.getBinTarjeta().equals(finalBin)) {
                generarBin();
            }
        }

        return finalBin;
    }

    public int generarCodigo() {
        return (100 + random.nextInt(900));
    }

    public int generarMesCaducidad() {
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public int generarAnioCaducidad() {
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + 4;
    }
}
