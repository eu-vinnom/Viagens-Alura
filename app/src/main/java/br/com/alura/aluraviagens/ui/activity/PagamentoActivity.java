package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity{

	private static final String APPBAR = "Pagamento";
	private Intent doPagamentoProResumoCompra;
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagamento);
		setTitle(APPBAR);

		Intent dadosPacote = getIntent();
		pacote = (Pacote) dadosPacote.getSerializableExtra("pacote");

		TextView campoValor = findViewById(R.id.pagamento_valor_pacote);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));

		doPagamentoProResumoCompra = geraIntentProResumoCompra();

		Button finalizaPagamento = findViewById(R.id.pagamento_botao_finalizar);
		finalizaPagamento.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				doPagamentoProResumoCompra.putExtra("pacote", pacote);
				startActivity(doPagamentoProResumoCompra);
			}
		});
	}

	private Intent geraIntentProResumoCompra(){
		return new Intent(this, ResumoCompraActivity.class);
	}
}
