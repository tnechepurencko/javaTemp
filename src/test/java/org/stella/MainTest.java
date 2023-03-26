package org.stella;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class MainTest {


    @ParameterizedTest(name = "{index} Typechecking well-typed program {0}")
    @ValueSource(strings = {
            "tests/well-typed/factorial.stella",
            "tests/well-typed/squares.stella",
            "tests/well-typed/increment_twice.stella",
            "tests/well-typed/logical-operators.stella"})
    public void testWellTyped(String filepath) throws IOException, Exception {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File(filepath));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }

    @ParameterizedTest(name = "{index} Typechecking ill-typed program {0}")
    @ValueSource(strings = {
            "tests/ill-typed/bad-custom.stella",
            "tests/ill-typed/bad-squares-1.stella",
            "tests/ill-typed/bad-squares-2.stella"})
    public void testIllTyped(String filepath) throws IOException, Exception {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File(filepath));
        System.setIn(fips);
        try {
            Main.main(args);
            throw new Exception("expected the typechecker to fail!");
        } catch (Exception e) {
            System.out.println("WRONG");
            // TODO: check that there is a type error actually, and not a problem with implementation
        }
        System.setIn(original);
    }
}
