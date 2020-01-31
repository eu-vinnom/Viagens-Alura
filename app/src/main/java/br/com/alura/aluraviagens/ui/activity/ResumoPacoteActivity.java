package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResumoPacoteActivity extends AppCompatActivity{

	private static final String APPBAR = "Resumo do Pacote";
	private Intent doResumoProForm;
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_pacote);
		setTitle(APPBAR);

		pacote = recuperaPacote();

		defineLocal(pacote);
		defineDias(pacote);
		definePreco(pacote);
		defineImagem(pacote);
		defineData(pacote);

		geraIntentProPagamento();

		Button realizaPagamento = findViewById(R.id.resumo_pacote_botao_pagamento);
		realizaPagamento.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				doResumoProForm.putExtra("pacote", pacote);
				startActivity(doResumoProForm);
			}
		});
	}

	private void geraIntentProPagamento(){
		doResumoProForm = new Intent(this, PagamentoActivity.class);
	}

	private void defineData(Pacote pacote){
		TextView campoData = findViewById(R.id.resumo_pacote_data);
		campoData.setText(DataUtil.formataData(pacote.getDias()));
	}

	private void defineImagem(Pacote pacote){
		ImageView campoImagem = findViewById(R.id.resumo_pacote_panoramica);
		campoImagem.setImageDrawable(ImagemUtil.buscaImagem(pacote.getImagem(), this));
	}

	private void definePreco(Pacote pacote){
		TextView campoValor = findViewById(R.id.resumo_pacote_valor);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));
	}

	private void defineDias(Pacote pacote){
		TextView campoDias = findViewById(R.id.resumo_pacote_dias);
		campoDias.setText(DiasUtil.singularOuPlural(pacote.getDias()));
	}

	private void defineLocal(Pacote pacote){
		TextView campoLocal = findViewById(R.id.resumo_pacote_local);
		campoLocal.setText(pacote.getLocal());
	}

	private Pacote recuperaPacote(){
		Intent dadosPacote = getIntent();
		return (Pacote) dadosPacote.getSerializableExtra("pacote");
	}
}
