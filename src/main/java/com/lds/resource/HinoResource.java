package com.lds.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lds.daos.HinoDAO;
import com.lds.entidades.Hino;

@Path("/hino")
public class HinoResource {
	
	@GET
	@Path("/todoshinos")
	@Produces(MediaType.APPLICATION_JSON)
	public String todosHinos(){
		HinoDAO hinoDAO = new HinoDAO();
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String hinos = gson.toJson(hinoDAO.findAll());
		return hinos;
	}
	
	@POST
	@Path("/inserir")
	public String inserir(Hino hino) {
		HinoDAO hinoDAO = new HinoDAO();
		hinoDAO.salvar(hino);
		System.out.println("entou no metodo");
		return "sucesso";
	}

}