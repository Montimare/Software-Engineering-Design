import java.util.ArrayList;

class UlamFunction {
    public static void main(String[] args) {
        //final int end = 1000000;
//        ArrayList results = new ArrayList();
//
//        System.out.println(Integer.MAX_VALUE);
        //for (int j = 1; j < 10; j++) {
            for (int i = 1; i < 1000000; i++) {
                //results.add(Worker.ulamFunction(i));
                long n = i/* *j */;
                while (n != 1) {
                    if (n % 2 == 0) {
                        n /= 2;
                    } else {
                        n = (n * 3) + 1;
                    }
                }
                System.out.println("finished" + i);
            }
        //}
//        for(Object item:results){
//            System.out.print(item + " ");
//        }
    }
}

//class Worker {
//    public static boolean ulamFunction(int n) {
//        while (n != 1) {
//            if (n % 2 == 0) {
//                n /= 2;
//            } else {
//                n = (n * 3) + 1;
//            }
//        }
//        return true;
//    }
//}