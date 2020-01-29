package br.com.alura.aluraviagens.util;

import android.widget.TextView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.model.Pacote;

public class MoedaUtil{

	public static String formataMoeda(BigDecimal valor){
		BigDecimal preco = valor;
		NumberFormat formatoBr = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
		String moedaReal = formatoBr.format(preco).replace("R$", "R$ ");
		return moedaReal;
	}

}
