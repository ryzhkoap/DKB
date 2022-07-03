package ru.ryzhko.dkb.dao;

import org.springframework.stereotype.Component;
import ru.ryzhko.dkb.models.CodeExample;

import java.util.ArrayList;
import java.util.List;

@Component
public class CodeExampleDAO {
    private static List<ru.ryzhko.dkb.models.CodeExample> codeExample;
    private static int codeCount;
    {
        codeExample = new ArrayList<>();
        codeExample.add(new CodeExample(++codeCount, "Drop string TZ", "Example code TZ"));
        codeExample.add(new CodeExample(++codeCount, "Drop string tree", "Example code Tree"));
        codeExample.add(new CodeExample(++codeCount, "Add in arr", "Example code arr"));
    }
    public static List<CodeExample> index(){
        return codeExample;
    }

    public CodeExample show(int id){
        return codeExample.stream().filter(codeExample -> codeExample.getId() == id).findAny().orElse(null);
    }
}
