/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author march
 */
public class Validadores {
    
    public boolean validaNombre(String s) {
        String patron = "(([a-z]|[A-Z]|[0-9])|([ '-]([a-z]|[A-Z]|[0-9]))){3,40}";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

}
