package aiwd.util;

import aiwd.model.DataRow;
import aiwd.model.DescriptiveStatisticOfAttribute;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DescriptiveStatisticOfAttributesFactory {

    public static List<DescriptiveStatisticOfAttribute> createDescriptiveStatisticOfAttributes(){
        List<DescriptiveStatisticOfAttribute> attributes = new ArrayList<>();
        for(Field field:DataRow.class.getDeclaredFields()){
            attributes.add(new DescriptiveStatisticOfAttribute<>(field.getName(),field.getType()));
        }
        return attributes;
    }
}
