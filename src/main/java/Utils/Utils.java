
package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leandro Cappiello
 */
public  class Utils {
    public static List<String> tagsStringToList (String tagsString) {
        if (tagsString != null){
            String[] tagsArray = tagsString.split(",");
            List<String> tags = Arrays.asList(tagsArray);
            return tags;            
        } else {
            List<String> tags = new ArrayList();
            return tags;
        }
    }
    
    public static String tagsListToString (List<String> tagsList) {
        if (!tagsList.isEmpty()) {
            String tagsString = new String();
            tagsString = String.join(", ", tagsList);
            return tagsString;            
        } else {
            return null;
        }
    }
}
