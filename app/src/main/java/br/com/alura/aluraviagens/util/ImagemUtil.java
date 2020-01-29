package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.alura.aluraviagens.model.Pacote;

public class ImagemUtil{

	public static Drawable buscaImagem(Pacote pacote, Context contexto){
		Resources res = contexto.getResources();
		int drawableId = res.getIdentifier(pacote.getImagem(), "drawable", contexto.getPackageName());
		return res.getDrawable(drawableId);
	}

}
