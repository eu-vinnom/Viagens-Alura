package br.com.alura.aluraviagens.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil{

	public static String formataMoeda(BigDecimal valor){
		NumberFormat formatoBr = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
		return formatoBr.format(valor).replace("R$", "R$ ");
	}

}
