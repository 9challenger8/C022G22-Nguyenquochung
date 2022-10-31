public class Cong2Chuoi {

    public static void main(String[] args) {
        String str1 = "11:20:30";
        String str2 = "13:20:30";

        String[] arr1 =str1.split(":");
        String[] arr2 =str2.split(":");

        int hour =Integer.parseInt(arr1[0])+Integer.parseInt(arr2[0]) ;
        int minute = Integer.parseInt(arr1[1])+Integer.parseInt(arr2[1]);
        int second = Integer.parseInt(arr1[2])+Integer.parseInt(arr2[2]);

        if(second>=60){
            second -=60;
            minute+= 1;
        }
        if (minute>=60){
            minute-=60;
            hour+=1;
        }
        if(hour>=24){
            hour-=24;
        }

        System.out.println(hour+":"+minute+":"+second);
    }
}
