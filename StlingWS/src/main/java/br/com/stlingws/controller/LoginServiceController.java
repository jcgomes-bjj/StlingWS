/**
 * 
 */
package br.com.stlingws.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.stlingws.entity.Usuario;
import br.com.stlingws.repository.UsuarioRepository;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
@Path("/loginService")
public class LoginServiceController {

	public LoginServiceController() {
	}

	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	@POST
	@Consumes("application/json")
	@Produces({ "application/json", "application/text-plain" })
	@Path("/login")
	public Response login(Usuario usuario) throws Exception {
		try {
			UsuarioRepository repository = new UsuarioRepository();
			Usuario usuarioBanco = repository.findByEmail(usuario.getEmail());
			if (usuarioBanco != null) {
				if (!usuario.getSenha().equals(usuarioBanco.getSenha())) {
					return Response.status(204).build();
				} else {
					return Response.status(201).entity(usuarioBanco).build();
				}
			} else {
				return Response.status(204).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(404).build();
		}
	}

}
