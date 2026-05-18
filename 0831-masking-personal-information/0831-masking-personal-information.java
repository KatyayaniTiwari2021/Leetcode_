class Solution {
    public String maskPII(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        if(Character.isLetter(s.charAt(n-1))){
            s = s.toLowerCase();   
            int idx = 0;

            while(idx < n  && s.charAt(idx) != '@'){
                idx++;

            }

            sb.append(s.charAt(0));
            sb.append("*****");
            sb.append(s.charAt(idx-1));
            sb.append(s.substring(idx,n));


        }
        else{

            int digit = 0;
            for(int i = 0; i < n; i++){
                if(isDigit(s.charAt(i))){
                    digit++;
                }
            }
            
            
            if(digit == 10){
                int cnt = 3;

                for(int i = n - 1; i >= 0; i--){
                    if(cnt < 0) break;

                    if(isDigit(s.charAt(i))){
                        sb.append(s.charAt(i));
                        cnt--;
                    }
                    
                }

                sb.append("-***-***");

                
            }else if(digit == 11){
                int cnt = 3;

                for(int i = n - 1; i >= 0; i--){
                    if(cnt < 0) break;

                    if(isDigit(s.charAt(i))){
                        sb.append(s.charAt(i));
                        cnt--;
                    }
                    
                }
                sb.append("-***-***-*+");

            }else if(digit == 12){
                int cnt = 3;

                for(int i = n - 1; i >= 0; i--){
                    if(cnt < 0) break;

                    if(isDigit(s.charAt(i))){
                        sb.append(s.charAt(i));
                        cnt--;
                    }
                    
                }
                sb.append("-***-***-**+");

            }else{
                int cnt = 3;

                for(int i = n - 1; i >= 0; i--){
                    if(cnt < 0) break;

                    if(isDigit(s.charAt(i))){
                        sb.append(s.charAt(i));
                        cnt--;
                    }
                    
                }
                sb.append("-***-***-***+");

            }

            sb.reverse();

        }

        return sb.toString();

        
    }

    private boolean isDigit(char c){
        if(c == '0' || c == '1' || c == '2' ||c == '3' ||c == '4' || c == '5' ||
        c == '6' || c == '7' || c == '8' || c == '9'){
            return true;
        }

        return false;

    }
}