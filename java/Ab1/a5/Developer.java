import java.lang.reflect.Field;

public class Developer {
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;

    public int method1(int a, String b){
        return 1;
    }
    public int method2(int a, String b){
        return 1;
    }
    public int method3(int a, String b){
        return 1;
    }
    public int method4(int a, String b){
        return 1;
    }
    public int method5(int a, String b){
        return 1;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) throws Exception {
        try {
            this.attribute1 = attribute1;
        }catch (Exception e){
            System.out.println("Attribute1 not set");
            throw e;
        }
//        if (attribute1.equals("a")) {
//                this.attribute1 = attribute1;
//        }
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        if (attribute2.equals("a")) {
            this.attribute2 = attribute2;
        }
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        if (attribute3.equals("a")) {
            this.attribute3 = attribute3;
        }
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        if (attribute4.equals("a")) {
            this.attribute4 = attribute4;
        }
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        if (attribute5.equals("a")) {
            this.attribute5 = attribute5;
        }
    }
}
