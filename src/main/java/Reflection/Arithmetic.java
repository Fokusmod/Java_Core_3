package Reflection;

@ClassForTest
public class Arithmetic {
    private final int a;
    private final int b;


    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Arithmetic() {
        this.a = 10;
        this.b = 10;
    }

    @Test(priority = 3)
    public int sum() {
        return a + b;
    }

    @Test(priority = 6)
    public int mul() {
        return a * b;
    }

    @Test(priority = 10)
    public int sub() {
        return a - b;
    }


    public float div() {
        return (float) a / b;
    }


    public float divAndSum() {
        return (float) a / b + (float) a / b;
    }


    @BeforeSuite
    public String before() {
        return "Всегда выполняется до начала теста";
    }

    @AfterSuite
    public String after() {
        return "Всегда выполняется после теста";
    }

}
