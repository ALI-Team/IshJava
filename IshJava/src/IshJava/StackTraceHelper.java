/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IshJava;

/**
 *
 * @author axemat060
 */
public class StackTraceHelper {
    public static void printStackTrace(StackTraceElement ste[]) {
        System.out.println("Stack begin");
        for (int i = 1; i < ste.length; i++) {
            StackTraceElement s = ste[i];
            System.out.print(s.getMethodName() + "(");
            System.out.println(s.getFileName() + ":" + Integer.toString(s.getLineNumber()) + ")");
        }
    }
    
    public static void printStackTrace() {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        System.out.println("Stack begin");
        for (int i = 2; i < ste.length; i++) {
            StackTraceElement s = ste[i];
            System.out.print(s.getMethodName() + "(");
            System.out.println(s.getFileName() + ":" + Integer.toString(s.getLineNumber()) + ")");
        }
    }
}
