package com.yisutech.iisp.dataops;

class HelloWorld {

    public static void main(String[] args) {

        // f(() -> System.out.println("OK"));//传lambda表达式 一个匿名函数对应一个方法
        String x = "hellow";
        String y = "____Y";
        g((x0, y0) -> {
            System.out.println(x0 + "," + y0);
            return 0;
        }, x, y);
        //f(A::f);//双冒号 即直接传方法参数 方法必须为静态方法
    }

    public static void g(ReturnTest r, String x, String y) {
        System.out.println(r.f(x, y));
    }


    @FunctionalInterface
    interface ReturnTest<T, U> {
        double f(T str, U u);
    }
}

