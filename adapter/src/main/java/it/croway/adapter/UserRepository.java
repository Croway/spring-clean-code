package it.croway.adapter;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.croway.project.IUserRepository;
import it.croway.project.User;

@Repository
public interface UserRepository extends IUserRepository, PagingAndSortingRepository<User, String> {

	@Modifying
	@Query("UPDATE User SET name = ?2 WHERE username = ?1")
	public void updateName(String user, String newName);
}
