/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsersite;

import java.net.URL;
import java.util.logging.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import static parsersite.ParserSite.log;

/**
 *
 * @author evgeniy
 */
public class JaxbParser {

    public Object getObject(URL url, Class c) {

        Object object = null;

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = jaxbUnmarshaller.unmarshal(url);
//            object = jaxbUnmarshaller.unmarshal(new File("/home/evgeniy/NetBeansProjects/parserSite/src/parsersite/response1.xml"));

        } catch (JAXBException ex) {
            log.log(Level.WARNING, ex.getMessage());
        }

        return object;
    }

}
