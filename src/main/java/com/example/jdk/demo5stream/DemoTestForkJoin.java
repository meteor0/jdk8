package com.example.jdk.demo5stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DemoTestForkJoin {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumRecursiveTesk task = new SumRecursiveTesk(1,1000);
        Long result = task.invoke();
    }
}
class SumRecursiveTesk extends RecursiveTask<Long>{

    private static final long THRESHOLD=3000;
    //起始值
    private final long start ;
    //结束值
    private final long end;

    public SumRecursiveTesk(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //拆分
        long length = end - start;
        if(length<THRESHOLD){
            //计算
            long sum=0;
            for(long i=start;i<=end;i++){
                sum +=i;
            }
            return sum;
        }else{
            long middle = (start + end) / 2;
            SumRecursiveTesk left = new SumRecursiveTesk(start,middle);
            left.fork();

            SumRecursiveTesk right = new SumRecursiveTesk(middle+1,end);
            right.fork();

            return left.join() + right.join();

        }
    }
}
