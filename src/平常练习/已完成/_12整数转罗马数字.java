package 平常练习.已完成;


public class _12整数转罗马数字{
    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(1, 2));
    }

    /*
     * 算是贪心，可大的拿
     */
    public static String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<values.length;i++){
            //为什么可以直接获得values[i]呢，题目的最大值是3999，直接从千位获取
            while(num>=values[i]){
                sb.append(rom[i]);
                num-=values[i];
            }
            if(num==0) break;
        }

        return sb.toString();
    }
}