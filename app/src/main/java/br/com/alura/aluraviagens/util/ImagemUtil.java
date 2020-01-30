package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ImagemUtil{

	public static Drawable buscaImagem(String imagem, Context contexto){
		Resources res = contexto.getResources();
		int drawableId = res.getIdentifier(imagem, "drawable", contexto.getPackageName());
		return res.getDrawable(drawableId);
	}

}
