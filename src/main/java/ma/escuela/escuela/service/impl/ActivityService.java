package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Activity;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.ActivityRepository;
import ma.escuela.escuela.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService implements IActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity addActivity(Activity activity) throws ServiceException {
        return activityRepository.save(activity);
    }

    @Override
    public Activity findActivity(long id) throws NotFoundException {
        Optional<Activity> activityOptional = activityRepository.findById(id);
        if(!activityOptional.isPresent())
            throw new NotFoundException("ACTIVITY.NOT.FOUND", "Activity not found with id : " + id);
        return activityOptional.get();
    }

    @Override
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void deleteActivity(long id) throws NotFoundException {
        activityRepository.deleteById(id);
    }

    @Override
    public Activity updateActivity(Activity activity) throws NotFoundException {
        return activityRepository.save(activity);
    }
}
