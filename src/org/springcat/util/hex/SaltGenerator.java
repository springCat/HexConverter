package org.springcat.util.hex;
import java.util.Random;

public class SaltGenerator
{
    
    private final static String raw = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private String salt;
    
    public SaltGenerator(){
        this.salt = raw;
    }
    
    public SaltGenerator(String salt){
        this.salt = salt;
    }
    /**
     * length must > 2 and default < salt.length
     * 
     *
     * @author springcat
     * @param length
     * @return
     */
    public String generateSalt(int length){
        if(length < 2 || length > salt.length()){
            return "";
        }
        int[] random = new int[length];
        initRadom(random);
        
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < random.length; i++){
            sb.append(salt.charAt(random[i]));
        }
        return sb.toString();
    }
    
    /**
     *
     * @author springcat
     * @param array
     */
    private void initRadom(int[] array){
        Random rd = new Random();
        boolean isExit;
        int len = array.length;
        int saltLen = salt.length();
        for (int i = 0; i < len; i++){
            isExit = false;
            int num = rd.nextInt(saltLen);
            for (int j = 0; j < i; j++){
                if (array[j] == num){
                    isExit = true;
                    i--;
                    break;
                }
            }
            if (!isExit){
                array[i] = num;
            }
        }
    }
    
}
