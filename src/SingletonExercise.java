import java.util.function.Supplier;

class SingletonTester
{
    public static boolean isSingleton(Supplier<Object> func)
    {
        Object o = func.get();
        Object o1 = func.get();
        return o == o1;
        // todo
    }
}
