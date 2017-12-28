package chapter.twelve.unit.six;

import java.util.Arrays;

/**
 * Created by IDEA.
 * User: e
 * Date: 2017/7/11
 * Comment: Thinking in Java 12.6.3 异常链
 */
public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        return "DynamicFields{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }

        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }

        fields = tmp;
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException dynamicFieldsException = new DynamicFieldsException();
            dynamicFieldsException.initCause(new NullPointerException());
            throw dynamicFieldsException;
        }

        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }

        Object result = null;
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;

        return result;
    }

    public static void main(String[] args) {
        DynamicFields dynamicFields = new DynamicFields(3);
        System.out.println(dynamicFields);

        try {
            dynamicFields.setField("d", "A value of d");
            dynamicFields.setField("number1", 123);
            dynamicFields.setField("number2", 456);
            System.out.println(dynamicFields);

            dynamicFields.setField("d", "A value of d");
            dynamicFields.setField("number3", 789);
            System.out.println(dynamicFields);

            System.out.println("dynamicFields.getField(\"d\")" + dynamicFields.getField("d"));
            Object field = dynamicFields.setField("d", null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}
