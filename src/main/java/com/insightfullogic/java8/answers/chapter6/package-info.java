package com.insightfullogic.java8.answers.chapter6;

/**
 * Question 1:
 *  see SerialToParallel
 *
 * Question 2:
 *  See BuggyReduce
 *
 * Question 3:
 *  See OptimisationExampleFixed
 *
 *
 *
 * 知识点补充
 *
 *  1. 并行和并发
 *      并发是两个任务共享时间段，并行是两个任务在同一时间发生
 *
 *  2.数据并行化
 *      是指将数据分成块，为每块数据分配单独的处理单元。
 *    任务并行化
 *      在任务并行化中，线程不同，任务不同。
 *
 *  3.Java 8 并行化操作
 *      如果已经有一个Stream对象，调用它的parallel方法
 *      从集合创建并行流：parallelStream方法
 *
 *  4.蒙特卡洛模拟法
 *
 *  5.影响并行流性能的5个因素
 *      数据大小
 *      源数据结构
 *      装箱
 *      核的数量
 *      单元处理开销
 *
 *
 *      数组、ArrayList、IntStream.range等数据结构支持随机读取，性能好！
 *      HashSet、TreeSet等数据结构不容易被公平地分解，性能一般
 *      LinkedList、Stream.iterate、BufferedReader.lines等性能差
 *
 *   6.尽量避开有状态，选用无状态操作。
 *      无状态操作包括：map、flatMap、filter等
 *      有状态操作包括：sorted 、distinct、limit等
 *
 *   7.并行化数组操作
 *      工具类Arrays中
 *      parallelPrefix：任意给定一个函数，计算数组的和
 *      parallelSetAll：使用 Lambda 表达式更新数组元素
 *      parallelSort：并行化对数组元素排序
 *
 *
 */
