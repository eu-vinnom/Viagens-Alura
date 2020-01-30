package br.com.alura.aluraviagens.util;

public class DiasUtil{

	private static final String DIA = " dia";
	private static final String DIAS = " dias";

	public static String singularOuPlural(int quantidade){

		if(quantidade == 1){
			return quantidade + DIA;
		}
		return quantidade + DIAS;
	}

}
