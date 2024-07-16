class Outer2{

    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i){
        int num = 10;

        class MyRunnable implements Runnable{

            int localNum = 1000;

            @Override
            public void run() {
               // i = 50;   오류가 남, getRunnable메서드가 호출 되는 시점이랑 MyRunnable클래스의 호출 시점이 달라서 오류가 난다.
               // num = 20; i, num은 메서드가 호출이 되면 stack에 올라가고 메서드가 호출 되고 끝이 나면 i, num은 없어진다. 그런데
                //          MyRunnable클래스의 run메서드는 또 호출 될 수 있다. 그때 i, num이 없을 수가 있기 때문에 오류가 난다.

                System.out.println("i =" + i);  // 출력 할 때는 오류가 안남
                System.out.println("num = " +num);  //
                System.out.println("localNum = " +localNum);

                System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outter.sNum = " + Outer2.sNum + "(외부 클래스 정적 변수)");

            }
        }
        return new MyRunnable();
    }
}

public class AnonymousInnerTest {
    public static void main(String[] args) {

        Outer2 out = new Outer2();

        Runnable runner = out.getRunnable(100);

        runner.run();
    }
}
