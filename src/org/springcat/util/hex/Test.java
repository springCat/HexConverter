package org.springcat.util.hex;
public class Test {

    public static void main(String[] args){
        HexConverter c = new HexConverter();
        Long max = Long.MAX_VALUE;    
        Long zero = 0L;
        Long min = Long.MIN_VALUE;
        
        System.out.println("-------default start------");      
        System.out.println("max:"+max);
        String cmax = c.encode(max);
        System.out.println("cmax:"+cmax);
        Long imax = c.decode(cmax);
        System.out.println("imax:"+imax);
        
        System.out.println("zero:"+zero);
        String czero = c.encode(zero);
        System.out.println("czero:"+czero);
        Long izero = c.decode(czero);
        System.out.println("izero:"+izero);
        
        
        System.out.println("min:"+min);
        String cmin = c.encode(min);
        System.out.println("cmin:"+cmin);
        Long imin = c.decode(cmin);
        System.out.println("imin:"+imin);  
        
        System.out.println("-------default end ------");

        SaltGenerator gen = new SaltGenerator();
        
        System.out.println("-------62 start------");
        String salt62 = gen.generateSalt(62);
        System.out.println("salt62:"+salt62);
        
        HexConverter c62 = new HexConverter(salt62,62);
        System.out.println("max:"+max);
        String c62max = c62.encode(max);
        System.out.println("cmax:"+c62max);
        Long i62max = c62.decode(c62max);
        System.out.println("imax:"+i62max);
        
        System.out.println("zero:"+zero);
        String c62zero = c62.encode(zero);
        System.out.println("c62zero:"+c62zero);
        Long i62zero = c62.decode(c62zero);
        System.out.println("i62zero:"+i62zero);
        
        
        System.out.println("min:"+min);
        String c62min = c62.encode(min);
        System.out.println("c62min:"+c62min);
        Long i62min = c62.decode(c62min);
        System.out.println("i62min:"+i62min);    
        System.out.println("-------62 end------");
        
        System.out.println("-------36 start------");
        String salt36 = gen.generateSalt(36);
        System.out.println("salt36:"+salt36);
        
        HexConverter c36 = new HexConverter(salt36,36);
        System.out.println("max:"+max);
        String c36max = c36.encode(max);
        System.out.println("cmax:"+c36max);
        Long i36max = c36.decode(c36max);
        System.out.println("imax:"+i36max);
        
        System.out.println("zero:"+zero);
        String c36zero = c36.encode(zero);
        System.out.println("c36zero:"+c36zero);
        Long i36zero = c36.decode(c36zero);
        System.out.println("i36zero:"+i36zero);
        
        
        System.out.println("min:"+min);
        String c36min = c36.encode(min);
        System.out.println("c36min:"+c36min);
        Long i36min = c36.decode(c36min);
        System.out.println("i36min:"+i36min);    
        System.out.println("-------36 end------");
        
        
        System.out.println("-------2 start------");
        String salt2 = gen.generateSalt(2);
        System.out.println("salt2:"+salt2);
        
        HexConverter c2 = new HexConverter(salt2,2);
        System.out.println("max:"+max);
        String c2max = c2.encode(max);
        System.out.println("cmax:"+c2max);
        Long i2max = c2.decode(c2max);
        System.out.println("imax:"+i2max);
        
        System.out.println("zero:"+zero);
        String c2zero = c2.encode(zero);
        System.out.println("c2zero:"+c2zero);
        Long i2zero = c2.decode(c2zero);
        System.out.println("i2zero:"+i2zero);
        
        
        System.out.println("min:"+min);
        String c2min = c2.encode(min);
        System.out.println("c2min:"+c2min);
        Long i2min = c2.decode(c2min);
        System.out.println("i2min:"+i2min);    
        System.out.println("-------2 end------");
    }

}