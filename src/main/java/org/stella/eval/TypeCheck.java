package org.stella.eval;

import org.syntax.stella.Absyn.AProgram;
import org.syntax.stella.Absyn.Program;
import org.syntax.stella.VisitSkel;

public class TypeCheck
{
    public static void typecheckProgram(Program program) throws Exception
    {
        AProgram aProgram = (AProgram) program;
        VisitSkel visitSkel = new VisitSkel();
        String result = visitSkel.checkProgram(aProgram);
        if (result == null) {
            return;
        } else {
            throw new Exception("");
        }
//        System.out.println("typechecker is not implemented!");
//        return;
    }
}
