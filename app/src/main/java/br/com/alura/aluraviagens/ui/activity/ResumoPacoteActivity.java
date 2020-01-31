package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.activity.component.PacoteComponent;

public class ResumoPacoteActivity extends AppCompatActivity{

	private static final String APPBAR = "Resumo do Pacote";
	private static final String CHAVE_PACOTE = "pacote";
	private Intent doResumoPacoteProPagamento;
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_pacote);
		setTitle(APPBAR);

		PacoteComponent component = new PacoteComponent(this);

		pacote = component.recuperaPacote();

		component.defineLocal(pacote, R.id.resumo_pacote_local);
		component.defineDias(pacote, R.id.resumo_pacote_dias);
		component.definePreco(pacote, R.id.resumo_pacote_valor);
		component.defineImagem(pacote, R.id.resumo_pacote_panoramica);
		component.defineData(pacote, R.id.resumo_pacote_data);

		geraIntentProPagamento();

		abrePagamento();
	}

	private void abrePagamento(){
		Button realizaPagamento = findViewById(R.id.resumo_pacote_botao_pagamento);
		realizaPagamento.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				doResumoPacoteProPagamento.putExtra(CHAVE_PACOTE, pacote);
				startActivity(doResumoPacoteProPagamento);
			}
		});
	}

	private void geraIntentProPagamento(){
		doResumoPacoteProPagamento = new Intent(this, PagamentoActivity.class);
	}

}
