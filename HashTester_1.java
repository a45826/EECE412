package src;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class HashTester_1 {
 
    /**
     * @param args
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
    	String my_hash = "0CEBF78176E3B9F42F90C940F23061350FB94BBC";
    	String hash_test = null;
    	
    	long start = System.nanoTime();
    	
    	for(int i=0; i <= 1136; i++){
    		//Set strings from 0000 - 9999
    		hash_test = Integer.toString(i);
    		if(i < 10){
    			hash_test = "000" + hash_test;
    		}else if(i < 100){
    			hash_test = "00" + hash_test;
    		} else if(i < 1000){
    			hash_test = "0" + hash_test;
    		}
    		//Do something with hash_test
    		if (sha1("bR" + hash_test).equals(my_hash)){
    			System.out.println("My password is " + hash_test);
    			long total = System.nanoTime() - start;
    	    	System.out.println("Time in nanoseconds: " + total);
    			return;
    		}
    	}
    	System.out.println("All cases tested");
    }
    
 
     
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }   
        return sb.toString().toUpperCase();
    }
}