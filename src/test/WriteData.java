package test;

import com.company.ReadData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Melvin on 15. 9. 10..
 */
public class WriteData {

//    public void ReadFile(ReadData readData){
//        readData.getArrayList_usedata()
//    }

    public WriteData() {
        //파일 읽어서 object 저장.
        ReadData readData = new ReadData();
        File file = new File("test.txt");

        //파일 유무 확인
        if (file.exists()) {
            System.out.println("");
            System.out.println("기존 파일에 작성합니다.");
        } else {
            try {
                file.createNewFile();
                System.out.println("새 파일에 작성합니다.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayList<String> arrayList_usedata = readData.getArrayList_usedata();
        //사용자 입력
        readData.SetArrayList();

        System.out.println(" ");
        System.out.println("데이터를 입력합니다. (0 종료)");


        while (true) {
            Scanner scn = new Scanner(System.in);
            String inputedData = scn.next();

            System.out.println("");

            //"0"인지 확인
            //...
            if (inputedData.equals("0")) {
                System.out.println("데이터 입력이 완료되었습니다.");
                //m_writer.close();
                System.exit(0);

            } else if (isChecked(arrayList_usedata, inputedData)) {

                //기존 데이터와 입력받은 데이터 중복 체크


            } else {

                try {
                    System.out.println("데이터가 입력되었습니다. ");
                    FileWriter m_writer = new FileWriter("test.txt", true);

                    m_writer.write(inputedData + "\n");
                    //arrayList_usedata.add(inputedData);
                    //readData.SetArrayList();
                    System.out.println("");
                    m_writer.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //readData.setArrayList_usedata(arrayList_usedata);

        }
    }

    public boolean isChecked(ArrayList arrayList, String s) {

        boolean ischeck = false;

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(s)) {
                //m_writer.close();
                System.out.println("중복되었습니다.");
                System.out.println("");
                //중복 알려주라.
                ischeck = true;
                //dk
                // m_writer.close();
                return ischeck;


            }

        }
        return ischeck;

    }
}



            //파일 저장

//            try {
//                FileWriter m_writer = new FileWriter("test.txt", true);
//
//                m_writer.write(inputedData + "\n");
//                m_writer.close();
//
////            readData.setArrayList_usedata(arrayList_usedata);
////            readData.SetArrayList();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}


//        while(true){
//            try{
//
//                FileWriter m_writer = new FileWriter(data, true);
//                String tmp_str = scn.next();
//
//                    //escape
//                if (tmp_str.equals("0")){
//                    break;
//                }
//
//                /**
//                 * 수정 필요
//                 */
//                //비교 로직
////                else if (tmp_str.equals(data)){
////                    break;
////                }
//
//                //new FileDao(tmp_str);
//
//                else {
//                    m_writer.write(tmp_str + "\n");
//                    m_writer.close();
//                }
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            readData.setArrayList_usedata(arrayList_usedata);
//            readData.SetArrayList();
//
//        }
//    }
//}