import java.util.ArrayList;

class Field{
    String fieldType;
    String fieldName;

    public Field(String fieldName, String fieldType) {
        this.fieldType = fieldType;
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  public "+ fieldType+" "+fieldName+";\n");
        return sb.toString();
    }
}

class CodeBuilder
{
    String className;

    ArrayList<Field> fields = new ArrayList<Field>();
    public CodeBuilder(String className)
    {
        // todo
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        Field newField = new Field(name, type);
        fields.add(newField);
        return this;
    }

    @Override
    public String toString()
    {
        // todo
        StringBuilder sb = new StringBuilder();
        sb.append("public class "+ className+"\n{\n");
        fields.forEach(field -> sb.append(field.toString()));
        sb.append("}");
        return sb.toString();
    }
}


