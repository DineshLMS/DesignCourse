class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory
{
    static int index = 0 ;
    public Person createPerson(String name)
    {
        // todo
        Person person = new Person(index++, name);
        return person;
    }
}
