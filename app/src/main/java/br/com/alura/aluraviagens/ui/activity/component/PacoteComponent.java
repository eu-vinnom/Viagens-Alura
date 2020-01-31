package br.com.alura.aluraviagens.ui.activity.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PacoteComponent{

	private Activity activity;
	private Context contexto;

	public PacoteComponent(Activity activity, Context contexto){
		this.activity = activity;
		this.contexto = contexto;
	}

	public void defineData(Pacote pacote){
		TextView campoData = activity.findViewById(R.id.resumo_pacote_data);
		campoData.setText(DataUtil.formataData(pacote.getDias()));
	}

	public void defineImagem(Pacote pacote){
		ImageView campoImagem = activity.findViewById(R.id.resumo_pacote_panoramica);
		campoImagem.setImageDrawable(ImagemUtil.buscaImagem(pacote.getImagem(), contexto));
	}

	public void definePreco(Pacote pacote){
		TextView campoValor = activity.findViewById(R.id.resumo_pacote_valor);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));
	}

	public void defineDias(Pacote pacote){
		TextView campoDias = activity.findViewById(R.id.resumo_pacote_dias);
		campoDias.setText(DiasUtil.singularOuPlural(pacote.getDias()));
	}

	public void defineLocal(Pacote pacote){
		TextView campoLocal = activity.findViewById(R.id.resumo_pacote_local);
		campoLocal.setText(pacote.getLocal());
	}

	public Pacote recuperaPacote(){
		Intent dadosPacote = activity.getIntent();
		return (Pacote) dadosPacote.getSerializableExtra("pacote");
	}

}
