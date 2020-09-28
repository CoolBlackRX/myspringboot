package schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaohq
 * @date 2020/8/26
 */
public class ScheduleTest {
    /**
     * ----------------------
     * Java实现定时任务Schedule
     * ----------------------
     * 实现任务执行的次数，是在方法后面加上
     * Thread。sleep(执行的time)
     * Timer.cancle()删除当前的所有任务
     * TimerTask.cancle()删除当前的task任务
     * ----------------------------------
     * 前四种方法是使用Timer来实现
     * --------------------------------
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:hh-mm-ss");

    public static void main(String[] args) throws InterruptedException {
        /**
         * ---------------------------
         * 下面是Timer实现定时任务
         * ---------------------------
         */
        //ScheduleByTimerTaskDate();
        //-------------------------
        //考虑一下二者的区别
        //ScheduleByTimerTaskDelay();
        //ScheduleAtFixedRate();
        //------------------------
        //scheduleAtFixedRateFirstTime();

        //===================================
        /**
         * Thread利用while模拟定时任务
         */
        //ThreadSchedule();
        //=================================
        /**
         * 使用ScheduledExecutorService
         * 执行定时任务
         */
        ScheduledExecutorService();

    }

    /**
     * -----------------------------------
     * 第一种方法：
     * 设定指定任务task在指定延迟时间delay执行任务
     * schedule(TimerTask task, Date time)
     * ----------------------------------
     */
    public static void ScheduleByTimerTaskDate() throws InterruptedException {
        System.out.println("第一种方法");
        Timer timer = new Timer();
        System.out.println("两秒后定时任务执行");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(simpleDateFormat.format(date));
            }
        }, 2000);
        // 设定指定的时间time,此处为2000毫秒
        Thread.sleep(5000);
        timer.cancel();
    }

    /**
     * --------------------------------------------------
     * 第二种方法：
     * 设定指定任务task在指定延迟delay后
     * 进行固定延迟peroid的执行
     * schedule(TimerTask task, long delay, long period)
     * --------------------------------------------------
     */
    public static void ScheduleByTimerTaskDelay() throws InterruptedException {
        System.out.println("第二种方法");
        Timer timer = new Timer();
        System.out.println("设置先延迟一秒，然后在特定的时间间隔循环执行任务，直到被终止");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(simpleDateFormat.format(date));
            }
        }, 1000, 1000);
        Thread.sleep(5000);
        timer.cancel();
    }

    /**
     * -----------------------------------------------------------
     * 第三种方法：
     * 设定指定任务task在指定延迟delay后
     * 进行固定频率peroid的执行。
     * scheduleAtFixedRate(TimerTask task, long delay, long period)
     * -----------------------------------------------------------
     */
    public static void ScheduleAtFixedRate() throws InterruptedException {
        System.out.println("第三种方法");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(simpleDateFormat.format(date));
            }
        }, 1000, 1000);
        Thread.sleep(5000);
        timer.cancel();
    }

    /**
     * ------------------------------------------------------------------------
     * 第四种方法：
     * 安排指定的任务task
     * 在指定的时间firstTime开始
     * 进行重复的固定速率period执行．
     * Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
     * ------------------------------------------------------------------------
     * 如果设置的时间已经过去，
     * Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
     * 会把缺的任务补上，人后周期性执行固定间隔时间的任务
     * ------------------------------------------------------------------------
     */
    public static void scheduleAtFixedRateFirstTime() throws InterruptedException {
        System.out.println("第四种方法");
        Calendar calendar = Calendar.getInstance();
        // 控制时
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        // 控制分
        calendar.set(Calendar.MINUTE, 30);
        // 控制秒
        calendar.set(Calendar.SECOND, 50);
        // 得出执行任务的时间,此处为今天的10：11：00
        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(simpleDateFormat.format(date));
            }
        }, time, 1000);
        // 这里设定将延时每秒固定执行
        Thread.sleep(5000);
        timer.cancel();
    }


    /**
     * ------------------------------
     * 使用线程模拟定时任务，
     * 利用while循环来周期性执行Thread
     * 然后利用thread.sleep()方法结束任务
     * ------------------------------
     * 下面的sleep模拟定时间隔执行任务
     * ------------------------------
     */
    public static void ThreadSchedule() {
         final long timeInterval = 1000;
         /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // ------- code for task to run
                    Date date = new Date();
                    System.out.println(simpleDateFormat.format(date));
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        */
        //上面循环实现执行周期型任务
        // 给它加上一个执行任务的时间，可以理解为执行多少次任务


        Runnable runnable = new Runnable() {
            int times = 0;
            @Override
            public void run() {
                while (times < 5) {
                    // ------- code for task to run
                    times++;
                    Date date = new Date();
                    System.out.println(simpleDateFormat.format(date));
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }


    public static void ScheduledExecutorService() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(simpleDateFormat.format(date));

            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable,1000,1000, TimeUnit.MILLISECONDS);
        System.out.println("我准备休眠五秒");
        Thread.sleep(5000);
        System.out.println("我休眠了五秒");
        service.shutdown();
    }
}
