package com.example.jdk.demo5stream;

import com.example.jdk.demo01Lamdba.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo03StreamFunction {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"赵信", "武则天", "虞姬","项羽","干将莫邪");
        one.stream().forEach(str->
            System.out.println(str)
        );
        long count = one.stream().count();
        System.out.println(count);
    }

    public void testFilter(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"赵信", "武则天", "虞姬","项羽","干将莫邪");
        one.stream().filter(str->
                str.length()==3
        ).forEach( e->
                System.out.println(e)
        );
    }

    @Test
    public void testLimit(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"赵信", "武则天", "虞姬","项羽","干将莫邪");
        one.stream().limit(3).forEach( e->
                System.out.println(e)
        );
    }
    @Test
    public void testSkip(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"赵信", "武则天", "虞姬","项羽","干将莫邪");
        one.stream().skip(2).forEach( e->
                System.out.println(e)
        );
    }
    @Test
    public void testMap(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"11", "22", "33","44","55");
        //Map 可以将一种类型的流转换成另一种类型的流
        one.stream().map(e ->
                Integer.parseInt(e)
        );
    }
    @Test
    public void testSorted1(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"11", "22", "33","44","55");
        one.stream().sorted().forEach( e ->{
            System.out.println(e);
        });
    }
    @Test
    public void testSorted2(){
        List<Integer> one = new ArrayList<>();
        Collections.addAll(one ,33,22,11,44,66,12,29);
        //Map 可以将一种类型的流转换成另一种类型的流
        one.stream().sorted((e1,e2)-> e2 -e1).forEach( e ->{
            System.out.println(e);
        });
    }
    @Test
    public void testDistinct(){
        List<Integer> one = new ArrayList<>();
        Collections.addAll(one ,33,22,11,44,33,22,29);
        one.stream().distinct().forEach(e->{
            System.out.println(e);
        });
    }
    @Test
    public void testDistinct2(){
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18),
                new Person("王昭君", 20),
                new Person("王昭君", 20),
                new Person("西施", 19),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        //对象类型,需要重写对象的hashcode和equals方法
        personStream.distinct().forEach(e->{
            System.out.println(e);
        });
    }
    @Test
    public void testMatch  (){
        List<Integer> one = new ArrayList<>();
        Collections.addAll(one ,33,22,11,44,38,16,29);
        //allMatch 匹配所有,所有元素都需要满足条件
        boolean result = one.stream().allMatch(e -> e > 20);
        //anyMatch 匹配某个元素,只要有一个元素满足条件接口
        boolean result2 = one.stream().anyMatch(e -> e > 20);
        //noneMatch 匹配所有,所有元素都不需要满足条件
        boolean result3 = one.stream().noneMatch(e -> e > 20);
        System.out.println(result);
    }

    @Test
    public void testFind(){
        List<Integer> one = new ArrayList<>();
        Collections.addAll(one ,33,22,11,44,38,16,29);
        Optional<Integer> first = one.stream().findFirst();
        Optional<Integer> any = one.stream().findAny();
        System.out.println(first.get());
    }

    @Test
    public void testMinAndMax() {
        List<Integer> one = new ArrayList<>();
        Collections.addAll(one ,33,22,11,44,38,16,29);
        Optional<Integer> max = one.stream().max((o1,o2)->o1-o2);
        Optional<Integer> min = one.stream().min((o1,o2)->o1-o2);
        System.out.println(max.get());
        System.out.println(min.get());
    }

    @Test
    public void testReduce() {
        List<Integer> one = new ArrayList<>();
        Collections.addAll(one ,4,5,3,9);
        // T reduce(T identity, BinaryOperator<T> accumulator);
        // T identity 默认值
        // BinaryOperator<T> accumulator: 对数据进行处理的方式
        // reduce 如何执行?
        //第一步 将默认值赋值给x,取出集合第一个值赋值给y A1=x+y1
        //第二步 将上一步的结果A1赋值给x,取几个第二个元素赋值给y A2=A1+y2
        //以此类推 ...
        Integer reduce = one.stream().reduce(0, (x, y) -> {
            // 打印具体执行过程
            System.out.println("x="+x+",y="+y);
            return x + y;
        });
        System.out.println("reduce="+reduce);

        //reduce可以用来获取最大值
        Integer reduce1 = one.stream().reduce(0, (x, y) -> {
            return x > y ? x : y;
        });
        System.out.println("reduce1="+reduce1);

    }

    @Test
    public void testMapReduce() {
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18),
                new Person("王昭君", 20),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        //求出所有年龄的总和
        Integer sum = personStream.map(e ->
                e.getAge()
        ).reduce(0, (x, y) -> {
            return x + y;
        });
        Integer sum2 = personStream.map(e ->
                e.getAge()
        ).reduce(0, Integer::sum);

        //找出做大年龄
        Integer max1 = personStream.map(e ->
                e.getAge()
        ).reduce(0, (x, y) -> {
            return x > y ? x : y;
        });
        Integer max2 = personStream.map(e ->
                e.getAge()
        ).reduce(0, Math::max);

        //统计A出现的次数
        Integer count = Stream.of("a", "a", "b", "c", "d", "a").map(s -> {
            if (s == "a") {
                return 1;
            } else {
                return 0;
            }
        }).reduce(0, Integer::sum);
    }

    @Test
    public void testNumericStream(){
        //Integer占用的内存不int多,在stream流操作中会自动装箱拆箱
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        //把大于3的大于出来
        integerStream.filter(e->e>3).forEach(System.out::println);
        //IntStream mapToInt(ToIntFunction<? super T> mapper);
        //IntStream 操作的是int类型的数据,就节省内存,减少自动装箱拆箱
        IntStream intStream1 = integerStream.mapToInt(e -> {
            return e.intValue();
        });

        IntStream intStream2 = integerStream.mapToInt(Integer::intValue);
        intStream2.filter(e->e>3).forEach(System.out::println);
    }

    @Test
    public void testConcat(){
        Stream<Integer> stream1= Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(6, 4, 7, 8, 9);

        //合并和不能操作之前的流
        //合并后,元素可以重复
        Stream<Integer> concat = Stream.concat(stream1, stream2);
        concat.forEach(e->{
            System.out.println(e);
        });
    }

    //综合案例
    public void testDemo(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"赵信", "武则天", "虞姬","项羽","干将莫邪");
        //只要名字只要三个字的,且只要前3个
        one.stream().filter( s->
            s.length() ==3
        ).limit(3).collect(Collectors.toList());
    }

    /**
     * 转换成集合
     */
    public void testStreamToCollection(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one ,"赵信", "武则天", "虞姬","项羽","干将莫邪");
        //将流中的集合收集到集合中
        List<String> toList = one.stream().collect(Collectors.toList());
        Set<String> toSet = one.stream().collect(Collectors.toSet());
        //收集到指定的集合中
        ArrayList<String> arrList = one.stream().collect(Collectors.toCollection(ArrayList::new));
        HashSet<String> hashSet = one.stream().collect(Collectors.toCollection(HashSet::new));
        //将流中的集合收集到数组中
        String[] array = one.stream().toArray(String[]::new);
    }

    /**
     * 转换成集合
     */
    @Test
    public void testStreamToOther(){
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18),
                new Person("王昭君", 21),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        //获取最大值
        Optional<Person> max = personStream.collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
        //最小值
        Optional<Person> min = personStream.collect(Collectors.minBy((s1, s2) -> s1.getAge() - s2.getAge()));
        //求和
        Integer sum = personStream.collect(Collectors.summingInt(s -> s.getAge()));
        //平均值
        Double avg = personStream.collect(Collectors.averagingInt(s -> s.getAge()));
        //统计数量
        Long count = personStream.collect(Collectors.counting());
    }

    @Test
    public void testStreamGroup(){
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18),
                new Person("王昭君", 20),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        //按年龄分组
        Map<Integer, List<Person>> ageMap = personStream.collect(Collectors.groupingBy(s -> s.getAge()));
        Map<Integer, List<Person>> ageMap2 = personStream.collect(Collectors.groupingBy(Person::getAge));
        //按年龄大小
        Map<String, List<Person>> ageMap3 = personStream.collect(Collectors.groupingBy(e -> {
            if (e.getAge() > 19) {
                return "年轻";
            } else {
                return "年长";
            }
        }));
    }
    //对流进行多级分组
    @Test
    public void testStreamGroup2(){
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 19),
                new Person("王昭君", 20),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        //先根据年龄分组,在根据姓名分组
        //groupingBy(Function<? super T, ? extends K> classifier,Collector<? super T, A, D> downstream)
        Map<Integer, Map<String, List<Person>>> collect = personStream.collect(Collectors.groupingBy(Person::getAge,
                Collectors.groupingBy(e -> {
            if (e.getAge() > 19) {
                return "年轻";
            } else {
                return "年长";
            }
        })));
        System.out.println("collect:"+collect.toString());
    }

    @Test
    public void testStreamPartition(){
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 19),
                new Person("王昭君", 20),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        Map<Boolean, List<Person>> collect = personStream.collect(Collectors.partitioningBy(e -> {
            return e.getAge() > 19;
        }));
        System.out.println("collect:"+collect.toString());
    }

    public void testJoin(){
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 19),
                new Person("王昭君", 20),
                new Person("西施", 19),
                new Person("杨玉环", 20));
        //根据一个字符串拼接
        String names = personStream.map(Person::getName).collect(Collectors.joining("_"));
        //根据三个字符串拼接,分隔符,前缀后缀
        personStream.map(Person::getName).collect(Collectors.joining("_","AA","BB"));
        System.out.println("names:"+names);
    }

    @Test
    public void testSerial(){
        Stream.of(1,4,6,7,8,9,2,3).filter(e->{
            System.out.println(Thread.currentThread()+"::"+e);
            return e>3;
        }).count();
    }

    @Test
    public void testParallelStream(){
        ArrayList<Object> list = new ArrayList<>();
        //直接获取并行的stream流
        Stream<Object> stream = list.parallelStream();
        //将串行流变成并行流
        Stream<Object> parallel = list.stream().parallel();

        Stream.of(1,4,6,7,8,9,2,3).parallel().filter(e->{
            System.out.println(Thread.currentThread()+"::"+e);
            return e>3;
        }).count();
    }
    @Test
    public void testParallelStreamNotice(){
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(0,1000).parallel().forEach( e->{
            list.add(e);
        });
        System.out.println("list:"+list.size());
        //解决parallelStream线程安全问题方案一:使用同步代码块
        Object obj = new Object();
        IntStream.rangeClosed(0,1000).parallel().forEach( e->{
            synchronized (obj){
                list.add(e);
            }
        });
        //方案二:使用线程安全的集合
        //Vector<Integer> list2 = new Vector<>();
        Collection<Integer> synchronizedList = Collections.synchronizedCollection(list);
        IntStream.rangeClosed(0,1000).parallel().forEach( e->{
            synchronizedList.add(e);
        });
        //方案三:调用stream的collect/toArray 方法
        List<Integer> collect = IntStream.rangeClosed(0, 1000).parallel().boxed().collect(Collectors.toList());
    }

}
