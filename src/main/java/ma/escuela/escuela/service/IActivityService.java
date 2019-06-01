package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Activity;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IActivityService {

    Activity addActivity(Activity activity) throws ServiceException;

    Activity findActivity(long id) throws NotFoundException;

    List<Activity> findAllActivities();

    void deleteActivity(long id) throws NotFoundException;

    Activity updateActivity(Activity activity) throws NotFoundException;

}
