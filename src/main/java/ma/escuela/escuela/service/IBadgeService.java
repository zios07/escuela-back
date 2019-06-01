package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Badge;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IBadgeService {

    Badge addBadge(Badge badge) throws ServiceException;

    Badge findBadge(long id) throws NotFoundException;

    List<Badge> findAllBadges();

    void deleteBadge(long id) throws NotFoundException;

    Badge updateBadge(Badge badge) throws NotFoundException;

}
