package br.com.map.calculadora.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Calculadora{
    private String[] stringSeparated;
    private List<String> ArrayOp;
    private List<Float> partialResult;
    private float result;
    
    public Calculadora(String s)throws Exception{
        result = 0;
        ArrayOp = new ArrayList<>();        
        stringSeparated = s.split("[+]|[/]|[*]|[-]");
        Pattern p = Pattern.compile("[+|/|*|-]");
        Matcher m = p.matcher(s);
        while(m.find()){
            ArrayOp.add(m.group());
        }
        partialResult = parseFloat(stringSeparated);
        
    }
    
    public float calcular()throws Exception{
        int i, j;
        for(i=0; i < ArrayOp.size();i++){
            String op = ArrayOp.get(i);
            if(op.equals("*") || op.equals("/")){
                result = operacao(op, partialResult.get(i), partialResult.get(i+1));
                partialResult.set(i, result);
                partialResult.remove(i+1);
                ArrayOp.remove(i);
                i--;                
            }
        }
        for(i=0; i < ArrayOp.size();i++){
            String op = ArrayOp.get(i);
            if(op.equals("+") || op.equals("-")){
                result = operacao(op, partialResult.get(i), partialResult.get(i+1));
                partialResult.set(i, result);
                partialResult.remove(i+1);
                ArrayOp.remove(i);
                i--;                
            }
        }
        
        return result;
    }
        
    
    
    public float operacao(String s, float num1, float num2)throws Exception{
        switch(s){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2; 
        }
        return 0;
    }
    
    
    
    private List<Float> parseFloat(String[] s)throws Exception{
        List<Float> L = new ArrayList<>();
        int i;
        
        for(String str : s){
            L.add(Float.parseFloat(str));
            
        }
        return L;
    }

}