package com.lds.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(String hino) {
		HinoDAO hinoDAO = new HinoDAO();
		Hino novoHino = new Gson().fromJson(hino, Hino.class);
		hinoDAO.salvar(novoHino);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void remover(@PathParam("id") int id) {
		HinoDAO hinoDAO = new HinoDAO();
		hinoDAO.remover(new Long(id));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/selecionar/{id}")
	public String buscarHino(@PathParam("id") int id) {
		HinoDAO hinoDAO = new HinoDAO();
		Hino hino = hinoDAO.carregarHino(new Long(id));
		if (hino == null) {
			throw new WebApplicationException(Response.status(404).entity("ERROR 404 - HINO BROKEN").build());
		}
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String hinoGson = gson.toJson(hino).toString();
		return hinoGson;
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void atualizar(String hino) {
		HinoDAO hinoDAO = new HinoDAO();
		Hino hinoAtualizado = new Gson().fromJson(hino, Hino.class);
		hinoDAO.atualizarHino(hinoAtualizado);
	}
	
}
