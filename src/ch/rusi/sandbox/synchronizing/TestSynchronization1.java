package ch.rusi.sandbox.synchronizing;

class TestSynchronization1 {

    // See tutorial on https://www.javatpoint.com/synchronization-in-java

    public static void main(String[] args) {

        Table obj = new Table();    //only one object

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t2.start();

    }
}