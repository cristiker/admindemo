package com.cristik.thread;

import com.cristik.thread.test.ConnectionManager;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Package: com.cristik.thread.ThreadLocalTest
 * @ClassName: ThreadLocalTest.java
 * @Description:
 * @Author: zhenghua
 * @CreateDate: 2016/6/12 10:14
 * @Version: v1.0
 */
public class ThreadLocalTest {

    @Test
    public void testRunnable() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ConnectionManager.setId(1234);
                Integer id = ConnectionManager.getId("1");
                System.out.println(id);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ConnectionManager.setId(4321);
                Integer id = ConnectionManager.getId("2");
                System.out.println(id);
            }
        });

        thread1.start();
        thread2.start();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCallable(){
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("has been called");
                return 1;
            }
        });
        System.out.println(task.isDone());
        Thread thread = new Thread(task);
        thread.run();
        try {
            System.out.println(task.get());
            System.out.println(task.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInitThread(){
        Thread thread = new Thread();
        thread.run();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testJsonNode(){

    }



}
