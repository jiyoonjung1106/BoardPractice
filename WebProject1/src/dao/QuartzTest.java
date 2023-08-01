package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public void startScheduler()  throws Exception {
	    SchedulerFactory sf = new StdSchedulerFactory();
	    Scheduler sched = sf.getScheduler();

	    JobDetail job = JobBuilder.newJob(MyJob.class)
	                              .withIdentity("myjob", "group1")
	                              .build();

	    Trigger trigger = TriggerBuilder.newTrigger()
	                                    .withIdentity("myTrigger", "group1")
	                                    .startNow()
	                                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
	                                        .withIntervalInSeconds(3)
	                                        .repeatForever())
	                                    .build();

	    sched.scheduleJob(job, trigger);

	    System.out.println("<<<포인트 스케줄러가 시작되었습니다.>>>");

	    sched.start();

	    PointDao dao = new PointDao();
    	dao.pointPlus();
    	
	    for (int i = 0; i < 4; i++) {
	    	
            Date startTime = new Date();
            Thread.sleep(20000);
            Date endTime = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            String startTimeStr = sdf.format(startTime);
            String endTimeStr = sdf.format(endTime);

            System.out.println("Job이 실행됨: " + i + "명에게 포인트 부여(1점), 시작 시간: " + startTimeStr + ", 종료 시간: " + endTimeStr);
        }

	}
	
	public void stopScheduler() throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        sched.shutdown();

        System.out.println("<<<스케줄러의 실행이 종료되었습니다.>>>");
    }

}



