import java.io.BufferedReader;
import java.util.Scanner;

public interface Instruction {

    public void exec(PMachine pMachine);

    /*
    instruction : 'ADD' | 'SUB' | 'MUL' | 'DIV' |
    'EQL' | 'NEQ'| 'GTR' | 'LSS' | 'GEQ' | 'LEQ' |
    'PRN' | 'INN' |
    'INC' ('-')? INT |
    'LDI' ('-')? INT | 'LDA' INT | 'LDV' INT|
    'STO' INT|
    'BRN' INT | 'BZE' INT |
    'LDL' INT | 'CAL' INT | 'RET' INT
    'HLT' | 'ROB' INT
     */

    public static class ADD implements Instruction {
        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP-2] += pMachine.mem[pMachine.SP-1];
            pMachine.SP--;
            pMachine.PC++;
        }

        public String toString(){
            return "ADD";
        }
    }

    public static class SUB implements Instruction {
        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP-2] -= pMachine.mem[pMachine.SP-1];
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "SUB";
        }
    }

    public static class MUL implements Instruction {
        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP-2] *= pMachine.mem[pMachine.SP-1];
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "MULT";
        }
    }

    public static class DIV implements Instruction {
        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP-2] /= pMachine.mem[pMachine.SP-1];
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "DIV";
        }
    }

    public static class EQL implements Instruction {
        public void exec(PMachine pMachine){
            boolean res = pMachine.mem[pMachine.SP-2] == pMachine.mem[pMachine.SP-1];
            pMachine.mem[pMachine.SP-2] = res ?1:0;
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "EQL";
        }
    }
    public static class NEQ implements Instruction {
        public void exec(PMachine pMachine){
            boolean res = pMachine.mem[pMachine.SP-2] != pMachine.mem[pMachine.SP-1];
            pMachine.mem[pMachine.SP-2] = res ?1:0;
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "NEQ";
        }
    }
    public static class GTR implements Instruction {
        public void exec(PMachine pMachine){
            boolean res = pMachine.mem[pMachine.SP-2] > pMachine.mem[pMachine.SP-1];
            pMachine.mem[pMachine.SP-2] = res ?1:0;
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "GTR";
        }
    }
    public static class LSS implements Instruction {
        public void exec(PMachine pMachine){
            boolean res = pMachine.mem[pMachine.SP-2] < pMachine.mem[pMachine.SP-1];
            pMachine.mem[pMachine.SP-2] = res ?1:0;
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "LSS";
        }
    }
    public static class GEQ implements Instruction {
        public void exec(PMachine pMachine){
            boolean res = pMachine.mem[pMachine.SP-2] >= pMachine.mem[pMachine.SP-1];
            pMachine.mem[pMachine.SP-2] = res ?1:0;
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "GEQ";
        }
    }
    public static class LEQ implements Instruction {
        public void exec(PMachine pMachine){
            boolean res = pMachine.mem[pMachine.SP-2] <= pMachine.mem[pMachine.SP-1];
            pMachine.mem[pMachine.SP-2] = res ?1:0;
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "LEQ";
        }
    }

    public static class PRN implements Instruction {
        public void exec(PMachine pMachine){
            System.out.println(pMachine.mem[pMachine.SP-1]);
            pMachine.SP--;
            pMachine.PC++;
        }
        public String toString(){
            return "PRN";
        }
    }

    public static class INN implements Instruction {
        Scanner scanner = new Scanner(System.in);
        public void exec(PMachine pMachine){
            System.out.println("-> ");
            pMachine.mem[pMachine.SP] = scanner.nextInt();
            pMachine.SP++;
            pMachine.PC++;
        }
        public String toString(){
            return "INN";
        }
    }

    public static class INC implements Instruction {
        int param;

        public INC(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            pMachine.SP += param;
            pMachine.PC++;
        }
        public String toString(){
            return "INC " +param;
        }
    }

    public static class LDI implements Instruction {
        int param;

        public LDI(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP] = param;
            pMachine.SP++;
            pMachine.PC++;
        }
        public String toString(){
            return "LDI " +param;
        }
    }
    public static class LDA implements Instruction {
        int param;

        public LDA(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP] = param;
            pMachine.SP++;
            pMachine.PC++;
        }
        public String toString(){
            return "LDA " +param;
        }
    }

    public static class LDV implements Instruction {
        int param;

        public LDV(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            int src = pMachine.mem[pMachine.SP-1];
            int dest = pMachine.SP-1;
            for (int i=0; i<param;i++)
                pMachine.mem[dest+i] = pMachine.mem[src+i];
            pMachine.SP += param-1;
            pMachine.PC++;
        }
        public String toString(){
            return "LDV " + param;
        }
    }

    public static class STO implements Instruction {
        int param;

        public STO(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            int dest = pMachine.mem[pMachine.SP-1-param];
            int src = pMachine.SP-param;
            for (int i=0; i<param;i++)
                pMachine.mem[dest+i] = pMachine.mem[src+i];
            pMachine.SP -=param+1;
            pMachine.PC++;
        }
        public String toString(){
            return "STO " + param;
        }
    }

    public static class BRN implements Instruction {
        int param;

        public BRN(int param) {
            this.param = param;
        }

        public void setParam(int param) {
            this.param = param;
        }
        public void exec(PMachine pMachine){
            pMachine.PC = param;
        }
        public String toString(){
            return "BRN " +param;
        }
    }

    public static class BZE implements Instruction {
        int param;

        public BZE(int param) {
            this.param = param;
        }

        public void setParam(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            if (pMachine.mem[pMachine.SP-1] == 0)
                pMachine.PC = param;
            else
                pMachine.PC++;
            pMachine.SP--;
        }

        public String toString(){
            return "BZE " +param;
        }
    }

    public static class CAL implements Instruction {
        int param;

        public CAL(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP] = pMachine.PC +1;
            pMachine.mem[pMachine.SP+1] = pMachine.base;
            pMachine.SP+=2;
            pMachine.PC = param;
            pMachine.base = pMachine.SP;
        }

        public String toString(){
            return "CAL " +param;
        }
    }

    public static class RET implements Instruction {
        int param;

        public RET(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            pMachine.SP = pMachine.base-2-param;
            pMachine.PC = pMachine.mem[pMachine.base-2];
            pMachine.base = pMachine.mem[pMachine.base-1];
        }

        public String toString(){
            return "RET " +param;
        }
    }

    public static class LDL implements Instruction {
        int param;

        public LDL(int param) {
            this.param = param;
        }

        public void exec(PMachine pMachine){
            pMachine.mem[pMachine.SP] = param + pMachine.base;
            pMachine.SP++;
            pMachine.PC++;
        }
        public String toString(){
            return "LDL " +param;
        }
    }
/*
    public static class ROB implements Instruction {
        int param;
        int res;
        public ROB(int param, int res) {
            this.param = param;
            this.res=res;
        }

        public void exec(PMachine pMachine){
            for (int i=0;i<param;i++)
                pMachine.liaisonSerie.write(pMachine.mem[pMachine.SP - param +i]);
            pMachine.SP-= param;
            for (int i=0;i<res;i++)
                pMachine.mem[pMachine.SP+i] = pMachine.liaisonSerie.read();
            pMachine.SP+= res;
            pMachine.PC++;
        }

        public String toString(){
            return "ROB " +param + " " + res;
        }
    }
*/
    public static class SLE implements Instruction {

        public void exec(PMachine pMachine){
            try {
                Thread.sleep(pMachine.mem[pMachine.SP - 1]);
            } catch (Exception e){e.printStackTrace();};
            pMachine.SP--;
            pMachine.PC++;
        }

        public String toString(){
            return "SLE";
        }
    }


    public static class HLT implements Instruction {
        public String toString(){
            return "HLT";
        }
        public void exec(PMachine pMachine){
            pMachine.run = false;
        }
    }
}
