/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jhonatan
 */
public class ProcessaString {
    
    public String compila(Set<String> listString){
        String stringProcessada = new String();
        
        for(String frase : listString){
            stringProcessada += frase + "; ";
        }
        
        return stringProcessada;
    }
    
    public HashSet<String> descompila(String frase){
        HashSet<String> listString = new HashSet<String>();
        
        String auxiliar[] = frase.split("; ");
        for(String processada : auxiliar){
            listString.add(processada);
        }
        
        return listString;
    }
}
