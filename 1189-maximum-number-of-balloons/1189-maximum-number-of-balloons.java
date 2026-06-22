class Solution {
    public int maxNumberOfBalloons(String text) {

        int n = text.length();
        int cnt = 0;

        int bcnt = 0;
        int acnt = 0;
        int lcnt =0;
        int ocnt = 0;
        int ncnt = 0;

        for(int i = 0; i < n; i++){
            if(text.charAt(i) == 'b'){
                bcnt++;
            }
            else if(text.charAt(i) == 'a'){
                acnt++;
            }
            else if(text.charAt(i) == 'l'){
                lcnt++;
            }
            else if(text.charAt(i) == 'o'){
                ocnt++;
            }
            else if(text.charAt(i) == 'n'){
                ncnt++;
            }

            
        }

        return Math.min(Math.min(bcnt, acnt), Math.min(Math.min(lcnt/2, ocnt/2),ncnt));
        
    }
}