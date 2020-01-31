package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.PacoteViagensAdapter;

public class PacotesViagensActivity extends AppCompatActivity{

	private static final String APPBAR = "Pacotes";
	private static final String CHAVE_PACOTE = "pacote";
	private Intent doPacotesParaResumoPacote;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pacote_viagens);
		setTitle(APPBAR);

		ListView listaPacotes = geraListaPacotes();

		geraIntentProResumo();

		abreResumoPacote(listaPacotes);

	}

	private ListView geraListaPacotes(){
		ListView listaPacotes = findViewById(R.id.pacote_viagens_lista);
		listaPacotes.setAdapter(new PacoteViagensAdapter(this));
		return listaPacotes;
	}

	private void abreResumoPacote(ListView listaPacotes){
		listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View card, int posicao, long id){
				Pacote pacote = (Pacote) adapterView.getItemAtPosition(posicao);
				doPacotesParaResumoPacote.putExtra(CHAVE_PACOTE, pacote);
				startActivity(doPacotesParaResumoPacote);
			}
		});
	}

	private void geraIntentProResumo(){
		doPacotesParaResumoPacote = new Intent(this, ResumoPacoteActivity.class);
	}
}
