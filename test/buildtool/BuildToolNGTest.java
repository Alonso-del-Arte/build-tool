/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildtool;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Alonso del Arte
 */
public class BuildToolNGTest {
    
    private static final String FILE_NAME_ARG = "BuildTargetDescription.md";
    
    /**
     * Test of the main procedure of the BuildTool class.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {FILE_NAME_ARG};
        BuildTool.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Another test of the main procedure of the BuildTool class.
     */
    @Test
    public void testMainSourceOnly() {
        System.out.println("main");
        String[] args = {FILE_NAME_ARG, "-src"};
        BuildTool.main(args);
        fail("Haven't written the test yet");
    }
    
    /**
     * Another test of the main procedure of the BuildTool class.
     */
    @Test
    public void testMainIncremental() {
        System.out.println("main");
        String[] args = {FILE_NAME_ARG, "-incr"};
        BuildTool.main(args);
        fail("Haven't written the test yet");
    }
    
}
