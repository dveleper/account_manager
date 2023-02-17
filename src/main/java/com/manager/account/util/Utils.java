package com.manager.account.util;

import com.manager.account.exception.ResourceNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    public static final String CREDITO = "CREDITO";
    public static final String DEBITO = "DEBITO";

    public static void validarTipoCuenta(String tipoCuenta) {
        for (TipoCuenta tipo: new ArrayList<>(Arrays.asList(TipoCuenta.values()))) {
            if (tipo.name().equals(tipoCuenta.toUpperCase())) return;
        }
        throw new ResourceNotFoundException("No se puede crear cuenta, tipo de cuenta : " + tipoCuenta + " no existe!");
    }


    public static Date getDateFormat(String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        return formato.parse(fecha);
    }

}
