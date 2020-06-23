package services;

import persistence.dao.GenericDao;
import persistence.model.ScheduleModel;

import java.util.List;

public class ScheduleService {

    GenericDao<ScheduleModel> scheduleModelGenericDao = new GenericDao<ScheduleModel>();

    public void addSchedule(ScheduleModel scheduleModel)
    {
        scheduleModelGenericDao.add(scheduleModel);
    }

    public List<ScheduleModel> viewAllSchedules(ScheduleModel scheduleModel){
        return scheduleModelGenericDao.getAll(scheduleModel);
    }

    public void updateSchedule(ScheduleModel scheduleModel){
        scheduleModelGenericDao.update(scheduleModel);
    }
     public void deleteSchedule(ScheduleModel scheduleModel){
        scheduleModelGenericDao.delete(scheduleModel);
     }
}
