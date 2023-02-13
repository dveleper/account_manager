package com.manager.account.util;

import java.util.Arrays;

public enum TipoCuenta {
    AHORROS,
    CORRIENTE;

    public static boolean validate(String tipoCuenta) {
        return Arrays.asList(TipoCuenta.values()).contains(tipoCuenta);
    }

}
