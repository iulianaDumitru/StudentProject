package services;

import persistence.dao.GenericDao;
import persistence.model.ScheduleModel;

public class ScheduleService {

    GenericDao<ScheduleModel> scheduleModelGenericDao = new GenericDao<ScheduleModel>();

    public void addSchedule(ScheduleModel scheduleModel)
    {
        scheduleModelGenericDao.add(scheduleModel);
    }



}
