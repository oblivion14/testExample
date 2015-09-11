package test;

/**
 * Created by Melvin on 15. 8. 11..
 */
public class GamePlay {

    public static int LADDER_WIDTH = 8;
    public static int MAKE_RAN_LADDER = 5;
    public static int ARRAY_ROWS = 20;

    private int num;
    private Person names[];
    private Person goals[];
    private int[][] ladder;


    GamePlay(int num, Person[] names, Person[] goals) {
        this.num = num;
        this.names = names;
        this.goals = goals;

    }

    Ladder ld = new Ladder();

    void playGo(int getStartNumber) {

        int i;
        int j = 0;
        int ladderCopy[][] = new int[ARRAY_ROWS][(num - 1) * LADDER_WIDTH + 1]; // 생성한 사다리 카피

        for (int m = 0; m < ARRAY_ROWS; m++) {
            for (int n = 0; n < (num - 1) * LADDER_WIDTH + 1; n++) {
                ladderCopy[m][n] = ladder[m][n];
            }
        } // 사다리 사본 만들어 사용

        //이동 포인트 계산, 판단
        //..
//        switch()
//        {
//            //제일 좌측이면
//            case 1:
//                //제일 촤측일 때 비지니스
//                break;
//            //제일 우측이면
//            case 2:
//            case 3:
//            case 4:
//        }
        i = (getStartNumber - 1) * LADDER_WIDTH; // 사다리 이동 포인트
        while (j < ARRAY_ROWS && i < ((num - 1) * LADDER_WIDTH + 1)) {  // 사다리 범위 내에서

            if (i == 0) {
                if (ladderCopy[j][i + 1] != -1) {
                    ladderCopy[j++][i] = getStartNumber;
                } //if

                else if (ladderCopy[j][i + 1] == -1) {  // 좌측 세로선에서 가로선을 만나면
                    ladderCopy[j][i++] = getStartNumber;
                    for (int k = 0; k < LADDER_WIDTH - 1 ; k++) {  // 우측으로 7칸씩 이동
                        ladderCopy[j][i++] = getStartNumber;
                    } //for
                } //else if
            } //if

            else if (i == (num - 1) * LADDER_WIDTH) {
                if (ladderCopy[j][i - 1] != -1) { //우측 세로선에서 가로선을 만날때까지 내려간다
                    ladderCopy[j++][i] = getStartNumber;
                } else if (ladderCopy[j][i - 1] == -1) {
                    ladderCopy[j][i--] = getStartNumber;
                    for (int k=0 ;  k < LADDER_WIDTH - 1 ; k++) { // 좌측으로 7칸씩 이동
                        ladderCopy[j][i--] = getStartNumber;
                    }
                }
            } else {
                if (ladderCopy[j][i - 1] != -1 && ladderCopy[j][i + 1] != -1) { // 중간 - 좌우 만날때 까지
                    ladderCopy[j++][i] = getStartNumber;
                } else if (ladderCopy[j][i - 1] == -1) {
                    ladderCopy[j][i--] = getStartNumber;
                    for (int k = 0; k < LADDER_WIDTH - 1 ; k++) {
                        ladderCopy[j][i--] = getStartNumber;
                    }

                } else if (ladderCopy[j][i + 1] == -1) {
                    ladderCopy[j][i++] = getStartNumber;
                    for (int k = 0; k < LADDER_WIDTH - 1 ; k++) {
                        ladderCopy[j][i++] = getStartNumber;
                    }
                }
            }
        }

        System.out.println(names[getStartNumber - 1].getName() + ":" +  goals[i / 8].getGoals());


        if(goals[i / 8].getGoals().equals("o")){
            System.out.println("점심은" + names[getStartNumber - 1].getName() + "(으)로 결정되었습니다. ");
        }

        /**
         * 뷰가 필요할때
         */
        // showResult(ladderCopy, getStartNumber, names[getStartNumber - 1], goals[i / 8]);

    }

    void makeLadder() {

        int looper, tempRan;
        int ranNum[] = new int[MAKE_RAN_LADDER];
        int ranNumCopy[] = new int[MAKE_RAN_LADDER];

        ladder = new int[ARRAY_ROWS][(num - 1) * LADDER_WIDTH + 1];

        for (int j = 0; j < (num - 1) * LADDER_WIDTH + 1; j++) {
            if (j % 8 == 0) {
                for (int i = 0; i < ARRAY_ROWS; i++) {
                    ladder[i][j] = -1;
                }  // 직선에 해당하는 곳에 -1 값을 넣음

                for (int p = 0; p < MAKE_RAN_LADDER; p++) { //가로선 생성조건
                    tempRan = (int) (Math.random() * ARRAY_ROWS -1 ); // 19미만의 난수
                    for (int q = 0; q < MAKE_RAN_LADDER; q++) { // 인접 가로선 금지
                        if (tempRan == ranNumCopy[q])
                            tempRan = 0;
                    }
                    ranNum[p] = tempRan;
                }

                for (int m = 0; m < MAKE_RAN_LADDER; m++) {  // COPy
                    ranNumCopy[m] = ranNum[m];
                }
            } else {
                looper = 0;
                while (looper < MAKE_RAN_LADDER) {  // 가로선 생성
                    if (ranNum[looper] > 0)
                        ladder[ranNum[looper]][j] = -1;

                    looper++;
                }
            }
        }
    }

    void printLadder() { // 랜덤 생성 사다리 출력//
        makeLadder();
        for (int looper = 0; looper < num; looper++) {
            System.out.print(names[looper].getName() + "       "); //글자수 사다리 맵핑 위해 앞자리만
        }
        System.out.println();
        for(int j=0; j<ARRAY_ROWS; j++){
            for(int i=0; i<(num-1)*LADDER_WIDTH+1; i++){
                if(ladder[j][i] == -1){ // 위에서 설정한 -1 값 이용
                    if(i % LADDER_WIDTH  == 0){
                        System.out.print("|");
                    }
                    else
                        System.out.print("-");
                }
                else System.out.print(" ");

            }
            System.out.println();
        }
        for(int looper=0; looper < num; looper++) {
            System.out.print(goals[looper].getGoals() + "       "); // 결과값 출력
        }
    }

    void showResult(int[][] ladderCopy, int getNum, Person nameValue , Person goalValue){

        for(int looper=0; looper < num; looper++){
            System.out.print(names[looper].getName()+"       ");
        }

        System.out.println();
        for(int j = 0; j <ARRAY_ROWS; j++){
            for(int i = 0 ; i < (num-1)*LADDER_WIDTH+1 ; i++ ){


                if(ladderCopy[j][i] == -1){
                    if(i%LADDER_WIDTH ==0){
                        System.out.print("|");
                    }
                    else System.out.print("-");
                    continue;
                }
                if(ladderCopy[j][i] == getNum){
                    System.out.print(getNum);
                    continue;
                }
                System.out.print(" ");
            }

            System.out.println();


        }

        for(int looper=0; looper < num; looper++){
            System.out.print(goals[looper].getGoals() + "       ");
        }

        System.out.println("");

        System.out.println(nameValue.getName() + " : " + goalValue.getGoals());

        System.out.println("");

        }


    }


