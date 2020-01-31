package br.com.alura.aluraviagens.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.activity.component.PacoteComponent;

public class ResumoCompraActivity extends AppCompatActivity{

	private static final String APPBAR = "Resumo da compra";
	private static final String CHAVE_PACOTE = "pacote";
	private Pacote pacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo_compra);
		setTitle(APPBAR);

		PacoteComponent component = new PacoteComponent(this, this);

		pacote = component.recuperaPacote();

		component.defineImagem(pacote);
		component.defineLocal(pacote);
		component.defineData(pacote);
		component.definePreco(pacote);
	}
}
