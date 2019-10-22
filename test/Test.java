/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import br.com.map.calculadora.model.Calculadora;

/**
 *
 * @author natan
 */
public class Test {
    public static void main(String[] args){
        String[] stringDividida;
        List<String> ArrayOp;
        String s = "20*2/2+2-1";
        
        //Calculadora c = new Calculadora(s);
        
        //System.out.println(c.calcular());
    
        ArrayOp = new ArrayList<>();
        stringDividida = s.split("[+|-|/|*]");
        Pattern p = Pattern.compile("[+|-|/|*]");
        Matcher m = p.matcher(s);
        while(m.find()){
            ArrayOp.add(m.group());
        }
        
        ArrayOp.forEach((str) -> {
            System.out.println(str);
        });
        
        for(String str : stringDividida){
            System.out.println(str);
        }
    }
}
