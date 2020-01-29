package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.ui.adapter.PacoteViagensAdapter;

import android.os.Bundle;
import android.widget.ListView;

public class PacoteViagensActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pacote_viagens);

		ListView listaPacotes = findViewById(R.id.pacote_viagens_lista);
		listaPacotes.setAdapter(new PacoteViagensAdapter(this));
	}
}
