package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Rol;
import pe.edu.upc.entities.User;
import pe.edu.upc.entities.UserRol;

public interface IRolService {
	
	Integer insert(Rol rol) throws Exception;

	Integer update(Rol rol) throws Exception;

	Integer delete(Rol rol) throws Exception;

	List<Rol> getAll() throws Exception;

	Optional<Rol> getOne(Rol rol) throws Exception;

	Integer assignRolesToUser(User user, List<Rol> roles) throws Exception;

	List<UserRol> findUserRolesByUser(User user) throws Exception;

}
