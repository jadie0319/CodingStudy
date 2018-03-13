package Sort;

/**
 * Created by choijaeyong on 2016. 3. 27..
 */
public class SortQuiz {

    public static void main(String[] args) {
        SortQuiz_ex ex = new SortQuiz_ex();
        int dataSet[] = new int[]{2,3,4,10,29,4,23,5,12,3,51,2,3,5,1,2,2,2,2,1,1,24,6,7,2,3,4,2,1,1,1,1,1,1,1,};

        //선거 문제
        System.out.println("선거에서 이긴사람은? ");
        ex.checkWhoWinsTheElection(dataSet);


    }
}
