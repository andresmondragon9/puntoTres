package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Stream<Integer> secuencia = Stream.of(0,1,0,1,0,1,0,0);
        Scanner entradaEscaner = new Scanner (System.in);
        System.out.println("digite numero de días: " );
        String cantidadDias = entradaEscaner.nextLine ();

        System.out.println("cantidad de días: " + cantidadDias);

        List<Integer> salida = secuencia.collect(Collectors.toList());
        Arrays.asList(salida).stream().forEach(c -> {
            System.out.println("Entrada: " + Arrays.toString(c.toArray()));
        });
        for(int dia = 0 ; dia < Integer.valueOf(cantidadDias) ; dia++){
            salida = crearSecuencia(salida);
        }

        Arrays.asList(salida).stream().forEach(c -> {
            System.out.println("salida: " + Arrays.toString(c.toArray()));
        });
    }

    /**
     * creacion de la activacion e inactivacion de las celdas
     * @param listaCeldas
     * @return
     */
    public static List<Integer> crearSecuencia(List<Integer> listaCeldas){
        List<Integer> salida = new ArrayList<>();
        listaCeldas = ingresarCeldaAdyacentes(listaCeldas);
        Iterator iterCeldas = listaCeldas.iterator();
        int valorAnterior = (int) iterCeldas.next();
        int valorActual = (int) iterCeldas.next();
        int valorSiguiente = (int) iterCeldas.next();
        int valorFinal = 0;
        while(iterCeldas.hasNext()){
            if(valorAnterior == valorSiguiente){
                salida.add(0);
            }else{
                salida.add(1);
            }
            valorAnterior = valorActual;
            valorActual = valorSiguiente;
            valorSiguiente = (int) iterCeldas.next();
        }
        if(valorAnterior == valorFinal){
            salida.add(0);
        }else{
            salida.add(1);
        }
        return salida;
    }

    /**
     * ingreso de la celda de inicio y de fin en estado inactivas
     * @param listaCeldas
     * @return
     */
    public static List<Integer> ingresarCeldaAdyacentes(List<Integer> listaCeldas){
        List<Integer> listaSecuencia = new ArrayList<>();
        listaSecuencia.add(0);
        for(Integer celda: listaCeldas){
            listaSecuencia.add(celda);
        }
        listaSecuencia.add(0);
        return listaSecuencia;
    }

}
