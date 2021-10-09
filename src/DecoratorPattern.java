class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    public Bird bird;
    public Lizard lizard;

    Dragon(){
        this(new Bird(),new Lizard());
    }

    Dragon(Bird bird, Lizard lizard){
        this.bird = bird;
        this.lizard = lizard;
    }

    public void setAge(int age)
    {
        // todo
        this.age = age;
        bird.age = age;
        lizard.age = age;

    }
    public String fly()
    {
        // todo
        return bird.fly();

    }
    public String crawl()
    {
        // todo
        return lizard.crawl();
    }
}