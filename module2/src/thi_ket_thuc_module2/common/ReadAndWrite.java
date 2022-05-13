package thi_ket_thuc_module2.common;

import thi_ket_thuc_module2.models.HandleMobile;
import thi_ket_thuc_module2.models.Mobile;
import thi_ket_thuc_module2.models.VipMobile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static final String MOBILE_PATH = "src/thi_ket_thuc_module2/common/data/mobile.csv";
    public static final String VIP_PATH = "src/thi_ket_thuc_module2/common/data/vipmobile.csv";
    public static final String HANDLE_PATH = "src/thi_ket_thuc_module2/common/data/handlemobile.csv";

    private static void WriteToFile(String filePath, List<String> list) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String str : list) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHandleMobile(List<HandleMobile> handleMobileList) {
        List<String> handleMobiles = new ArrayList<>();

        for (HandleMobile o : handleMobileList) {
            handleMobiles.add(o.getInFor());
        }
        WriteToFile(MOBILE_PATH, handleMobiles);
    }

    public static void writeVipMobile(List<VipMobile> vipMobileList) {
        List<String> vipMobiles = new ArrayList<>();

        for (VipMobile o : vipMobileList) {
            vipMobiles.add(o.getInFor());
        }
        WriteToFile(MOBILE_PATH, vipMobiles);
    }

    public static void writeMobile(List<Mobile> MobileList) {
        List<String> Mobiles = new ArrayList<>();

        for (Mobile o : MobileList) {
            Mobiles.add(o.getInFor());
        }
        WriteToFile(MOBILE_PATH, Mobiles);
    }

    public static <E> void writeAll(List<E> list) {
        List<String> strList = new ArrayList<>();

        for (E o : list) {
            strList.add(String.valueOf(o));
        }
        WriteToFile(MOBILE_PATH, strList);
    }

    public static List<HandleMobile> readHandleMobile() {
        List<HandleMobile> handleMobileList = new ArrayList<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(MOBILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(",");
                handleMobileList.add(new HandleMobile(Integer.parseInt(lines[1]), lines[2], lines[3], lines[4], lines[5], lines[6], lines[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handleMobileList;
    }

    public static List<VipMobile> readVipMobile() {
        List<VipMobile> vipMobiles = new ArrayList<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(MOBILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(",");
                vipMobiles.add(new VipMobile(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4], lines[5], lines[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vipMobiles;
    }
    public static List<Mobile> readMobile() {
        List<Mobile> mobiles = new ArrayList<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(MOBILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(",");
                if(lines[0].equals("Loại xách tay:")){
                mobiles.add(new HandleMobile(Integer.parseInt(lines[1]), lines[2], lines[3],
                    lines[4], lines[5], lines[6], lines[7]));
                }else if(lines[0].equals("Loại chính hãng:")) {
                    mobiles.add(new VipMobile(Integer.parseInt(lines[1]), lines[2], lines[3],
                            lines[4], lines[5], lines[6], lines[7]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mobiles;
    }
}
