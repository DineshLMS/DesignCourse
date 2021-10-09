import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        ValueContainer.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return ValueContainer.super.spliterator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator(this);
    }
}

class CustomIterator implements Iterator<Integer>{

    SingleValue vc;
    CustomIterator(SingleValue value){
        this.vc = value;
    }
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return vc.value;
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{

}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is

    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        // todo
        int sum = 0;
        for (ValueContainer vc:this) {
            Iterator<Integer> iterator = vc.iterator();
            if(vc instanceof SingleValue){
                sum += iterator.next();
            }else {
                while (iterator.hasNext()){
                    sum+=iterator.next();
                }
            }

        }
        return sum;
    }
}