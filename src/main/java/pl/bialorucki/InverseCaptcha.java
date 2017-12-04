package pl.bialorucki;

public class InverseCaptcha {
    public static int sum(String digits){
        int result = 0;

        //check the last digit
        char firstChar = digits.charAt(0);
        char lastChar = digits.charAt(digits.length()-1);

        int firstDigit = Integer.parseInt(String.valueOf(firstChar));
        int lastDigit = Integer.parseInt(String.valueOf(lastChar));

        if(lastDigit == firstDigit)
            result+=lastDigit;

        for(int i = 0 ; i < digits.length()-1;i++){
            if(digits.charAt(i) == digits.charAt(i+1)){
                int digit = Integer.parseInt(String.valueOf(digits.charAt(i)));
                result+=digit;
            }
        }
        return result;
    }
}
