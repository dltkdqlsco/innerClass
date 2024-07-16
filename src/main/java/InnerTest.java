class OutClass{
    private int num = 10;
    private static int sNum = 20;
    private InClass inClass;

    public OutClass(){
        inClass = new InClass();
    }

    // instance inner class
    private class InClass{
        int iNum = 100;

        void inTest(){
            // 모든 변수를 다 사용 할 수 있다.
            System.out.println("OutClass num = " +num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 클래스의 인스턴스 변수)");
        }
    }

    public void usingClass(){
        inClass.inTest();
    }

    // static inner class
    static class InStaticClass{
        int iNum = 100;
        static int sInNum = 200;


        void inTest(){
            // 외부 클래스의 인스턴스 변수를 사용 할 수 없다.(num를 사용 할 수 없다.)

            System.out.println("OutClass num = " + iNum + "(내부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + sInNum + "(내부 클래스의 스태틱 변수)");
        }

        static void sTest(){
            // 정적 클래스의 정적 메서드에서는 내부나 외부의 static 변수만 쓸 수 있다.

            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + sInNum + "(내부 클래스의 스태틱 변수)");
        }
    }
}

public class InnerTest {
    public static void main(String[] args) {

        /*OutClass outClass = new OutClass();
        outClass.usingClass();
         */

        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        sInClass.inTest();

        System.out.println();

        OutClass.InStaticClass.sTest();
    }
}
