package br.com.alura.aluraviagens.util;

import android.widget.TextView;

import br.com.alura.aluraviagens.model.Pacote;

public class DiasUtil{

	public static final String DIA = " dia";
	public static final String DIAS = " dias";

	public static String singularOuPlural(int quantidade){

		if(quantidade == 1){
			return quantidade + DIA;
		}
		return quantidade + DIAS;
	}

}
