package br.com.alura.aluraviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.ImagemUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PacoteViagensAdapter extends BaseAdapter{

	private final List<Pacote> pacotes;
	private final Context contexto;

	public PacoteViagensAdapter(Context context){
		this.contexto = context;
		PacoteDAO pacoteDao = new PacoteDAO();
		this.pacotes = new ArrayList<>(pacoteDao.lista());
	}

	@Override
	public int getCount(){
		return pacotes.size();
	}

	@Override
	public Object getItem(int posicao){
		return pacotes.get(posicao);
	}

	@Override
	public long getItemId(int i){
		return 0;
	}

	@Override
	public View getView(int posicao, View view, ViewGroup parent){
		@SuppressLint("ViewHolder")
		View item = LayoutInflater.from(contexto).inflate(R.layout.item_lista_pacotes, parent, false);
		Pacote pacote = pacotes.get(posicao);

		defineLocal(item, pacote);
		defineDias(item, pacote);
		definePreco(item, pacote);
		defineImagem(item, pacote);

		return item;
	}

	private void defineLocal(View item, Pacote pacote){
		TextView campoLocal = item.findViewById(R.id.item_lista_pacotes_local);
		campoLocal.setText(pacote.getLocal());
	}

	private void defineDias(View item, Pacote pacote){
		TextView campoDias = item.findViewById(R.id.item_lista_pacotes_dias);
		campoDias.setText(DiasUtil.singularOuPlural(pacote.getDias()));
	}

	private void definePreco(View item, Pacote pacote){
		TextView campoPreco = item.findViewById(R.id.item_lista_pacotes_preco);
		campoPreco.setText(MoedaUtil.formataMoeda(pacote.getPreco()));
	}

	private void defineImagem(View item, Pacote pacote){
		ImageView campoImagem = item.findViewById(R.id.item_lista_pacotes_panoramica);
		campoImagem.setImageDrawable(ImagemUtil.buscaImagem(pacote.getImagem(), contexto));
	}

}
