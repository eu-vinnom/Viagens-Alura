package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.activity.component.PacoteComponent;

public class ResumoCompraActivity extends AppCompatActivity{

	private static final String APPBAR = "Resumo da compra";
	private Pacote pacote;
	private Intent doResumoCompraProPacotes;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_compra);
		setTitle(APPBAR);

		PacoteComponent component = new PacoteComponent(this);
		doResumoCompraProPacotes = geraIntentProPacotes();

		pacote = component.recuperaPacote();

		component.defineImagem(pacote, R.id.resumo_compra_panoramica);
		component.defineLocal(pacote, R.id.resumo_compra_local);
		component.defineData(pacote, R.id.resumo_compra_data);
		component.definePreco(pacote, R.id.resumo_compra_valor);
	}

	private Intent geraIntentProPacotes(){
		return new Intent(this, PacotesViagensActivity.class);
	}

	@Override
	public void onBackPressed(){
		doResumoCompraProPacotes.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(doResumoCompraProPacotes);
	}
}
