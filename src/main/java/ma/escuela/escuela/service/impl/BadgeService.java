package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Badge;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.BadgeRepository;
import ma.escuela.escuela.service.IBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadgeService implements IBadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Override
    public Badge addBadge(Badge badge) throws ServiceException {
        return badgeRepository.save(badge);
    }

    @Override
    public Badge findBadge(long id) throws NotFoundException {
        Optional<Badge> badgeOptional = badgeRepository.findById(id);
        if (!badgeOptional.isPresent())
            throw new NotFoundException("BADGE.NOT.FOUND", "Badge not found with id : " + id);
        return badgeOptional.get();
    }

    @Override
    public List<Badge> findAllBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public void deleteBadge(long id) throws NotFoundException {
        badgeRepository.deleteById(id);
    }

    @Override
    public Badge updateBadge(Badge badge) throws NotFoundException {
        return badgeRepository.save(badge);
    }
}
