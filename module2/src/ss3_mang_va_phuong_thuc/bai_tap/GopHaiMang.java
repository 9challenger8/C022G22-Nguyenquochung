package ss3_mang_va_phuong_thuc.bai_tap;

public class GopHaiMang {
    public static void main(String[] args) {
        int [] prices={3,2,10,1,4,5};
        int asset=10;

        int tien =solution(prices,asset);

        System.out.println(" so tien:"+tien);

    }

    public static int solution(int[] prices, int asset) {
        int maxMoney;
        int min=prices[0];
        int max=prices[0];
        int dayMax=0;
        int dayMin=0;
        for(int i=0;i<prices.length;i++){
            if(max<prices[i]){
                max=prices[i];
                dayMax=i;
            }
        }
        for(int i=0;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
                dayMin=i;
            }
        }
        int monney = asset - min + max;
        if(dayMax>dayMin){
            maxMoney=Math.max(monney, asset);
        }else {
            maxMoney=asset;
        }
        return maxMoney ;
    }
}
