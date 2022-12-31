package com.example.testround3.service.cronJob;

import com.example.testround3.model.entity.TableEntity;
import com.example.testround3.responsitory.TableReponsitory;
import com.example.testround3.service.imp.commentsServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledFuture;

@Slf4j
@Component
public class ScheduledTasks  {
    private static final Integer GET_ALL_COMMENT = 1;
    @Autowired private TaskScheduler taskScheduler;
//    @Autowired private
    @Autowired
    private commentsServiceImp commentsServiceImp;
    @Autowired
    private TableReponsitory tableReponsitory;

    private ScheduledFuture<?> scheduledTask;
//    @PostConstruct
    public void scheduleTasks() {

        TableEntity entity = (tableReponsitory.findById(GET_ALL_COMMENT).get());
        log.info(entity.getTimeCron(),"time");
        String timeCron = entity.getTimeCron();
        CronTrigger cronTrigger = new CronTrigger(timeCron);
        scheduledTask = taskScheduler.schedule(commentsServiceImp, cronTrigger);
        System.out.println("-----------------------------GETTTTTTTTTTT-----------------------------"+cronTrigger);
    }
    public void stopTask() {
        // Cancel the scheduled task
        scheduledTask.cancel(false);
    }

}
