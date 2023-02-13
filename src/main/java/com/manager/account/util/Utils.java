package com.manager.account.util;

import com.manager.account.exception.ResourceNotFoundException;

import java.util.*;

public class Utils {

    public static void validarTipoCuenta(String tipoCuenta) {
        for (TipoCuenta tipo: new ArrayList<>(Arrays.asList(TipoCuenta.values()))) {
            if (tipo.name().equals(tipoCuenta.toUpperCase())) return;
        }
        throw new ResourceNotFoundException("No se puede crear cuenta, tipo de cuenta : " + tipoCuenta + " no existe!");
    }



}
