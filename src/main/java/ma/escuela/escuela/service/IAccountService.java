package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Account;
import ma.escuela.escuela.exception.NotFoundException;

import java.util.List;

public interface IAccountService {

	Account addAccount(Account accountd);

	Account findAccount(long id) throws NotFoundException;

	List<Account> findAllAccounts();

	void deleteAccount(long id) throws NotFoundException;

	List<Account> searchAccounts(Account account) throws NotFoundException;
	
	Account findAccountByUsername(String username) throws NotFoundException;
}
