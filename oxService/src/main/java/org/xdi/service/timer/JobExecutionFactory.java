package org.xdi.service.timer;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

/**
 * @author Yuriy Movchan Date: 04/04/2017
 */
@Dependent
public class JobExecutionFactory implements JobFactory {

    @Inject
    private JobExecutionDelegate jobExecutionDelegate;

    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        return jobExecutionDelegate;
    }

}
