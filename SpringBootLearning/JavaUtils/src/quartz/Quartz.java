package quartz;

import org.quartz.*;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * 定时任务管理器
 *
 * @author zhaohq
 * @date 2020/8/26
 */
public class Quartz {

    private Calendar calendar;
    private Date date;
    private String myJob = "MyJob";
    private String myGroup = "MyGroup";
    private String myTrigger = "MyTrigger";

    public Quartz(Calendar calendar, Date date) {
        this.calendar = calendar;
        this.date = date;
    }

    public Quartz() {
    }

    public Date initCalendar() {
        // 控制时
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        // 控制分
        calendar.set(Calendar.MINUTE, 30);
        // 控制秒
        calendar.set(Calendar.SECOND, 50);
        date = calendar.getTime();
        return date;
    }

    public void MyExplain() throws SchedulerException {

        /**
         * 实例化具体的任务
         */
        JobDetail jobDetail2 = JobBuilder.newJob(HelloJob.class)
                .withIdentity("MyJob", "InfoCenter")
                .build();
        JobDetail jobDetail = newJob(HelloJob.class)
                .withIdentity("MyJob", "InfoCenter")
                .build();
        /**
         * 任务的触发器
         */
        CronTrigger trigger = newTrigger()
                .withIdentity("MyTrigger", "InfoCenter")
                .startAt(initCalendar())
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        /**
         * 创建Scheduler调度器的两种方式
         */
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler1 = schedulerFactory.getScheduler();

        DirectSchedulerFactory factory = DirectSchedulerFactory.getInstance();
        Scheduler scheduler2 = factory.getScheduler();

    }


    public void quartzDemo() throws SchedulerException {
        /**创建调度器*/
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        /**引入任务程序*/
        JobDetail job = JobBuilder
                .newJob(HelloJob.class)
                .withIdentity(myJob, myGroup)
                .build();

        /**设置作业启动时间*/
        Long currentTime= System.currentTimeMillis();
        Date startDate = new Date(currentTime);

        /**创建一个触发器*/
        CronTrigger trigger = (CronTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity(myTrigger, myGroup)
                .startAt(startDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        /**任务和触发器设置到调度器中*/
        scheduler.scheduleJob(job,trigger);

        /**启动调度器*/
        scheduler.start();
    }

    public static void main(String[] args) throws SchedulerException {
        Quartz quartz = new Quartz();
        quartz.quartzDemo();
    }

}

class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /**
         * 要执行的业务逻辑
         */
        Date date = new Date();
        System.out.println("HelloJob " + new SimpleDateFormat("yyyy-MM-dd:hh-mm-ss").format(date));
    }

}
