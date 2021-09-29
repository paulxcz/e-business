package pe.edu.upc.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Rol;
import pe.edu.upc.entities.User;
import pe.edu.upc.entities.UserRol;

public interface IRolDao {
	Integer insert(Rol rol) throws Exception;

	Integer update(Rol rol) throws Exception;

	Integer delete(Rol rol) throws Exception;

	List<Rol> findAll() throws Exception;

	Optional<Rol> findById(Rol rol) throws Exception;

	Integer insertUserRole(List<UserRol> userRoles) throws Exception;

	List<UserRol> findUserRolesByUser(User user) throws Exception;

}
