import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FannyMagnet {
    public static void main(String args[]) throws Exception {

//        System.setProperty("line.separator", "=");

        Properties resourceProp = readPropertiesFile("C:\\target\\base-xstore.properties");
        String configPath = resourceProp.getProperty("xstore.config.path.global.extensions");
        String mConfigPath = resourceProp.getProperty("mobile.xstore.config.path.global.extensions");
        PropertiesConfiguration properties = new PropertiesConfiguration("C:\\xstore\\updates\\base-xstore.properties");

        properties.setProperty("dtv.location.StoreNumber", resourceProp.getProperty("dtv.location.StoreNumber"));
        properties.setProperty("dtv.location.CountryId", resourceProp.getProperty("dtv.location.CountryId"));
        properties.setProperty("dtv.location.CurrencyId", resourceProp.getProperty("dtv.location.CurrencyId"));
        properties.setProperty("dtv.location.OrganizationId", resourceProp.getProperty("dtv.location.OrganizationId"));
        properties.setProperty("dtv.location.TerminalId", resourceProp.getProperty("dtv.location.TerminalId"));
        properties.setProperty("xstore.config.path.global.extensions", configPath);
        properties.setProperty("dtv.keystore.password", resourceProp.getProperty("dtv.keystore.password"));
        properties.setProperty("mobile.dtv.location.TerminalId", resourceProp.getProperty("mobile.dtv.location.TerminalId"));
        properties.setProperty("mobile.xstore.config.path.global.extensions", mConfigPath);

        properties.save();

        Properties resourceXProp = readPropertiesFile("C:\\target\\xstore.properties");
        PropertiesConfiguration xProperties = new PropertiesConfiguration("C:\\xstore\\updates\\xstore.properties");
        xProperties.setProperty("chl.vertical", resourceXProp.getProperty("chl.vertical"));
        xProperties.setProperty("chl.brand", resourceXProp.getProperty("chl.brand"));
        xProperties.setProperty("chl.email.brandname", resourceXProp.getProperty("chl.email.brandname"));
        xProperties.setProperty("chl.email.storePhnum", resourceXProp.getProperty("chl.email.storePhnum"));
        xProperties.setProperty("chl.chl.email.storeemail", resourceXProp.getProperty("chl.email.storeemail"));
        xProperties.setProperty("chl.email.storeaddress", resourceXProp.getProperty("chl.email.storeaddress"));
        xProperties.setProperty("chl.email.emailbody", resourceXProp.getProperty("chl.email.emailbody"));
        xProperties.setProperty("chl.rounding", resourceXProp.getProperty("chl.rounding"));
        xProperties.setProperty("chl.adv.rounding.isRequired", resourceXProp.getProperty("chl.adv.rounding.isRequired"));
        xProperties.setProperty("chl.adv.rounding.scaleValue", resourceXProp.getProperty("chl.adv.rounding.scaleValue"));
        xProperties.setProperty("chl.adv.promo.rounding.scaleValue", resourceXProp.getProperty("chl.adv.promo.rounding.scaleValue"));
        xProperties.setProperty("chl.chl.adv.rounding.roundingType", resourceXProp.getProperty("chl.adv.rounding.roundingType"));
        xProperties.setProperty("chl.adv.promo.rounding.roundingType", resourceXProp.getProperty("chl.adv.promo.rounding.roundingType"));
        xProperties.setProperty("chl.demographicInfo.enable", resourceXProp.getProperty("chl.demographicInfo.enable"));
        xProperties.setProperty("chl.demographic.enable", resourceXProp.getProperty("chl.demographic.enable"));
        xProperties.setProperty("chl.siminventory.enabled", resourceXProp.getProperty("chl.siminventory.enabled"));
        xProperties.setProperty("chl.musepromotion.enabled", resourceXProp.getProperty("chl.musepromotion.enabled"));
        xProperties.setProperty("chl.ArabicLinePrintingEnabled", resourceXProp.getProperty("chl.ArabicLinePrintingEnabled"));

        xProperties.save();

    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

}
