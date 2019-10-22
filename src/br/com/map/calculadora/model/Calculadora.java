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
    private String[] stringDividida;
    private List<String> ArrayOp;
    private List<Float> parcialResult;
    private float result;
    
    public Calculadora(String s)throws Exception{
        result = 0;
        ArrayOp = new ArrayList<>();        
        stringDividida = s.split("[+|/|*|-]");
        parcialResult = parseFloat(stringDividida);
        Pattern p = Pattern.compile("[+|/|*|-]");
        Matcher m = p.matcher(s);
        while(m.find()){
            ArrayOp.add(m.group());
        }
        
    }
    
    public float calcular()throws Exception{
        int i, j;
        for(i = 0; i < ArrayOp.size(); i++){
            for(j = 0; j < parcialResult.size(); j++){
                if(ArrayOp.get(i).equals("*") || ArrayOp.get(i).equals("/")){
                    result = operacao(ArrayOp.get(i), parcialResult.get(j), parcialResult.get(j+1));
                    parcialResult.set(j, result);
                    parcialResult.remove(j+1);
                    break;
                }else{
                    break;
                }
            }
            
        }
        for(i = 0; i < ArrayOp.size(); i++){
            for(j = 0; j < parcialResult.size(); j++){
                if(ArrayOp.get(i).equals("-") || ArrayOp.get(i).equals("+")){
                    result = operacao(ArrayOp.get(i), parcialResult.get(j), parcialResult.get(j+1));
                    parcialResult.set(j, result);
                    parcialResult.remove(j+1);
                    break;
                }
                else{
                    break;
                }
            }
        }
        //result = parcialResult.get(0);
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
        for(String str : s){
            L.add(Float.parseFloat(str));
        }
        return L;
    }

}