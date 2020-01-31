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
	private Intent doResumoProForm;
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_pacote);
		setTitle(APPBAR);

		PacoteComponent component = new PacoteComponent(this, this);

		pacote = component.recuperaPacote();

		component.defineLocal(pacote);
		component.defineDias(pacote);
		component.definePreco(pacote);
		component.defineImagem(pacote);
		component.defineData(pacote);

		geraIntentProPagamento();

		abrePagamento();
	}

	private void abrePagamento(){
		Button realizaPagamento = findViewById(R.id.resumo_pacote_botao_pagamento);
		realizaPagamento.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				doResumoProForm.putExtra(CHAVE_PACOTE, pacote);
				startActivity(doResumoProForm);
			}
		});
	}

	private void geraIntentProPagamento(){
		doResumoProForm = new Intent(this, PagamentoActivity.class);
	}

}
