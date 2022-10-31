public class DemSoLanXuatHienKyTuTrongChuoi {

    //    Cach 1:
    static void DemKyTu(String str) {
        int[] counter = new int[256];

        for (int i = 0; i < str.length(); i++) {
            counter[str.charAt(i)]++;
        }

        char[] array = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i);

            int flag = 0;

            for (int j = 0; j <= i; j++) {
                if (array[i] == str.charAt(j)) {
                    flag++;
                }
            }
            if (flag == 1) {
                System.out.println("Số lần xuất hiện của " + array[i]
                        + " trong chuỗi:" + counter[str.charAt(i)]);
            }
        }
    }

    //Cach 2:


    public static void main(String[] args) {
        String str = "HHHHHHHello world";
        System.out.println("Chuỗi là: " + str);
        DemKyTu(str);
    }
}
