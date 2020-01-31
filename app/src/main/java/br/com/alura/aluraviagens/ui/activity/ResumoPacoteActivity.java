package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.activity.component.ResumoPacoteComponent;
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
	private static final String CHAVE_PACOTE = "pacote";
	private Intent doResumoProForm;
	private Pacote pacote;
	private ResumoPacoteComponent component;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_pacote);
		setTitle(APPBAR);

		component = new ResumoPacoteComponent(this, this);

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
