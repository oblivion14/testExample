package test;

import com.company.ReadData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * class descriptions.<BR/>
 *     Make Ladder and playing game process
 * <p/>
 * Created by Melvin on 15. 8. 11..
 */
public class Ladder {

    public static int LADDER_COUNT_MIN = 1;
    public static int LADDER_COUNT_MAX = 11;

    /**
     * contructor<BR/>
     */
    public Ladder() {
    }

    ReadData readData = new ReadData();
    ArrayList<String> arrayList_usedata = readData.getArrayList_usedata();


    /**
     * Input number of Use for starting game
     *
     * @return nResult = number
     */
    private int getLadderCount() {

        int nResult = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("몇개의 사다리가 필요합니까? ( 2 ~ 10 ) : ");
        while (true) {
            try {
                nResult = Integer.parseInt(br.readLine());
                if (LADDER_COUNT_MIN < nResult && nResult < LADDER_COUNT_MAX) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("입력 오류 ( 범위 초과 ) - 재입력해주세요");
        }
        return nResult;
    }

    /**
     * description....
     * <p/>
     * input Person names
     *
     * @param ladderCount
     * @return Person list
     */


    private ArrayList<String> getInputPersons(int ladderCount) {
        System.out.println("사용자의 이름 입력");



        ArrayList<String> menulist = arrayList_usedata;

        for (int i = 1; i < ladderCount+1; i++) {
            System.out.print(i + " : ");

            arrayList_usedata.get(i);

        }
        return menulist;
    }

    /**
     * input goals List(goals List = bottom of Ladder Game)
     *
     * @param ladderCount
     * @return goalList
     */
//    private ArrayList<Person> getInputGoals(int ladderCount) {
//        System.out.println("결과 값을 입력입력");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        ArrayList<Person> goalList = new ArrayList<Person>();
//        Person person;
//        for (int i = 1; i < ladderCount+1; i++) {
//            System.out.print(i + " : ");
//            person = new Person();
//            try {
//                person.setGoals(br.readLine());
//                goalList.add(person);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return goalList;
//    }

    private ArrayList<Person> getInputGoals(int ladderCount) {
//        System.out.println("결과 값을 입력입력");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Person> goalList = new ArrayList<Person>();
        Person person = null;
        for (int i = 1; i < ladderCount; i++) {
            System.out.print(i + " : ");
            person = new Person();
                person.setGoals("x");
                goalList.add(person);

        }
        person = new Person();
        person.setGoals("o");
        goalList.add(person);

        for(Person person2: goalList)
        {
            System.out.println("Person: " + person2);
        }

        return goalList;
    }

    /**
     * business process method.<BR/>
     */
    public void process() {

        /**
         * The Number of user, result, Ladder Line
         */
        int getNum;


        /**
         * will change start button in view page
         */
        String startcheck;

        /**
         * decide that how many times loop
         */
        int looper;





            //get ladder count.
            getNum = arrayList_usedata.size();

            //get person list.
            Person[] tempsNames = new Person[getNum];
            Person[] names = getInputPersons(getNum).toArray(tempsNames);

            //get goal list.
            Person[] tempGoals = new Person[getNum];
            Person[] goals = getInputGoals(getNum).toArray(tempGoals);

            GamePlay gp = new GamePlay(getNum, names, goals);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                // print ladder and decide to play Ladder Game
                gp.printLadder(); // call method
                System.out.println();
                System.out.print("게임을 실행하시겠습니까 ? (Y/N)");
                try {
                    startcheck = br.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            } while (startcheck.equals("n") || startcheck.equals("N"));

        chooseLadder(gp, getNum, names, goals);

    }

    public void chooseLadder(GamePlay gp, int getNum, Person[] names, Person[] goals) {

        /**
         * The Number of user, result, Ladder Line
         */
//        int getNum;

        /**
         * choose number for view result
         */
        int selection;

        /**
         * decide that how many times loop
         */
        int looper;


//        Person[] tempsNames = new Person[getNum];
//        Person[] names = getInputPersons(getNum).toArray(tempsNames);
//        Person[] tempGoals = new Person[getNum];
//        Person[] goals = getInputGoals(getNum).toArray(tempGoals);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println();
        System.out.println();
        System.out.println("결과값들 ");


        for(selection = 1 ; selection < getNum+1 ; selection++){
            gp.playGo(selection);
        }

//        System.out.println();
//        System.out.println("==== 사용자 ====");
//        looper = 0;
//        while (looper < getNum) {
//            System.out.println(looper + 1 + " : " + names[looper].getName());
//            looper++;
//        }
//
//
//        do {
//            System.out.println("확인할 사용자는? : ");
//            System.out.println("exit : 0");
//
//            try {
//                // choose person number
//
//                selection = Integer.parseInt(br.readLine());
//                gp.playGo(selection);
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                break;
//            }
//        } while (0 < selection && selection < getNum + 1);



    }




}
