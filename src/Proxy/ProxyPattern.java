package Proxy;

class Person
{
    private int age;

    public Person(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson
{
    public int getAge() {
        return person.getAge();
    }

    public void setAge(int age) {
        person.setAge(age);
    }

    public String drink() {
        if(getAge()<18)
            return "too young";
        else
            return person.drink();
    }

    public String drive() {
        if(getAge()<16)
        return "too young";
        else
        return person.drive();
    }

    public String drinkAndDrive() {
        return "dead";
    }

    private Person person;

    public ResponsiblePerson(Person person)
    {
        // todo
        this.person = person;
    }
}
