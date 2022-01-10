package xie.zh.springbootjuc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
class SpringBootJucApplicationTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程编排
        // 1. 创建可控线程池
        /**
         * 七大参数
         * int corePoolSize, 核心线程数 （创建好之后就被创建的线程数量，等待接收异步线程任务）
         * int maximumPoolSize, 最大线程数 （控制资源）
         * long keepAliveTime, 存活时间 （当前正在运行的线程数量大于核心数量，非核心线程数的存活时间）
         * TimeUnit unit, 时间单位 （存活时间的单位）
         * BlockingQueue<Runnable> workQueue, 阻塞队列 （如果任务有很多，就会将目前多的任务放在队列里面，
         *                                              只要有线程空闲，就会去队列里面取出新的任务执行）
         * ThreadFactory threadFactory, 线程的创建工厂 （可以自定义名字）
         * RejectedExecutionHandler handler 如果队列满了按照指定的拒绝策略拒绝执行任务
         *
         * 工作顺序：
         * 1） 工作线程创建，准备core数量的核心线程，准备接受任务
         * 1.1、 core满了，就将再进来的任务放到阻塞队列中。空闲的core就会自己去阻塞队列获取任务执行
         * 1.2、阻塞队列满了，就直接开新线程执行，最大只能开到max指定的数量
         * 1.3、max满了就用RejectExecutionHandler拒绝任务
         * 1.4、max都执行完成，有很多空闲。在指定的时间keepAliveTime以后，释放max-core线程
         *
         *      new LinkedBlockingDeque<>(): 默认是Integer的最大值。内存不够（压力测试获取峰值）
         *
         * 一个线程池 core 7 ，max 20 ，queue 50 ,100并发怎么分配
         * 7个会立即执行，50个会进入队列，再开13个进行执行。剩下的30个就使用拒绝策略。
         *
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                200,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        CompletableFuture<Double> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("方法1完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1D);
            return 3D;
        }, executor);
        CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("方法2完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1D);
            return 3D;
        }, executor);
        CompletableFuture<Double> cf3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("方法3完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1D);
            return 3D;
        }, executor);
        CompletableFuture<Void> all = CompletableFuture.allOf(cf1, cf2, cf3);
        System.out.println("异步方法提交成功");
        all.join();
        System.out.println("方法结束");
    }
}
