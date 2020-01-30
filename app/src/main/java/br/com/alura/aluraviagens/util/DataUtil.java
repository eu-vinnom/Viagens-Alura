package br.com.alura.aluraviagens.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil{

	private static final String DIA_E_MES = "dd/MM";

	public static String formataData(int dias){
		Calendar dataIda = Calendar.getInstance();
		Calendar dataVolta = Calendar.getInstance();
		dataVolta.add(Calendar.DATE, dias);
		@SuppressLint("SimpleDateFormat") SimpleDateFormat formata = new SimpleDateFormat(DIA_E_MES);
		String dataIdaFormatada = formata.format(dataIda.getTime());
		String dataVoltaFormatada = formata.format(dataVolta.getTime());
		return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
	}

}
