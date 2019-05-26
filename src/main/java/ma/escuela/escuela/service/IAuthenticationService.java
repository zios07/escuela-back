package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Account;
import ma.escuela.escuela.exception.BadCredentialsException;
import ma.escuela.escuela.exception.NotFoundException;

public interface IAuthenticationService {

	Account authenticate(Account account) throws NotFoundException, BadCredentialsException;
}
