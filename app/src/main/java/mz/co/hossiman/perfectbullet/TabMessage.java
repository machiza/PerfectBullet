package mz.co.hossiman.perfectbullet;

/**
 * Created by iiro on 7.6.2016.
 */
public class TabMessage {
    public static String get(int menuItemId, boolean isReselection) {
//        String message = "Content for ";
        String message = "";

        switch (menuItemId) {
            case R.id.tab_all:
                message = "All";
                break;
            case R.id.tab_refrigerantes:
                message = "Refrigerantes";
                break;
            case R.id.tab_cerveja:
                message = "Cervejas";
                break;
            case R.id.tab_garafa:
                message = "Secas";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }


    public static String getAction(int menuItemId, boolean isReselection) {
        String message = "";

        switch (menuItemId) {
            case R.id.tab_pagamento:
                message = "Pagamento";
                break;
            case R.id.tab_limpar:
                message = "Limpar";
                break;
            case R.id.tab_sair:
                message = "Sair";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }

    public static String getPay(int menuItemId, boolean isReselection) {
        String message = "";

        switch (menuItemId) {
            case R.id.tab_confirmar:
                message = "Confirmar";
                break;
            case R.id.tab_cancelar:
                message = "Cancelar";
                break;
            case R.id.tab_add:
                message = "Add";
                break;
            case R.id.tab_actualizar:
                message = "Actualizar";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }
}
