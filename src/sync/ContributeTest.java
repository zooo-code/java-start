package sync;

public class ContributeTest {


    public static void main(String[] args) {

        Contributor[] contributors = new Contributor[10];
        Contribution contribution = new Contribution();
        for (int i = 0; i < 10; i++) {
            contributors[i] = new Contributor(contribution, " Contributor" + i);

        }

        for(int loop= 0 ; loop <10 ; loop++){
            contributors[loop].start();
        }
    }
}
