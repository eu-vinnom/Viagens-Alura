package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ResumoCompraActivity extends AppCompatActivity{

	public static final String APPBAR = "Resumo da compra";
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_compra);
		setTitle(APPBAR);

		Intent dadosPacote = getIntent();
		pacote = (Pacote) dadosPacote.getSerializableExtra("pacote");

		ImageView campoImagem = findViewById(R.id.resumo_compra_panoramica);
		campoImagem.setImageDrawable(ImagemUtil.buscaImagem(pacote.getImagem(), this));

		TextView campoLocal = findViewById(R.id.resumo_compra_local);
		campoLocal.setText(pacote.getLocal());

		TextView campoData = findViewById(R.id.resumo_compra_data);
		campoData.setText(DataUtil.formataData(pacote.getDias()));

		TextView campoValor = findViewById(R.id.resumo_compra_valor);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));
	}
}
