package org.springcat.util.hex;
public class HexConverter
{
    private final static String raw = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";      
    //private final static String salt = "t7QbUFBXIA4fMqhdL230euZ1owVCJR6psES5DiHOPz8NWT9xKayGvjnrklgmcY";
    //public final static String aaa = "JD92HiTZBNGKp3xQyCFa7ne8LEusPdRXfjOlYt01g5IkWohqMwAz6mbr4UVcvS";
    
    private String salt;
    
    private int scale;
    
    private int maxStringLen;

    
    /**
     * default
     */
    public HexConverter(){
        this(raw);
    }
    
    public HexConverter(String salt){   
        this(salt,salt.length());
    }
    
    public HexConverter(String salt,int scale){
        
        if(salt == null || salt.trim().length() < 2){
            throw new RuntimeException("can support this salt");
        }
        if( scale < 2 || scale > salt.length()){
            throw new RuntimeException("can support this scale");
        }
        
        this.scale = scale;
        this.salt = salt;
        this.maxStringLen = this.encode(Long.MAX_VALUE).length();
    }
    
    private Character getC(Long i){
        return salt.charAt(i.intValue());
        
    }
    
    private Integer getI(Character c){
        return salt.indexOf(c);
    }
    
    /**
     * 
     * not support if number < 0
     *  
     * @author chenzhenwei
     * @param number
     * @return
     */
    public String encode(long number){
        if(number == 0){
            return String.valueOf(getC(0L));
        }
        if(number < 0){
             return null;
        }
        StringBuilder result = new StringBuilder();
        while (number != 0L){
            result.append(getC(number % scale));
            number = number / scale;
        }
        return result.reverse().toString();
    }
    
    /**
     *  return -1 if s is empty
     * 
     *
     * @author springcat
     * @param s
     * @return
     */
    public long decode(String s){
        if(s == null || s.trim().length() == 0){
            return -1L;
        }
        long multiple = 1;
        long result = 0;
        Character c;
        int len = s.length();
        long maxScale = Long.MAX_VALUE/scale;
        for (int i = 0; i < len; i++){
            c = s.charAt(len - i - 1); 
            int index = getI(c);
            if(index > Long.MAX_VALUE || Long.MAX_VALUE/ multiple < index ){
                throw new RuntimeException("out of the Long range");
            }
            long v = index*multiple;
            if(Long.MAX_VALUE - v < result){
                throw new RuntimeException("out of the Long range");
            }
            result += v;
            if(i == len -1){
                break;
            }else{
                if (multiple > maxScale ){
                    throw new RuntimeException("out of the Long range");
                }
                multiple *=  scale;
            }
        }
        return result;
    }
    
    /**
     *  return -1 if s is empty
     * 
     *
     * @author springcat
     * @param s
     * @return
     */
    public long decodeFst(String s){
        if(s == null || s.trim().length() == 0 || s.length() >= this.maxStringLen){
            return -1L;
        }
        long multiple = 1;
        long result = 0;
        Character c;
        int len = s.length();
        for (int i = 0; i < len; i++){
            c = s.charAt(len - i - 1); 
            int index = getI(c);      
            long v = index * multiple;
            result += v;
            multiple *=  scale;
        }
        return result;
    }
 
}
