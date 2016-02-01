package com.lds.teste.hino;

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lds.daos.HinoDAO;
import com.lds.entidades.Hino;

public class HinoTeste {
	
	@Test
	public void converterJsonToListObj() {
		HinoDAO hinoDAO = new HinoDAO();
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		String hinos = gson.toJson(hinoDAO.findAll());
		TypeToken<List<Hino>> hinoToken = new TypeToken<List<Hino>>(){};
		List<Hino> hinoList = gson.fromJson(hinos, hinoToken.getType());
		for (Hino hino : hinoList) {
			System.out.println(hino);
		}
	}

}
