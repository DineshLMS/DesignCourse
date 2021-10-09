import java.util.ArrayList;

class Participant
{
    int value = 0;
    Mediator mediator;
    public Participant(Mediator mediator)
    {
        // todo
        this.mediator = mediator;
        mediator.subscribe(this);
    }

    public void say(int n)
    {
        // todo
        mediator.broadcast(n,this);
    }

    public void receive(int n){
        value = n;
    }
}

class Mediator
{
    // todo
    ArrayList<Participant> participants = new ArrayList<>();
    public void subscribe(Participant p){
        participants.add(p);
    }

    public void broadcast(int value, Participant source){
        participants.stream().filter(participant -> participant!=source).forEach(participant -> participant.receive(value));
    }

}