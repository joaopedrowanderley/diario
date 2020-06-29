/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author joão pedro
 */
public class DateUtil {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateToString(Date data){
        if(data != null){
            return formatter.format(data);
        }
        return "Não Informado";
    }
    public static Date stringToDate(String dataStr){
        try {
            return formatter.parse(dataStr);
        } catch (ParseException ex) {
            return null;
        }
    }
    
}
