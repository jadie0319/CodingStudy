package Sort;

/**
 * Created by choijaeyong on 2016. 3. 27..
 */
public class SortQuiz_ex {
    public void checkWhoWinsTheElection(int A[]){
        int i,j,candidate=0;
        int counter = A[0];
        int maxcounter=0;
        for(i=0 ; i < A.length; i++) {
            candidate = A[i];
            counter=0;
            for(j=i+1 ; j < A.length ; j++) {
                if(A[i]==A[j])
                    counter++;
            }
            if(counter > maxcounter) {
                maxcounter = counter;
                candidate = A[i];
            }
        }
        System.out.println(candidate + " 후보자가 " + maxcounter +" 득표수로 승리하였다");
    }
}
