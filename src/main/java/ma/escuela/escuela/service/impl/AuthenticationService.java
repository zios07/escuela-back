package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Account;
import ma.escuela.escuela.exception.BadCredentialsException;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.repository.AccountRepository;
import ma.escuela.escuela.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public Account authenticate(Account credentials) throws NotFoundException, BadCredentialsException {
		Account account = accountRepo.findByUsername(credentials.getUsername());
		if(account == null || (account.getPassword() != null && !account.getPassword().equals(credentials.getPassword())))
			throw new BadCredentialsException("AUTHENTICATION.ERROR", "Bad credentials");
		return account;
	}

}
