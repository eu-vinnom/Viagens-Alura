package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity{

	public static final String APPBAR = "Resumo do Pacote";

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_pacote);
		setTitle(APPBAR);

		Intent dadosPacote = getIntent();
		Pacote pacote = (Pacote) dadosPacote.getSerializableExtra("pacote");

		TextView campoLocal = findViewById(R.id.resumo_pacote_local);
		campoLocal.setText(pacote.getLocal());

		TextView campoDias = findViewById(R.id.resumo_pacote_dias);
		campoDias.setText(DiasUtil.singularOuPlural(pacote.getDias()));

		TextView campoValor = findViewById(R.id.resumo_pacote_valor);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));

		ImageView campoImagem = findViewById(R.id.resumo_pacote_panoramica);
		campoImagem.setImageDrawable(ImagemUtil.buscaImagem(pacote.getImagem(), this));

		TextView campoData = findViewById(R.id.resumo_pacote_data);
		Calendar dataIda = Calendar.getInstance();
		Calendar dataVolta = Calendar.getInstance();
		dataVolta.add(Calendar.DATE, pacote.getDias());
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM");
		String dataIdaFormatada = formata.format(dataIda.getTime());
		String dataVoltaFormatada = formata.format(dataVolta.getTime());
		String data = dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
		campoData.setText(data);


	}
}
