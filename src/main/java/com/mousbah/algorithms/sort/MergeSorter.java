package com.mousbah.algorithms.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MergeSorter {

    public static int[] sort(int[] a){
        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
        ForkJoinTask<int[]> submit = forkJoinPool.submit(new MergeSortTask(a));
        return submit.join();
    }

    public static int[] merge(int[]a, int[]b){
        int leftPointer=0;
        int rightPointer=0;
        int[] result=new int[a.length+b.length];
        for(int i=0; i< result.length; i++){
            if(a[leftPointer]<= b[rightPointer]){
                result[i]=a[leftPointer];
                leftPointer++;
            }else if(b[rightPointer]< a[leftPointer]){
                result[i]=b[rightPointer];
                rightPointer++;
            }
            if(leftPointer==a.length){
                for(int j=rightPointer; j<b.length; j++ ){
                    result[++i]=b[j];
                }
            }else if(rightPointer==b.length){
                for(int j=leftPointer; j<a.length; j++ ){
                    result[++i]=a[j];
                }
            }
        }
        return result;
    }

    private static class MergeSortTask extends RecursiveTask<int[]>{


        private static final long serialVersionUID = -3223145400020821586L;

        private int[] a;

        public MergeSortTask(int[] a) {
            this.a = a;
        }

        @Override
        protected int[] compute() {
            if(a.length<=1){
                return a;
            }
            List<MergeSortTask> subTasks = createSubTasks();
            ForkJoinTask.invokeAll(subTasks);
            return merge(subTasks.get(0).join(), subTasks.get(1).join());
        }


        private List<MergeSortTask> createSubTasks(){
            int leftLength=a.length/2;
            int[] left=Arrays.copyOfRange(a, 0, leftLength);
            MergeSortTask leftTask=new MergeSortTask(left);
            MergeSortTask rightTask=new MergeSortTask(Arrays.copyOfRange(a, leftLength, a.length));
            return Arrays.asList(leftTask, rightTask);
        }
    }
}
