package utillits;
import com.mifmif.common.regex.Generex;

public class RandomGenerator {

    public static String randomEmailGenerator(){
         String rand = "\\w{10}\\@mail\\.com";
         String EmailId = new Generex(rand).random();
         System.out.println("The Email id is : "+EmailId);
         return EmailId;
    }
}
