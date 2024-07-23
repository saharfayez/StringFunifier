package test;

import main.interafces.Impl.BaseClass;
import main.interafces.Operation;
import main.operations.CompressionOperation;
import main.operations.ReverseOperation;
import main.operations.SortingOperation;
import main.operations.UpperCaseOperation;
import main.stringfunifier.StringFunifier;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class StringFunifierTest {



    @Test
    void getStringFunifier() throws InterruptedException, ExecutionException {
        String string= "ccchHJKkklmlmmml";
        String stringExpected = "c(1h2c)H(J)K(k2l1m1)(l1m1)(2M)l";


        List<Integer> startIndexes = List.of(1 , 5,7,11,13);
        List<Integer> endIndexes = List.of(3 , 5 , 10 , 12,14);
        List<Operation> operations = List.of(
                new ReverseOperation( new CompressionOperation(new BaseClass())),
                new UpperCaseOperation( (new BaseClass())),
                new CompressionOperation( new UpperCaseOperation(new SortingOperation(new BaseClass()))),
                new CompressionOperation(new BaseClass()),
                new ReverseOperation(new UpperCaseOperation(new CompressionOperation(new BaseClass())))

        );


        StringFunifier object1 = new StringFunifier(string ,  startIndexes, endIndexes , operations);
        String string2 = object1.getStringFunifier();


        assertEquals(stringExpected, string2);

    }
}