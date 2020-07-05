package de.draegerit.wms.quartz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzJobsListener implements ServletContextListener {
	private Scheduler scheduler;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent ctx) {
		JobDetail job = JobBuilder.newJob(WarningProduktQuartzJob.class).withIdentity("myJob", "group1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(100).repeatForever()).build();

//
//		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "group1")
//				.withSchedule(CronScheduleBuilder.cronSchedule("0 6 * * *")).forJob("myJob").build();

		try {
			scheduler = ((StdSchedulerFactory) ctx.getServletContext()
					.getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY)).getScheduler();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {

		}
	}
}