package com.example.lab12.task2;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Group<Integer> nestedGroup = new Group<>();

        Consumer<String> printConsumer = s -> System.out.println("Processing: " + s);
        Signature<String> printTask = new Signature<>(printConsumer);
        printTask.apply("Hello, Signature!");
        System.out.println("Task ID: " + printTask.getId());

        Signature<Integer> printt = new Signature<>(System.out::println);
        
        nestedGroup.addTask(printt).addTask(new Signature<>(x -> System.out.println(x * x)));
        // Group<Integer> group = new Group<>();
        // group.addTask(nestedGroup).addTask(new Signature<>(x -> System.out.println(x * x * x)));
        // group.apply(10);
    
        nestedGroup.apply(2);
        System.out.println(printt.getHeader("groupID"));
        System.out.println(nestedGroup.groupUuid);

    }
}
