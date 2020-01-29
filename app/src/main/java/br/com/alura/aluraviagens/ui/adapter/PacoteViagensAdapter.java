package br.com.alura.aluraviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;

public class PacoteViagensAdapter extends BaseAdapter{

	List<Pacote> pacotes;
	PacoteDAO pacoteDao;
	private Context context;

	public PacoteViagensAdapter(Context context){
		this.context = context;
		this.pacoteDao = new PacoteDAO();
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
		View item = LayoutInflater.from(context).inflate(R.layout.item_lista_pacotes, parent, false);
		Pacote pacote = pacotes.get(posicao);

		TextView campoLocal = item.findViewById(R.id.item_lista_pacotes_cidade);
		campoLocal.setText(pacote.getLocal());

		TextView campoDias = item.findViewById(R.id.item_lista_pacotes_dias);
		int quantidadeDias = pacote.getDias();
		switch(quantidadeDias){
			case 1:
				campoDias.setText(quantidadeDias + " dia");
				break;

			default:
				campoDias.setText(quantidadeDias + " dias");
		}

		TextView campoPreco = item.findViewById(R.id.item_lista_pacotes_preco);
		BigDecimal preco = pacote.getPreco();
		NumberFormat formatoBr = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
		String moedaReal = formatoBr.format(preco).replace("R$", "R$ ");
		campoPreco.setText(moedaReal);

		Resources res = context.getResources();
		int drawableId = res.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
		Drawable drawable = res.getDrawable(drawableId);
		ImageView campoImagem = item.findViewById(R.id.item_lista_pacotes_panoramica);
		campoImagem.setImageDrawable(drawable);


		return item;
	}
}
