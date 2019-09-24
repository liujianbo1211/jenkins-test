package com.jianbo.jenkinstest.stream;

import com.jianbo.jenkinstest.test2.User1;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws Exception {


        TestEnum one = TestEnum.ONE;
        one.getValue();

        Class<? extends TestEnum> aClass = one.getClass();
        Field num = aClass.getDeclaredField("num");
        num.setAccessible(true);
        num.set(one,999);

        one.getValue();
    }

    private static void test10() {
        ArrayList list = new ArrayList();
        LinkedList linkedList = new LinkedList();
        test8(list,linkedList);

        Long startTime = System.currentTimeMillis();
        //list.add(500000,111111111);
        //list.add(999999,11111);
        list.remove(500000);
        Long endTime = System.currentTimeMillis();
        System.out.println("List插入中间时间:"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        //linkedList.add(500000,111111111);
        //linkedList.add(999999,11111);
        linkedList.remove(500000);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList插入中间时间:"+(endTime-startTime));
    }

    public static void test8(ArrayList list,LinkedList linkedList ) {
        //list = new ArrayList();
        //linkedList = new LinkedList();
        Long startTime = System.currentTimeMillis();
        for(int i =0 ;i<10000000;i++){
            list.add(i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("List插入时间:"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for(int i =0 ;i<1000000;i++){
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList插入时间:"+(endTime-startTime));
    }

    private static void test7() {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(1L, "肖战", 15, "浙江");
        Student s3 = new Student(1L, "肖战", 15, "浙江");
        Student s4 = new Student(1L, "肖战", 15, "浙江");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        System.out.println(students);
        System.out.println("=======================");
        students.remove(s1);
        System.out.println(students);

    }

    private static void test6() {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.clear();
        //求最大值
        Student student = students.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).get();
        System.out.println(student);

        //匹配
        boolean b = students.stream().anyMatch(o -> "湖北1".equals(o.getAddress()));
        if(b){
            System.out.println("有湖北人");
        }
        boolean b1 = students.stream().allMatch(o -> o.getAge() > 15);
        if(b1){
            System.out.println("所有人的年龄都大于15");
        }
        boolean b2 = students.stream().noneMatch(o -> "肖战1".equals(o.getName()));
        if(b2){
            System.out.println("没有叫肖战1的人");
        }

    }

    private static void test5() {
        //聚合
        List<String> strings = Arrays.asList("欢", "迎", "你");
        String reduce = strings.stream().reduce("北京", (a, b) -> a + b);
        System.out.println(reduce);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        Optional<Integer> reduce2 = integers.stream().reduce((a, b) -> a + b);
        System.out.println(reduce2.get());

        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(11L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        Student s5 = new Student(7L, "肖战", 15, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        Student reduce1 = students.stream().reduce(new Student(71L, "肖战1", 1111, "浙江1"), (a, b) -> a);
        System.out.println(reduce1);
    }

    private static void test4() {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(11L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        Student s5 = new Student(7L, "肖战", 15, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        //排序
        //students.stream().sorted((o1,o2)-> (int) (o1.getId()-o2.getId())).limit(2).forEach(System.out::println);
        //删除前面元素
        students.stream().sorted((o1,o2) -> Long.compare(o1.getId(),o2.getId())).skip(2).limit(1).forEach(System.out::println);
    }

    private static void test3() {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(11L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        Student s5 = new Student(7L, "肖战", 15, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.stream().distinct().forEach(System.out::println);
    }

    private static void test2() {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        List<String> collect = students.stream().map(s -> "住址:" + s.getAddress()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("-----------");
        collect.stream().distinct().forEach(System.out::println);

    }

    /**
     * filter 筛选
     */
    public static void test1(){
        Student s1 = new Student(1l,"肖战",15,"浙江");
        Student s2 = new Student(2l,"王一博",15,"湖北");
        Student s3 = new Student(3l,"杨紫",17,"北京");
        Student s4 = new Student(4l,"lixian",17,"浙江");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        //筛选年龄大于15岁的学生
        List<Student> collect = list.stream().filter(s -> s.getAge() > 15).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
