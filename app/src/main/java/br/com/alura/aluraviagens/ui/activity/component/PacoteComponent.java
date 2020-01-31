package br.com.alura.aluraviagens.ui.activity.component;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PacoteComponent{

	private static final String CHAVE_PACOTE = "pacote";
	private Activity activity;

	public PacoteComponent(Activity activity){
		this.activity = activity;
	}

	public void defineData(Pacote pacote, int dataId){
		TextView campoData = activity.findViewById(dataId);
		campoData.setText(DataUtil.formataData(pacote.getDias()));
	}

	public void defineImagem(Pacote pacote, int imagemId){
		ImageView campoImagem = activity.findViewById(imagemId);
		campoImagem.setImageDrawable(ImagemUtil.buscaImagem(pacote.getImagem(), activity));
	}

	public void definePreco(Pacote pacote, int precoId){
		TextView campoValor = activity.findViewById(precoId);
		campoValor.setText(MoedaUtil.formataMoeda(pacote.getPreco()));
	}

	public void defineDias(Pacote pacote, int diasId){
		TextView campoDias = activity.findViewById(diasId);
		campoDias.setText(DiasUtil.singularOuPlural(pacote.getDias()));
	}

	public void defineLocal(Pacote pacote, int localId){
		TextView campoLocal = activity.findViewById(localId);
		campoLocal.setText(pacote.getLocal());
	}

	public Pacote recuperaPacote(){
		Intent dadosPacote = activity.getIntent();
		return (Pacote) dadosPacote.getSerializableExtra(CHAVE_PACOTE);
	}

}
