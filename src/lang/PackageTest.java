package lang;

import com.google.gson.JsonArray;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Created by nklee on 2017-04-10.
 */
public class PackageTest {


    @Test
    public void StringUtilsTest() throws Exception {
        Package pk = StringUtils.class.getPackage();
        System.out.println("implementationVersion : " + pk.getImplementationVersion());
        System.out.println("implementationVendor : " + pk.getImplementationVendor());
    }
}
