package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.PacoteViagensAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PacoteViagensActivity extends AppCompatActivity{

	public static final String APPBAR = "Pacotes";

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pacote_viagens);
		setTitle(APPBAR);

		ListView listaPacotes = findViewById(R.id.pacote_viagens_lista);
		listaPacotes.setAdapter(new PacoteViagensAdapter(this));

		final Intent doPacoteParaResumo = new Intent(this, ResumoPacoteActivity.class);

		listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View card, int posicao, long id){
				Pacote pacote = (Pacote) adapterView.getItemAtPosition(posicao);
				doPacoteParaResumo.putExtra("pacote", pacote);
				startActivity(doPacoteParaResumo);
			}
		});

	}
}
