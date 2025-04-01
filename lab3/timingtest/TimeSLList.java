package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int m=10000;
        AList<Integer> Ns = new AList<>();
        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for(int i=0;i<Ns.size();++i){
            opCounts.addLast(m);
        }
        for(int i=0;i<Ns.size();++i){
            int n= Ns.get(i);
            SLList<Integer> tested=new SLList();
            for(int j=0;j<n;++j){
                tested.addLast(j);
            }
            Stopwatch sw=new Stopwatch();
            for(int j=0;j<m;++j){
                tested.getLast();
            }
            times.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns,times,opCounts);
    }

}
