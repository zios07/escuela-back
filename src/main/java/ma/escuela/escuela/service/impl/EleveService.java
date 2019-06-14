package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Eleve;
import ma.escuela.escuela.domain.User;
import ma.escuela.escuela.dto.ProfileDTO;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.EleveRepository;
import ma.escuela.escuela.service.IEleveService;
import ma.escuela.escuela.service.IRoleService;
import ma.escuela.escuela.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveService implements IEleveService {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EleveRepository eleveRepository;

    @Override
    public Eleve addEleve(Eleve eleve) throws ServiceException, NotFoundException {
        if (eleve.getAccount() != null && eleve.getAccount().getUsername() != null)
            if (eleveRepository.findByAccountUsername(eleve.getAccount().getUsername()) != null) {
                throw new ServiceException("USERNAME.ALREADY.EXISTS", "Username already exists");
            }
        eleve.setRole(roleService.getRoleEleve());
        if (eleve.getAccount() != null) {
            eleve.getAccount().setPassword(passwordEncoder.encode(eleve.getAccount().getPassword()));
        }
        String parentUsername = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User parent = userService.findUserByUsername(parentUsername);
        eleve.setParent(parent);
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve findEleve(long id) throws NotFoundException {
        Optional<Eleve> eleveOptional = eleveRepository.findById(id);
        if (!eleveOptional.isPresent())
            throw new NotFoundException("ELEVE.NOT.FOUND", "Eleve not found with id : " + id);
        return eleveOptional.get();
    }

    @Override
    public List<Eleve> findAllEleves() {
        return eleveRepository.findAll();
    }

    @Override
    public void deleteEleve(long id) throws NotFoundException {
        eleveRepository.deleteById(id);
    }

    @Override
    public List<Eleve> searchEleves(Eleve eleveDto) throws NotFoundException {
        return null;
    }

    @Override
    public Eleve updateEleve(Eleve eleve) throws NotFoundException {
        Eleve oldEleve = eleveRepository.findByAccountUsername(eleve.getAccount().getUsername());
        eleve.setId(oldEleve.getId());
        eleve.getAccount().setId(oldEleve.getAccount().getId());
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve findEleveByUsername(String username) throws NotFoundException {
        return eleveRepository.findByAccountUsername(username);
    }

    @Override
    public Eleve getConnectedEleve() throws NotFoundException {
        return null;
    }

    @Override
    public Eleve updateEleveProfile(ProfileDTO eleve) {
        return null;
    }

    @Override
    public List<Eleve> findElevesByParent(Long parentID) {
        if(parentID != -1) {
            return eleveRepository.findByParentId(parentID);
        } else {
            String parentUsername = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return eleveRepository.findByParentAccountUsername(parentUsername);
        }
    }
}
