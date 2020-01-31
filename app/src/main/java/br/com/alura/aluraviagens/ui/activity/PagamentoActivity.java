package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.activity.component.PacoteComponent;

public class PagamentoActivity extends AppCompatActivity{

	private static final String APPBAR = "Pagamento";
	private static final String CHAVE_PACOTE = "pacote";
	private Intent doPagamentoProResumoCompra;
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagamento);
		setTitle(APPBAR);

		PacoteComponent component = new PacoteComponent(this, this);

		pacote = component.recuperaPacote();
		component.definePreco(pacote);

		doPagamentoProResumoCompra = geraIntentProResumoCompra();

		abreResumoCompra();
	}

	private void abreResumoCompra(){
		Button finalizaPagamento = findViewById(R.id.pagamento_botao_finalizar);
		finalizaPagamento.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				doPagamentoProResumoCompra.putExtra(CHAVE_PACOTE, pacote);
				startActivity(doPagamentoProResumoCompra);
			}
		});
	}

	private Intent geraIntentProResumoCompra(){
		return new Intent(this, ResumoCompraActivity.class);
	}
}
