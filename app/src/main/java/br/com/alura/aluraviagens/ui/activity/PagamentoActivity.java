package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagamento);
		setTitle("Pagamento");

		Intent dadosPacote = getIntent();
		Pacote pacote = (Pacote) dadosPacote.getSerializableExtra("pacote");

		TextView campoValor = findViewById(R.id.pagamento_valor_pacote);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));

	}
}
