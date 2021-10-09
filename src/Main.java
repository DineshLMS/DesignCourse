public class Main {

    public static void main(String[] args) {
	// Builder Pattern
//        CodeBuilder codeBuilder = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
//        System.out.println(codeBuilder);

        // Factory Pattern
        /*PersonFactory personFactory = new PersonFactory();
        Person dinesh = personFactory.createPerson("Dinesh");
        System.out.println(dinesh);
        Person kumar = personFactory.createPerson("Kumar");
        System.out.println(kumar);*/

        ExpressionProcessor ep =new ExpressionProcessor();
        int calculate = ep.calculate("1");
        System.out.println("value"+calculate);
    }


}
